package Chapter10Trees234.NarrayTree;

import java.util.ArrayList;
import java.util.LinkedList;

public class N_Ary_TreeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create a new Integer type node
		Node<Integer> root = new Node<Integer>(1);

		//Add a child
		root.addChild(new Node<Integer>(2));
		root.addChild(new Node<Integer>(3));
		root.addChild(new Node<Integer>(4));
		root.addChild(new Node<Integer>(5));
		root.addChild(new Node<Integer>(6));
		
		Node<Integer> childRoot1=root.getChildAt(1);
		childRoot1.addChild(new Node<Integer>(12));
		childRoot1.addChild(new Node<Integer>(13));
		childRoot1.addChild(new Node<Integer>(14));
		childRoot1.addChild(new Node<Integer>(15));
		childRoot1.addChild(new Node<Integer>(16));

		Node<Integer> childRoot2=root.getChildAt(2);
		childRoot2.addChild(new Node<Integer>(22));
		childRoot2.addChild(new Node<Integer>(23));
		childRoot2.addChild(new Node<Integer>(24));
		childRoot2.addChild(new Node<Integer>(25));
		childRoot2.addChild(new Node<Integer>(26));
		
		
		Node<Integer> childRoot1Child2=childRoot1.getChildAt(2);
		childRoot1Child2.addChild(new Node<Integer>(43));
		
		Node<Integer> childRoot2Child3=childRoot2.getChildAt(3);
		childRoot2Child3.addChild(new Node<Integer>(33));
		//Create a tree, providing the root node
		Tree<Integer> tree = new Tree<Integer>(root);

		//Get the pre-order traversal
	//	ArrayList<Node<Integer>> preOrder = tree.getPostOrderTraversal();
		
		//for (Node<Integer> node : preOrder) {
		//	System.out.println(" "+node.getData() );
		//}
		
		//ArrayList<Node<Integer>> longestPath =tree.getLongestPathFromRootToAnyLeaf();
		ArrayList<Node<Integer>> longestPath =tree.getPathsFromRootToAnyLeaf_harman();
		
		for (Node<Integer> node : longestPath) {
			System.out.println(" "+node.getData() );
		}

	}

}
