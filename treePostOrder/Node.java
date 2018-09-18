//Jose Escobar & Jacob Wennersten

public class Node{
	private boolean isParent = false;
	private int value = 0;
	private Node left = null;
	private Node right = null;
	
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

	// Prints preorder traversal of node subtree
	@Override
	public String toString() {
		String preOrder = String.valueOf(value);
		if(isParent) {
			if (left != null) {
				preOrder += " " + left.toString();
			}
			if (right != null) {
				preOrder += " " + right.toString();
			}
		}
		return preOrder;
	}
}