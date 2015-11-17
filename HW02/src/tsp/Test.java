package tsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		ArrayList<int[]> al = new ArrayList<int[]>();
		
//		al.add(TSP.dfs(test1));
//		al.add(TSP.dfs(test2));
//		al.add(TSP.dfs(test3));
		int[] route = {0,2,1,3,4,5};
		System.out.println(TSP.distance(test0, route));
//		int bfs3[] = TSP.bfs(test1);
//		int bfs4[] = TSP.bfs(test2);
		for (int[] a : al)
			print(a);
	}
	static int[][] test1 = { //Vastus: [0 2 9 7 16 3 4 12 1 10 14 6 17 11 5 19 15 8 18 13 0 ]
        {0,22,6,43,483,96,29,186,254,334,430,94,55,13,243,227,36,275,418,180}, 
        {22,0,257,339,264,425,70,167,496,47,20,428,7,370,206,493,373,138,184,341}, 
        {6,257,0,184,71,129,303,110,376,37,163,41,100,233,247,254,460,319,360,490}, 
        {43,339,184,0,124,347,412,253,173,64,170,293,175,490,485,299,33,492,236,286}, 
        {483,264,71,124,0,334,461,478,257,391,16,18,8,335,72,415,251,114,399,15}, 
        {96,425,129,347,334,0,269,107,499,42,491,45,424,146,125,233,117,337,152,82}, 
        {29,70,303,412,461,269,0,345,375,391,230,478,119,444,49,248,137,55,389,372}, 
        {186,167,110,253,478,107,345,0,170,12,357,197,128,178,326,237,7,152,339,186}, 
        {254,496,376,173,257,499,375,170,0,81,376,244,47,387,108,83,489,258,100,384}, 
        {334,47,37,64,391,42,391,12,81,0,311,126,475,92,29,277,62,33,58,31}, 
        {430,20,163,170,16,491,230,357,376,311,0,243,312,389,85,500,404,322,417,454}, 
        {94,428,41,293,18,45,478,197,244,126,243,0,243,431,410,393,495,97,321,338}, 
        {55,7,100,175,8,424,119,128,47,475,312,243,0,143,114,488,312,415,336,46}, 
        {13,370,233,490,335,146,444,178,387,92,389,431,143,0,90,115,499,477,405,392}, 
        {243,206,247,485,72,125,49,326,108,29,85,410,114,90,0,117,256,370,150,239}, 
        {227,493,254,299,415,233,248,237,83,277,500,393,488,115,117,0,112,363,250,241}, 
        {36,373,460,33,251,117,137,7,489,62,404,495,312,499,256,112,0,358,454,269}, 
        {275,138,319,492,114,337,55,152,258,33,322,97,415,477,370,363,358,0,295,438}, 
        {418,184,360,236,399,152,389,339,100,58,417,321,336,405,150,250,454,295,0,300}, 
        {180,341,490,286,15,82,372,186,384,31,454,338,46,392,239,241,269,438,300,0}
	};
	static int[][] test2 = {
		{0,25,12,38,6,18},
		{25,0,14,3,28,13},
		{12,14,0,22,9,17},
		{38,3,22,0,14,35},
		{6,28,9,14,0,11},
		{18,13,17,35,11,0}
	};
	static int[][] test3 = {
		{0,2,1,5},
		{2,0,3,4},
		{1,3,0,9},
		{5,4,9,0}
	};
	static int[][] test4 = { // AL05 matrix
		{0,2,7,3},
		{5,0,3,4},
		{3,4,0,8},
		{6,8,9,0}
	};
	static int[][] test5 = {
		{0,51,23,7,9,34,5,34,5,76},
		{4,0,3,14,789,34,3,4,6,53},
		{5,34,0,57,8,23,3,45,6,86},
		{76,2,56,0,89,4,43,2,67,3},
		{28,67,2,59,0,154,3,5,65,8},
		{79,34,6,25,48,0,8,56,6,23},
		{79,34,6,25,48,34,0,3,34,4},
		{79,34,6,25,48,31,72,0,5,9},
		{79,34,6,25,48,9,34,56,0,53},
		{79,34,6,25,48,98,3,12,42,0}
	};
	static int[][] test6 = {
		{0,51,23,7,9,34,5,34,5,76,93},
		{4,0,3,14,789,34,3,4,6,53,96},
		{5,34,0,57,8,23,3,45,6,86,4},
		{76,2,56,0,89,4,43,2,67,3,73},
		{28,67,2,59,0,154,3,5,65,8,7},
		{23,34,6,25,48,0,8,56,6,23,37},
		{79,54,86,25,48,34,0,3,34,4,14},
		{92,34,6,25,48,31,72,0,5,9,34},
		{76,34,7,25,48,9,34,56,0,53,23},
		{79,45,6,25,48,98,3,12,42,0,48},
		{89,34,6,25,48,98,37,72,42,20,0}
	};
	static int[][] test7 = { // route: 0 8 7 12 2 5 6 10 9 1 11 4 3 0
							//  route: 0 6 5 2 12 10 7 8 3 4 11 1 9 0
		{0,47,60,68,82,93,41,41,14,54,26,14,42},
		{36,0,53,71,24,67,46,92,43,93,13,21,68},
		{63,74,0,8,68,40,122,80,91,32,52,122,98},
		{55,43,7,0,4,67,102,65,34,30,63,26,39},
		{36,118,70,6,0,61,28,99,12,50,79,100,119},
		{102,66,112,65,61,0,21,13,103,78,112,65,75},
		{29,79,38,18,93,102,0,78,88,74,13,31,120},
		{105,103,93,81,28,89,103,0,52,77,10,102,36},
		{72,66,69,127,101,97,55,20,0,87,30,36,54},
		{65,46,53,35,97,120,55,25,61,0,113,57,57},
		{77,24,84,111,69,85,103,89,29,7,0,50,7},
		{66,39,104,73,1,64,97,38,106,119,116,0,99},
		{54,71,17,79,115,125,119,119,79,100,33,84,0}
	};
	static int[][] test0 = {
		{0,1,0,1,1,0},
		{1,0,0,1,1,1},
		{0,0,0,0,1,1},
		{1,1,0,0,0,1},
		{1,1,1,0,0,0},
		{0,1,1,1,0,0}
	};
	
	static int[][] generateSymmetric(int bound) {
		int n = 0;
		Random r = new Random();
		int[][] matrix = new int[bound][bound];
		for (int i = 0; i < bound; i++) {
			for (int j = 0; j < bound; j++) {
				if (i == j) matrix[i][j] = 0;
				else {
					int k = /*i+j; */r.nextInt(bound*10);
					while (k == 0) {
						k = r.nextInt(bound);
						++n;
					}
					matrix[i][j] = k;
				}
			}
		}
//		System.err.println("catched 0: " + n + " time(s)");
		return matrix;
	}
	static int[][] generateAsymmetric(int bound) {
		int n = 0;
		Random r = new Random();
		int[][] matrix = new int[bound][bound];
		for (int i = 0; i < bound; i++) {
			for (int j = 0; j < bound; j++) {
				if (i == j) matrix[i][j] = 0;
				else {
					int k = /*i+j; */r.nextInt(bound*10);
					while (k == 0) {
						k = r.nextInt(bound);
						++n;
					}
					matrix[i][j] = r.nextInt(bound*10);
				}
			}
		}
//		System.err.println("catched 0: " + n + " time(s)");
		return matrix;
	}
	
	static void print(int...a) {
		for (int b : a) {
			System.out.print(b + " ");
		}
		System.out.println();
	}

	/**
	 * @param arrayList list with reverse duplicates to check
	 */
	static void findDuplicates(Stack<int[]> arrayList) {
		for (int[] array : arrayList) {
			int[] rev = reverseArray(array);
			for (int i = 0; i < arrayList.size(); i++) {
				if (Arrays.equals(arrayList.get(i), rev)) {
					arrayList.remove(i);
					findDuplicates(arrayList);
					return;
				}
			}
		}
	}
	
	/**
	 * @param array array to be reversed
	 * @return reversed array
	 */
	static int[] reverseArray(int[] array) {
		int length = array.length;
		int[] rev = new int[length];
		for (int i = 0; i < length; i++)
			rev[i] = array[length - i - 1];
		return rev;
	}
	
	/**
	 * @param array to convert to String
	 * @return single-line String
	 */
	static String arrayToString(int...array) {
		String s = "";
		for (int a : array)
			s += a + " ";
		return s;
	}
	
	/**
	 * @param array array to print in single line
	 */
	static void printArray(int...array) {
		System.out.println(arrayToString(array));
	}
	
	/**
	 * @param adjacencyMatrix matrix to be printed
	 */
	static void printAdjacencyMatrix(int[][] adjacencyMatrix) {
		for (int[] array : adjacencyMatrix)
			printArray(array);
	}
	
	static void printStack(Stack<Node> nodes) {
		for (Node node : nodes)
			System.out.println(node.toString());
	}
	
	/**
	 * @param adjacencyMatrix the original adjacencyMatrix
	 * @return adjacencyMatrix flipped in x and y 
	 */
	static int[][] flippedAdjacencyMatrix(int[][] adjacencyMatrix) {
		int length = adjacencyMatrix.length;
		int[][] flippedAdjacencyMatrix = new int[length][length];
		for (int y = 0; y < length; y++)
			for (int x = 0; x < length; x++)
				flippedAdjacencyMatrix[y][x] = adjacencyMatrix[x][y];
		return flippedAdjacencyMatrix;
	}
}
