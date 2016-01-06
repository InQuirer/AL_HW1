package maze;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import radar.Radar;
/**
 * Binary Search Tree class (BST)
 * @author <a href='http://www.facebook.com/InQuirerDj'>Habib Mohammad</a>
 * @see <a href='https://en.wikipedia.org/wiki/Binary_search_tree'>Wiki BST</a>
 */
public class Maze {
    private Radar r;

    public Maze(String fileName) {
        try {
            r = new Radar(fileName);
        } catch (IOException e) {
            r = null;
        }
    }
    public Radar getRadar() {return r;} // need for tests.
    /**
     * Explained in file 'Home Work 03.pdf'
     * @return Best possible route.
     */
    public ArrayList<Character> solve() {
		ExtendedNode en = new ExtendedNode(r);
	    ArrayList<ExtendedNode> answers = new ArrayList<ExtendedNode>();
		while (en != null) {
			while (en.hasChildren()) {
				en = en.child();
				if (en.reachedFinish())
					answers.add(en);
			}
			while (!en.hasChildren()) {
				r.move(en.getPrev());
				en = en.getParent();
				if (en == null) break;
			}
		}
        answers.sort(new Comparator<ExtendedNode>() {
			@Override
			public int compare(ExtendedNode o1, ExtendedNode o2) {
				if (o1.getWeight() > o2.getWeight())
					return 1;
				else return -1;
			}
		});
    	return answers.get(0).getRoute();
    }
	int weights(ArrayList<Character>solution) {
		int sum = 0;
		for (char c : solution) {
			r.move(c);
			int current = r.getSurroundings().current - 48;
			sum += current > 9 ? 0 : current;
		}
		return sum;
	}
    public static void main(String[] args) {
    	Maze m = null;
//    	m = new Maze("15.in");
    	m = new Maze("nm5b.maze");
        ArrayList<Character> result = m.solve();
		int sum = 0;
		for (char c : result) {
			m.r.move(c);
			int current = m.r.getSurroundings().current - 48;
			sum += current > 9 ? 0 : current;
		}
	    System.out.println(sum);
    }
}