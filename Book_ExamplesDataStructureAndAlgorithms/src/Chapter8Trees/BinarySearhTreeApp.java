package Chapter8Trees;

public class BinarySearhTreeApp {

	public static void main(String[] args) {
		BSTTree bst = new BSTTree();
		bst.insert(34, "A");
		bst.insert(64, "R");
		bst.insert(23, "Y");
//		bst.insert(71, "E");
//		bst.insert(30, "H");
//		bst.insert(33, "O");
//		bst.insert(20, "W");
//		bst.insert(22, "Q");
//		bst.insert(19, "N");
//		bst.insert(66, "N");
//		bst.insert(76, "D");
//		bst.insert(65, "R");
//		bst.insert(85, "T");
		/**
		 * BSTNode node=bst.find(33); if(node!=null){
		 * System.out.println("Node found with key "
		 * +node.iData+" and value "+node.value); }else{
		 * System.out.println("Node not found"); }
		 * 
		 * 
		 * 
		 * 
		 * System.out.println("In Order Traversal ---------------------------");
		 * 
		 * bst.inOrderTraversal(bst.root);
		 * 
		 * System.out.println(
		 * "revers Order Traversal -------------------------------------");
		 * 
		 * bst.reverseOrderTraversal(bst.root);
		 * 
		 * }
		 **/
		bst.inOrderTraversal(bst.root);
		bst.Delete(34);
		bst.inOrderTraversal(bst.root);
//		BSTNode node = bst.maximum();
//		if (node != null) {
//			System.out.println("Maximum Node found with key " + node.iData
//					+ " and value " + node.value);
//		} else {
//			System.out.println("Tree is empty");
//		}

	}

}

class BSTNode {

	public int iData;
	public String value;
	public BSTNode leftChild;
	public BSTNode rightChild;

	public BSTNode(int a, String s) {
		iData = a;
		value = s;
	}

	public void display() {
		System.out.println("Node values is " + iData);
	}
}

class BSTTree {
	public BSTNode root;

	public void insert(int key, String val) {
		BSTNode data = new BSTNode(key, val);
		if (root == null) {
			root = data;
		} else {
			BSTNode current = root;
			// BSTNode parent;
			while (true) {
				// parent=current;
				if (key < current.iData) {
					if (current.leftChild == null) {
						current.leftChild = data;
						break;
					} else {
						current = current.leftChild;
					}
				} else if (key > current.iData) {
					if (current.rightChild == null) {
						current.rightChild = data;
						break;
					} else {
						current = current.rightChild;
					}
				} else if (key == current.iData) {
					System.out.println("cannot insert Duplicate value "
							+ data.iData);
					break;
				}
			}
		}

	}

	public BSTNode find(int key) {
		BSTNode current = root;
		while (current != null && current.iData != key) {
			if (key < current.iData) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
		}

		if (current == null) {
			return null;
		} else {
			return current;
		}
	}

	public boolean Delete(int key){
		boolean Flag=false;
		BSTNode current=root;
		boolean leftChild=true;
		//boolean rightChild;
		BSTNode parent=root;
		while(current.iData!=key){
			parent=current;
			if (key < current.iData) {
				leftChild=true;
				current = current.leftChild;
			} else {
				leftChild=false;
				current = current.rightChild;
			}
			
			if(current==null){
				return false;
				
			}
		}
		
		if(current.leftChild==null&&current.rightChild==null){
			
			if(current==root){
				root=null;
			}
			else if(leftChild){
			parent.leftChild=null;	
			}else{
				parent.rightChild=null;
			}
			
		}else if(current.rightChild==null){
			if(current==root){
				root=current.leftChild;
			}
			else if(leftChild){
			parent.leftChild=current.leftChild;	
			}else{
				parent.rightChild=current.leftChild;
			}
			
		}else if(current.leftChild==null){
			if(current==root){
				root=current.rightChild;
			}
			else if(leftChild){
			parent.leftChild=current.rightChild;	
			}else{
				parent.rightChild=current.rightChild;
			}
		}else{
			BSTNode succesor=getSuccesor(current);
			
			if(current==root){
				root=succesor;
			}else{
			if(leftChild){
				parent.leftChild=succesor;	
				}else{
					parent.rightChild=succesor;
				}
			}
			succesor.leftChild=current.leftChild;
		}
		return Flag;
	}
	
	public void inOrderTraversal(BSTNode node) {

		if (node != null) {
			
			inOrderTraversal(node.leftChild);
			node.display();
			inOrderTraversal(node.rightChild);
		}

	}

	public void reverseOrderTraversal(BSTNode node) {

		if (node != null) {
			reverseOrderTraversal(node.rightChild);
			node.display();
			reverseOrderTraversal(node.leftChild);
		}

	}

	public BSTNode maximum() {

		// BSTNode current=root;
		BSTNode parent = root;
		if (parent == null) {
			return null;
		}
		while (true) {
			
				if (parent.rightChild == null) {
					return parent;
				} else {
					parent = parent.rightChild;
				}
			
		}

	}
	
	public BSTNode getSuccesor (BSTNode delnode){
		BSTNode succesorParent=delnode;
		BSTNode succesor=delnode;
		
		BSTNode current=delnode.rightChild;
		while(current!=null){
			succesorParent=succesor;
			succesor=current;
			current=current.leftChild;
		}
		
		if(succesor!=delnode.rightChild){
			succesorParent.leftChild=succesor.rightChild;
			succesor.rightChild=delnode.rightChild;
		}
		
		return succesor;
		
	}

}