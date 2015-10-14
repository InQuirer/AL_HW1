package dancers;

import java.util.ArrayList;
/**
 * Binary Search Tree class (BST)
 * @author <a href='http://www.facebook.com/InQuirerDj'>Habib Mohammad</a>
 * @see <a href='https://en.wikipedia.org/wiki/Binary_search_tree'>Wiki BST</a>
 */
public class Tree {

	public Node root = null;
	/**
	 * @param female Female (IDancer), who wants to get a partner
	 * @return male partner, if found. Otherwise, null.
	 */
	public IDancer male(IDancer female) {
		Node current = search(genKey(female));
		Node tmp = succsessor(current);
		while (!tmp.isMale()) {
			tmp = succsessor(tmp);
		} return tmp.isMale() ? tmp.dancer : null;
	}
	/**
	 * @param male Male (IDancer), who wants to get a partner
	 * @return female partner, if found. Otherwise, null.
	 */
	public IDancer female(IDancer male) {
		Node current = search(genKey(male));
		Node tmp = predecessor(current);
		while (tmp.isMale()) {
			tmp = predecessor(tmp);
		} return  tmp.isMale() ? null : tmp.dancer;
	}
	/**
	 * @return Global minimum
	 */
	public Node minimum() {return minimum(this.root);}
	private Node minimum(Node node) {
		if (node.hasLeft())
			return minimum(node.left);
		else return node;
	}
	/**
	 * @return Global maximum
	 */
	public Node maximum() {return maximum(this.root);}
	public Node maximum(Node node) {
		if (node.hasRight())
			return maximum(node.right);
		else return node;
	}
	/**
	 * @param d IDancer person
	 * @return Unique key value(Double)
	 */
	public double genKey(IDancer d) {
		return Double.parseDouble(d.getHeight() +  (d.isMale() ? "0." : "1.") + d.getID());
	}

	private Node search(double key, Node current) {
		if (current.key == key) return current;
		if (current.key > key
				&& current.hasLeft())
			return search(key, current.left);
		if (current.key < key
				&& current.hasRight())
			return search(key, current.right);
		return null;
	}
	/**
	 * @param key Unique key. Use genKey(argument) to generate it.
	 * @return Node with this key
	 */
	public Node search(double key) {return search(key, this.root);}
	/**
	 * @param d IDancer person to be inserted into Tree
	 */
	public void insert(IDancer d) {
		Node dancer = new Node(d);
		Node y = null;
		if (root == null) {
			this.root = dancer;
			return;
		}
		Node x = this.root;
		while (x != null) {
			y = x;
			if (dancer.key < x.key) x = x.left;
			else x = x.right;
		} dancer.parent = y;
		if (y == null) this.root = dancer;
		else {
			if (dancer.key < y.key) y.left = dancer;
			else y.right = dancer;
		}
	}
	/**
	 * @param node Node to insert
	 * @param output = new ArrayList<IDancer>()
	 * @return Persons (IDancer), who has no partner
	 */
	public ArrayList<IDancer> inorder(Node node, ArrayList<IDancer> output) {
		if (node.hasLeft())
			inorder(node.left, output);
		output.add(node.dancer);
		if (node.hasRight())
			inorder(node.right, output);
		return output;
	}
	/**
	 * @param d Person (IDancer) to remove
	 */
	public void remove(IDancer d) {
		Node z = search(genKey(d)); //toRemove
		Node y = null; //replacer
		Node x = null;
		if (!z.hasLeft() || !z.hasRight()) 
			y = z;
		else y = succsessor(z);
		if (y.hasLeft())
			x = y.left;
		else x = y.right;
		if (x != null)
			x.parent = y.parent;
		if (!y.hasParent())
			this.root = x;
		else if (y == y.parent.left)
			y.parent.left = x;
		else y.parent.right = x;
		if (y != z)
			z.dancer = y.dancer;
		y = null;
	}
	private Node succsessor(Node n) {
		if (n.hasRight())
			return minimum(n.right);
		Node tmp = n.hasParent() ? n.parent : null;
		while (tmp != null && n == tmp.right) {
			n = tmp;
			tmp = tmp.parent;
		} return tmp;
	}
	private Node predecessor(Node n) {
		if (n.hasLeft())
			return maximum(n.left);
		Node tmp = n.hasParent() ? n.parent : null;
		while (tmp != null && n == tmp.left) {
			n = tmp;
			tmp = tmp.parent;
		} return tmp;
	}
}