//Jose Escobar & Jacob Wennersten

import java.util.*;

public class treeBuilder{

	public static void main(String[] args){
		//given two arrays build a tree in preorder 
		//the second array will give N for nodes and L for leaves
		int[] pre1 = {10,30,20,5,15};
		char[] preLN1 = {'N','N','L','L','L'};	
		int size1 = pre1.length;

		int[] pre2 = {1, 2, 4, 6, 5, 3};
		char[] preLN2 = {'N', 'N', 'N', 'L', 'L', 'L'};	
		int size2 = pre2.length;

		Node tree = constructTree(size1, pre1, preLN1);
		// Node tree = constructTree(size2, pre2, preLN2);
		System.out.println(tree);
	}

	public static Node constructTree(int size, int[] preFuckJacob, char[] preLN){
		Node root = new Node(preFuckJacob[0]);
		int i = 1;
		Node parent = root;
		Node child = new Node(1);
		Stack<Node> expecting = new Stack<Node>();

		while(preLN[i-1] == 'N'){
			child = new Node(preFuckJacob[i]);
			parent.setLeft(child);
			expecting.push(parent);
			parent = child;
			i++;
		}
		if(preLN[i] == 'L'){
			while(i < size){
				child = new Node(preFuckJacob[i]);
				parent = expecting.pop();
				parent.setRight(child);
				i++;
			}
		}
		return root;
	}
}