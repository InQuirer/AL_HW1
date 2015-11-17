package tsp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SecondaryTest {

	public static void main(String[] args) {
		int[][] adjacencyMatrix = Test.generateAsymmetric(15);
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.oracle > o2.oracle) return 1;
				if (o1.oracle < o2.oracle) return -1;
				return 0;
			}
		});
		int[][] currentAdjacencyMatrix = adjacencyMatrix; // input matrix.
		int[][] flippedAdjacencyMatrix = Test.flippedAdjacencyMatrix(currentAdjacencyMatrix);
		Test.printAdjacencyMatrix(currentAdjacencyMatrix);
		TSP.adjacencyMatrix = currentAdjacencyMatrix;
		TSP.citiesCount = currentAdjacencyMatrix.length;
		for (int root = 0; root < currentAdjacencyMatrix.length; root++) {
			System.out.println();
			TSP.dfs(currentAdjacencyMatrix, root);
			TSP.bfs(currentAdjacencyMatrix, root);
			TSP.dfs(flippedAdjacencyMatrix, root);
			TSP.bfs(flippedAdjacencyMatrix, root);
		}
		int n = 1;
		long startTime, endTime;
		long[] times = new long[n];
		long avarageTime = 0;
		int[] result = null;

		/*_______________________________________________________________________________*/
		/*
		times = new long[n];
		avarageTime = 0;
		result = null;
		for (int i = 0; i < n; i++) {
			startTime = System.nanoTime();
			result = TSP.dfs(currentAdjacencyMatrix);
			endTime = System.nanoTime();
			times[i] = (endTime - startTime) / 10000;
		}
		for (long time : times)
			avarageTime += time;
		avarageTime = avarageTime/n;
		System.err.print("DFS: ");
		System.err.println("\tSolution: " + TSP.arrayToString(result));
		System.err.println("\tAvarage time: " + avarageTime + " ms");
		System.err.println("\tRoute Distance: " + TSP.distance(currentAdjacencyMatrix, result) + "\n");
		 */	
		/*_______________________________________________________________________________*/
		/*
		times = new long[n];
		avarageTime = 0;
		result = null;
		for (int i = 0; i < n; i++) {
			startTime = System.nanoTime();
			result = TSP.bfs(currentAdjacencyMatrix);
			endTime = System.nanoTime();
			times[i] = (endTime - startTime) / 10000;
		}
		for (long time : times)
			avarageTime += time;
		avarageTime = avarageTime/n;
		System.err.print("BFS: ");
		System.err.println("\tSolution: " + TSP.arrayToString(result));
		System.err.println("\tAvarage time: " + avarageTime + " ms");
		System.err.println("\tRoute Distance: " + TSP.distance(currentAdjacencyMatrix, result) + "\n");
		*/
		/*
		Node root = new Node(1, 0, TSP.oracle(currentAdjacencyMatrix, 0), null, 0);
		PriorityQueue<Node> nodes = new PriorityQueue<Node>(TSP.comparator);
		nodes.addAll(TSP.routes(root, currentAdjacencyMatrix));
		Node node = nodes.remove();
		nodes.addAll(TSP.routes(node, currentAdjacencyMatrix));
		Node node2 = nodes.remove();
		
		System.out.println(node2.toString());
		nodes.add(root);
		/*
		/*
		Node tmp = null;
		while (!nodes.isEmpty()) {
			tmp = nodes.pop();
			Collection<Node> collection = TSP.routes(tmp, currentAdjacencyMatrix);
			nodes.addAll(collection);
			for (Node node : nodes) {
				System.out.println(node.toString());
			}
			System.err.println("----------------");
		}
		System.err.println(tmp.toString());
//		*/
	}
}
