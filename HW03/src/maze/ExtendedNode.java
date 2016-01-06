package maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import radar.Node;
import radar.Radar;
/**
 * Binary Search Tree class (BST)
 * @author <a href='http://www.facebook.com/InQuirerDj'>Habib Mohammad</a>
 * @see <a href='https://en.wikipedia.org/wiki/Binary_search_tree'>Wiki BST</a>
 */
public class ExtendedNode {
	private ArrayList<Character> route = new ArrayList<Character>();
	private Stack<int[]> positions = new Stack<int[]>();
	private char prev;
	private Radar r;
	private ExtendedNode parent;
	private int weight = 0;
	private int childrenCount = 0;
	private int[] position;
	private char[] compass = {'N', 'E', 'S', 'W'};
	private char[] compass180 = {'S', 'W', 'N', 'E'};
	private Stack<Direction> children = new Stack<Direction>();
	/**
	 * @param r current radar with 'zero' position.
	 */
	public ExtendedNode(Radar r) {
		this.r = r;
		this.parent = (null);
		this.prev = ('#');
		this.position = r.getPosition();
		this.children = directions();
	}
	/**
	 * @param parent Parent ExtendedNode.
	 * @param direction Direction object.
	 */
	public ExtendedNode(ExtendedNode parent, Direction direction) {
		this.r = parent.r;
		this.weight = (parent.getWeight() + direction.weight);
		this.prev = (direction.back);
		this.parent = (parent);
		this.getRoute().addAll(parent.getRoute());
		this.positions.addAll(parent.positions);
		this.position = r.getPosition();
		this.positions.add(position);
		this.getRoute().add(direction.direction);
		this.children = directions();
	}
	/**
	 * @return Next possible Direction object.
	 */
	private Direction next() {
		childrenCount--;
		return children.isEmpty() ? null : children.pop();
	}
	/**
	 * @return Next possible ExtendedNode object.
	 */
	public ExtendedNode child() {
		Direction next = next();
		r.move(next.direction);
		return new ExtendedNode(this, next);
	}
	/**
	 * @return All possible Direction objects.
	 */
	private Stack<Direction> directions() {
		Stack<Direction> children = new Stack<Direction>();
		Node n = r.getSurroundings();
		char[] c = new char[4];
		c[0] = n.north; c[1] = n.east;
		c[2] = n.south; c[3] = n.west;
		for (int i = 0; i < 4; i++) {
			int [] cPos = r.getPosition();
			switch (i) {
			case 0: cPos[1]--; break;
			case 1: cPos[0]++; break;
			case 2: cPos[1]++; break;
			case 3: cPos[0]--; break;
			default: break;
			}
			if (c[i] != '#' && compass[i] != getPrev() && notVisited(cPos)) {
				childrenCount++;
				int weight = c[i] != 'T' ? (c[i] - 48) : 0;
				children.add(new Direction(weight, compass[i], compass180[i], r.getPosition()));
			}
		}
		if (childrenCount > 1)  {
			positions.push(position);
		}
		return children;
	}
	/**
	 * @param cPos further child position.
	 * @return true if have not been there.
	 */
	private boolean notVisited(int[] cPos) {
		for (int[] pos : positions)
			if (Arrays.equals(cPos, pos))
				return false;
		return true;
	}
	/**
	 * @return true if current position is finish position.
	 */
	public boolean reachedFinish() {
		return r.getSurroundings().current == 'T';
	}
	/**
	 * Override standard method.
	 */
	public String toString() {
		String s = "Weight: " + getWeight();
		s += "\nRoute: ";
		for (char c : getRoute())
			s+= c + " ";
		s += "\nPosition: " + Arrays.toString(position);
		s += "\nPrevious: " + getPrev();
		s += "\nParent: " + ((getParent() != null) ? Arrays.toString(getParent().position) : "Null");
		s += "\nChildren count: " + childrenCount + "\n" + r.getSurroundings();
		return s;
	}

	public char getPrev() {return prev;}
	public ExtendedNode getParent() {return parent;}
	public int getWeight() {return weight;}
	public ArrayList<Character> getRoute() {return route;}
	public boolean hasChildren() {return !children.isEmpty();}
}

class Direction {
	protected int[] position;
	protected int weight;
	protected char direction;
	protected char back;
	
	protected Direction(int weight, char direction, char back, int[] position) {
		this.direction = direction;
		this.position = position;
		this.weight = weight;
		this.back = back;
	}
}
