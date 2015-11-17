package Graphs;

import java.util.Collection;
import java.util.Stack;

public class Friends {
	
	static int[][] adjacencyMatrix = null;
	static int[] pair = null;
	static Stack<Integer> visited = new Stack<Integer>();
	static Stack<Node> stack = new Stack<Node>();
	static Node answer;
	//
    public static void bfs(int[][] adjacencyMatrix, int[] pair){
    	Friends.adjacencyMatrix = adjacencyMatrix;
    	Friends.pair = pair;
    	int startPoint = pair[0];
    	int endPoint = pair[1];
    	Node node = new Node(startPoint);
    	while (node.data != endPoint) {
    		stack.addAll(getChildren(node));
    		node = stack.get(0);
    		stack.remove(0);
    	}
    	answer = node;
    }
    
    public static int getDistance() {
    	return answer.distance;
    }
    
    public static int[] getConnectionList() {
    	return answer.route;
    }

    static Collection<Node> getChildren(Node parent) {
    	Collection<Node> s = new Stack<Node>();
    	visited.add(parent.data);
    	for (int i = 0; i < adjacencyMatrix.length; i++) {
    		if (adjacencyMatrix[parent.data][i] == 1 && notVisited(i)) {
    			Node n = new Node(i, parent.route);
    			visited.add(i); //?
    			s.add(n);
    		}
    	}
    	return s;
    }
    
    static boolean notVisited(int i) {
    	if (visited.contains(i)) return false;
    	return true;
    }

}