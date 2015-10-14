package dancers;
/**
 * BST Node class
 * @author <a href='http://www.facebook.com/InQuirerDj'>Habib Mohammad</a>
 * @see <a href='https://en.wikipedia.org/wiki/Binary_search_tree'>Wiki BST</a>
 */
public class Node {
	
	double key = 0;
	Node parent = null, left = null, right = null;
	IDancer dancer = null;
	/**
	 * default node constructor
	 * @param d IDancer input
	 */
	public Node(IDancer d) {
		this.dancer = d;
		String key = d.getHeight() +  (d.isMale() ? "0." : "1.") + d.getID();
		this.key = Double.parseDouble(key);
		System.out.println("new node: " + this.key);
	}
	public void copy(double key, IDancer d) {
		this.dancer = d;
		this.key = key;
	}
	
	public boolean hasRight() {
		if (this.right != null) return true;
		else return false;
	}
	
	public boolean hasLeft() {
		if (this.left != null) return true;
		else return false;
	}
	
	public boolean hasParent() {
		if (this.parent != null) return true;
		else return false;
	}
	public boolean isMale() {
		if (this.dancer.isMale())
			return true;
		else return false;
	}
}