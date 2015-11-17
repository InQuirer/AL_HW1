package tsp;
import java.util.Stack;

public class PrimaryTest {

	public static void main(String[] args) {
		Stack<int[]> al = new Stack<int[]>();
		int[] route1 = {0,1,2,3,0};
		int[] route2 = {0,1,3,2,0};
		int[] route3 = {0,2,3,1,0};
		int[] route4 = {0,2,1,3,0};
		int[] route5 = {0,3,1,2,0};
		int[] route6 = {0,3,2,1,0};
		
		al.add(route1);
		al.add(route2);
		al.add(route3);
		al.add(route4);
		al.add(route5);
		al.add(route6);
		
		int[][] adjacencyMatrix = Test.test3;
		
		for (int[] r : al) {
			int length = TSP.distance(adjacencyMatrix, r);
			System.out.println(length);
		}
		System.err.println(al.size());
		Test.findDuplicates(al);
		for (int[] a : al)
			Test.printArray(a);
		System.err.println(al.size());
	}
}
