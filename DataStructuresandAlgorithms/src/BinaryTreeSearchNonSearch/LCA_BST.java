package BinaryTreeSearchNonSearch;

public class LCA_BST {
	
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
		
		  Node node=lca(bst.root,19,85); 
		  if(node!=null){
		  System.out.println("Node found with key "
		  +node.iData+" and value "+node.value); }
		  else{
		  System.out.println("Node not found"); 
		  }


	}
	
	static Node lca(Node node,int n1, int n2) {
		if (node == null)
            return null;
  
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.iData > n1 && node.iData > n2)
            return lca(node.leftNode, n1, n2);
  
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.iData < n1 && node.iData < n2) 
            return lca(node.rightNode, n1, n2);
  
        return node;
	}

}
