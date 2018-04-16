package BinaryTreeSearchNonSearch;

public class PrintNodeAtKDistance {
	
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
		
		  printKDistant(bst.root,2); 




	}
	
	
	 static void printKDistant(Node node, int k) 
	    {
	        if (node == null)
	            return;
	        if (k == 0) 
	        {
	            System.out.print(node.iData + " ");
	            return;
	        } 
	        else
	        {
	            printKDistant(node.leftNode, k - 1);
	            printKDistant(node.rightNode, k - 1);
	        }
	    }

}
