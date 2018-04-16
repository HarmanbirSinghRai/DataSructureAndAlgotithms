package BinaryTreeSearchNonSearch;

/**
 * http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
 */
public class BinaryTreeToDoubleLinkList {

	public Node tranform(Node head) {

		class DLL {
			Node prev;
			Node first;
			private void toDoubleLL(Node root) {
				if (root == null) {
					return ;
				}
				toDoubleLL(root.leftNode);
				if (prev != null) {
					prev.rightNode = root;
					root.leftNode = prev;
					prev = root;
				} else {
					prev = root;
					first=root;
				}

				toDoubleLL(root.rightNode);
			}
			
			private Node returnFirstNode(Node root) {
				toDoubleLL(root);
				return first;
			}
			
		}

		return new DLL().returnFirstNode(head);
        
	}

	public void print(Node root) {
		Node curr = null;
		//root = root.rightNode;
		while (root != null) {
			curr = root;
			System.out.print(root.iData + " ");
			root = root.rightNode;
		}
	
	}

	public static void main(String args[]) {
		BinaryTreeToDoubleLinkList btd = new BinaryTreeToDoubleLinkList();
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
		// System.out.println("1. Two queue technique");
		// Node head = new Node(-1,'Z') ;
		bst.inOrderTraversal(bst.root);
		System.out.println("");
		Node first=btd.tranform(bst.root);
		btd.print(first);
	}
}
