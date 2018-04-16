
//This was the first round. A written test. I was asked to write a complete program that can execute
//with proper syntax. Also comment on the complexity and add comments to code where necessary. 
//And i had to write it on Paper. Three questions were given and was asked to answer any two. I was given 1hr time for this. 
//
//This was one of the questions 
//Q) You are given a BST and a number k. Find the node in the tree which has the value closest to k.
//more tahn one nodes is below
//https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/KClosestValueInBinaryTree.java

package BinaryTreeSearchNonSearch;



public class BstClosesetNumberToK {
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(34, 'A');
		bst.insert(64, 'R');
		bst.insert(23, 'Y');
		bst.insert(71, 'E');
		bst.insert(30, 'H');
		bst.insert(33, 'O');
		bst.insert(20, 'W');
		bst.insert(22, 'Q');
		bst.insert(19, 'N');
		bst.insert(66, 'N');
		bst.insert(76, 'D');
		bst.insert(65, 'R');
		bst.insert(85, 'T');
		
		  Node node=NearesstToK(33,bst); 
		  if(node!=null){
		  System.out.println("Node found with key "
		  +node.iData+" and value "+node.value); }
		  else{
		  System.out.println("Node not found"); 
		  }


	}
	
	public static Node NearesstToK(int data,BST bst) {

		Node current = bst.root;
		Node Closest = null;
		int minValue = Integer.MAX_VALUE;
		while (current != null) {
			if (current.iData == data) {
				return current;
			}

			int diff = Math.abs(current.iData - data);
			if (diff < minValue) {
				minValue = diff;
				Closest = current;
			}
			if (data < current.iData) {

				current = current.leftNode;
			} else {
				current = current.rightNode;
			}

		}

		return Closest;

	}

}




