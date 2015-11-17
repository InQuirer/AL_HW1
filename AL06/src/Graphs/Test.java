package Graphs;

public class Test {
	
	public static void main(String[] args){
		int[] pair = {0,5};
		matrixToString(adjacencyMatrix);
		Friends.bfs(adjacencyMatrix, pair);
		System.out.println("connection: ");
		arrayToString(Friends.getConnectionList());
		System.out.println("distance " + Friends.getDistance());
	}
	
	static int[][] adjacencyMatrix = {
			{0,1,1,0,0,0},
			{1,0,0,1,1,0},
			{1,0,0,0,1,1},
			{0,1,1,0,0,1},
			{0,1,1,0,0,1},
			{0,0,1,1,1,0}
	};
	
	static void arrayToString(int...array) {
		for (int i : array)
			System.out.print(i + " ");
	}
	
	static void matrixToString(int[][] adjacencyMatrix) {
		for (int[] array : adjacencyMatrix) {
			arrayToString(array);
			System.out.println();
		}
		System.out.println();
	}
}
