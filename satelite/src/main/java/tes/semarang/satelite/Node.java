package tes.semarang.satelite;

public class Node {
	public final char value;
    public Node left;
    public Node right;
    
    public Node(char value) {
    	this(value, null, null);
    }
    
    public Node(char value, Node left, Node right) {
    	this.value = value;
        this.left = left;
        this.right = right;
    }
}
