package tsp;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class TSP {
	
	static int citiesCount;
	static int[][] adjacencyMatrix;
	static int best;
	
	static Comparator<Node> comparator = new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			if (o1.oracle > o2.oracle) return 1;
			if (o1.oracle < o2.oracle) return -1;
			return 0;
		}
	};
	
	/* Depth-first search */
	public static int[] dfs(int[][] adjacencyMatrix) {
		return dfs(adjacencyMatrix, 0);
	}
	public static int[] dfs(int[][] adjacencyMatrix, int root) {
		citiesCount = adjacencyMatrix.length;
		TSP.adjacencyMatrix = adjacencyMatrix;
		best = Integer.MAX_VALUE;
		Stack<Node> s = new Stack<Node>();
		// variables initialize and parameters reset
//		int root = 0;
		Node rootNode = new Node(root);
		Node answer = null;
		s.push(rootNode);
		while(!s.isEmpty()) {
			Node node = s.pop();
			for (Node child : routes(node)) {
				if (child.depth == citiesCount) {
					best = child.distance;
					answer = child;
				}
				if (child.oracle < best)
					s.push(child);
			}
		}
		answer.print();
		return answer.route;
	}

	/* Best first search */
	public static int[] bfs(int[][] adjacencyMatrix) {
		return bfs(adjacencyMatrix, 0);
	}
	public static int[] bfs(int[][] adjacencyMatrix, int root) {
		citiesCount = adjacencyMatrix.length;
		TSP.adjacencyMatrix = adjacencyMatrix;
		best = Integer.MAX_VALUE;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(comparator);
		// variables initialize and parameters reset
//		int root = 0;
		Node rootNode = new Node(root);
		pq.offer(rootNode);
		while (rootNode.depth < citiesCount) {
			rootNode = pq.poll();
			pq.addAll(TSP.routes(rootNode));
		}
		rootNode.errPrint();
		return rootNode.route;
	}
	
	static Node minimum (Stack<Node> list) {
		Node node = null;
		int bestResult = Integer.MAX_VALUE;
		for (Node n : list) {
			if (n.distance < bestResult) {
				bestResult = n.distance;
				node = n;
			}
		}
		return node;
	}
	
	static Node minimumNode (Stack<Node> list) {
		Node node = null;
		int bestResult = Integer.MAX_VALUE;
		for (Node n : list) {
			if (n.oracle < bestResult) {
				bestResult = n.oracle;
				node = n;
			}
		}
		return node;
	}
	
	/**
	 * @param list the original Stack
	 * @param nodes to add to the list
	 */
	static void addNodes(Stack<Node> list, Node...nodes) {
		for (Node node : nodes)
			list.add(node);
	}
	
	/**
	 * @param adjacencyMatrix original adjacencyMatrix
	 * @param route way to go trough adjacencyMatrix
	 * @return estimated minimum of the further route
	 */
	static int oracle(int...route) {
		int distance = distance(adjacencyMatrix, route);
		distance += findMin(adjacencyMatrix[route[route.length - 1]]);
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (notVisited(i, route))
				distance += findMin(adjacencyMatrix[i]);
		}
		return distance;
	}
	
	/**
	 * @param parent Node to search possible ways
	 * @param adjacencyMatrix the original adjacencyMatrix
	 * @return array of child Nodes of node
	 */
	static Collection<Node> routes(Node node) {
		Collection<Node> collection = new Stack<Node>();
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (notVisited(i, node.route)) {
				Node child = new Node(node, i);
				if (child.distance < best) collection.add(child);
			}
		} return collection;
	}
	
	/**
	 * @param element to be inserted to the end of the route
	 * @param route old route
	 * @return route with new city in the end
	 */
	static int[] newRoute(int element, int...route) {
		int[]  newRoute =  Arrays.copyOf(route, route.length + 1);
		newRoute[route.length] = element;
		return newRoute;
	}
	
	/**
	 * @param i city to check
	 * @param route current route
	 * @return true, if city has already been passed
	 */
	static boolean notVisited(int i, int...route) {
//		if (i == 0) return true; // delete?
		for (int n : route) {
			if (i == n) return false;
		}
		return true;
	}
	/**
	 * @param array to search for the minimum
	 * @return minimum value of the array
	 */
	static int findMin(int...array) {
		int minimum = Integer.MAX_VALUE;
		for (int i : array)
			if (i != 0 && minimum > i)
				minimum = i;
		return minimum;
	}
	
	/**
	 * @param route array of cities to pass
	 * @param adjacencyMatrix original adjacencyMatrix
	 * @return route length
	 */
	static int distance(int[][] adjacencyMatrix, int...route) {
		int distance = 0;
		for (int i = 0; i < route.length-1; i++)
			distance += adjacencyMatrix[route[i]][route[i+1]];
		return distance;
	}
}