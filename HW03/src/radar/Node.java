package radar;

public class Node {
    public char current, north, south, east, west;
    public String toString() {
    	String s = "";
    	s += "  " + north + "\n";
    	s += west + " " + current + " " + east + "\n";
		s += "  " + south + "\n";
    	return s;
    }
}