//Jose Escobar & Jacob Wennersten

public class Node{
	private boolean isParent = false;
	private int value = 0;
	private Node left, right;
	left = right = NULL;
	
	public Node(int value){
		this.value = value;
	}

	public Node getLeft(){
		return left;
	}

	public Node getRight(){
		return right;
	}

	public int getValue(){
		return value;
	}

	public void setRight(Node child){
		right = child;
		isParent = true;
	}

	public void setLeft(Node child){
		left = child;
		isParent = true;
	}
}