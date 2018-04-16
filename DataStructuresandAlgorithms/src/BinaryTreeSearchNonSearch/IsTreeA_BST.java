package BinaryTreeSearchNonSearch;

public class IsTreeA_BST {
	
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
		
		  boolean result=isBST(bst.root); 
		  System.out.println("This tree is a BST found with key " + result);



	}
	
	
	
	
	public static boolean isBST(Node root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    static boolean isBST(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.iData <= min || root.iData > max){
            return false;
        }
        return isBST(root.leftNode, min, root.iData) && isBST(root.rightNode, root.iData, max);
    }


}
