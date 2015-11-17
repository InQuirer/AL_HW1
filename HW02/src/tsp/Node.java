package tsp;

import java.util.Arrays;

public class Node {
	
	int[] route;
	int depth = 0;
	int distance = Integer.MAX_VALUE;
	int oracle = 0;
	
	public Node(int root) { //root
		this.depth = 1;
		this.distance = 0;
		this.route = new int[]{root};
		this.oracle = oracle();
	}
	
	public Node(Node parent, int newRouteElement) {
		this.depth = parent.depth + 1;
		this.route = newRoute(newRouteElement, parent.route);
		if (depth < TSP.citiesCount) {
			this.distance = distance();
			this.oracle = oracle();
		} else {
			this.route = newRoute(route[0], route);
			this.distance = distance();
			this.oracle = distance;
		}
	}
	
	int[] newRoute(int element, int...route) {
		int[]  newRoute =  Arrays.copyOf(route, route.length + 1);
		newRoute[route.length] = element;
		return newRoute;
	}
	
	/**
	 * @param route array of cities to pass
	 * @param adjacencyMatrix original adjacencyMatrix
	 * @return route length
	 */
	int distance() {
		int distance = 0;
		for (int i = 0; i < route.length-1; i++)
			distance += TSP.adjacencyMatrix[route[i]][route[i+1]];
		return distance;
	}
	
	/**
	 * @param adjacencyMatrix original adjacencyMatrix
	 * @param route way to go trough adjacencyMatrix
	 * @return estimated minimum of the further route
	 */
	int oracle() {
		int distance = this.distance;
		distance += TSP.findMin(TSP.adjacencyMatrix[route[route.length - 1]]);
		for (int i = 0; i < TSP.adjacencyMatrix.length; i++) {
//			System.out.print(i);
			if (TSP.notVisited(i, route)) {
				distance += TSP.findMin(TSP.adjacencyMatrix[i]);
//				System.out.println(" no!");
			} //else System.out.println(" passed");
		}
		return distance;
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	public void errPrint() {
		System.err.println(this.toString());
	}
	
	public String toString() {
		String route = "";
		for (int i : this.route) {
			route += " " + i;
		}
		return ("route:" + route + "\n" + 
				"depth: " + depth + "\n" + 
				"distance: " + distance + "\n" + 
				"oracle: " + oracle + "\n");
	}
	
}
