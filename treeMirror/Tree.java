//Jose Escobar & Jacob Wennersten

import java.util.*;


public class Tree{
	public static void main(String[] args){
		//Given Array structured as: Root, Value of root child, Side
		//Assuming all nodes have 0 or 2 chidren && all values are unique
		Map<Integer, Node> nodesMap = new HashMap<Integer, Node>();

		//Create Root node and place it in HashMap
		Node root = new Node(Integer.parseInt(args[0]));
		nodesMap.put(root.getValue(),root);

		//Fill nodesMap with rest of nodes in args array and build tree
		for(int i = 0; i < args.length; i+=3){
			Node parent = nodesMap.get(Integer.parseInt(args[i]));
			Node child = new Node(Integer.parseInt(args[i+1]));
			if(args[i+2].equals("L")){
				parent.setLeft(child);
			}
			else if(args[i+2].equals("R")){
				parent.setRight(child);
			}
			else{
				System.out.println("ERROR: Node "+ args[i+1] + " is not defined as left or right child");
			}//node is added to tree

			//add child node to hashMap
			nodesMap.put(child.getValue(),child);
		}
		//print out tree to test building
		System.out.println(root);
		System.out.println(mirrorTree(root));
	}


	//Function mirrorTree will take in the constructed tree and print out the mirrored version of the tree


	public static Node mirrorTree(Node root){
		//recursively move through child nodes calling mirrorTree
		if(root.isParent()){
			Node leftChild = root.getLeft();
			Node rightChild = root.getRight();
			root.setLeft(mirrorTree(rightChild));
			root.setRight(mirrorTree(leftChild));
		}

		return root;
	}
}