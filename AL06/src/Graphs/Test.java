package Graphs;

public class Test {
	
	public static void main(String[] args){
		int[] pair = {1,5};
		matrixToString(testMassiiv6);
		Friends.bfs(testMassiiv6, pair);
		System.out.println("connection: ");
		arrayToString(Friends.getConnectionList());
		System.out.println("distance " + Friends.getDistance());
	}
	
	static int[][]testMassiiv6 = {
			{0,1,1,0,0,0},
			{1,0,0,1,1,0},
			{1,0,0,0,1,1},
			{0,1,0,0,0,1},
			{0,1,1,0,0,1},
			{0,0,1,1,1,0},

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
