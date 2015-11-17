package Graphs;

import java.util.Arrays;

public class Node {
	
	int distance;
	int[] route;
	int data;
	//
	public Node(int data, int...route) {
		this.data = data;
		this.route = newRoute(data, route);
		this.distance = routeDistance(this.route);
	}
	
	static int[] newRoute(int data, int...route) {
		int[] newRoute = Arrays.copyOf(route, route.length + 1);
		newRoute[route.length] = data;
		return newRoute;
	}
	
    static int routeDistance(int...route) {
    	int distance = 0;
    	for (int i = 0; i < route.length - 1; i++) {
    		distance += Friends.adjacencyMatrix[route[i]][route[i + 1]];
    	}
    	return distance;
    }
}