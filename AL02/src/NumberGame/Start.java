package NumberGame;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessMyNumber g = new GuessMyNumber(320);
//		int[] array = {
//				1,2,3,4,5,6,7,8,9,10,11,12,123,32
//		};
//		int[] array = {
//				1,2,3
//		};
		int[] array = new int[1000];
		for (int i = 0; i < 1000; i++) {
			array[i] = i + 5;
		}
		System.err.println(g.playGame(array));
	}
	
	public static void print(Object o) {
		System.out.println(o.toString());
	}
}
