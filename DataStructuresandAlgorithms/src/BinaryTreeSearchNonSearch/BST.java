package BinaryTreeSearchNonSearch;

public class BST {
	Node root;
	
	Node ListHead;

	public void insert(int data, char value) {
		Node newnode = new Node(data, value);
		Node current = root;
		if (current == null) {
			root = newnode;
			return;
		}

		while (true) {
			Node left = current.leftNode;
			Node right = current.rightNode;
			if (data <= current.iData) {
				if (current.leftNode == null) {
					current.leftNode = newnode;
					break;
				} else {
					current = current.leftNode;
				}
			} else if (data > current.iData) {
				if (current.rightNode == null) {
					current.rightNode = newnode;
					break;
				} else {
					current = current.rightNode;
				}
			} else if (data == current.iData) {
				System.out.println("cannot insert Duplicate value " + newnode.iData);
				break;
			}
		}

	}

	public Node find(int data) {

		Node current = root;

		while (current != null) {
			if (current.iData == data) {
				return current;
			}
			if (data < current.iData) {
				current = current.leftNode;
			} else {
				current = current.rightNode;
			}

		}

		return null;

	}

	

	public Node maximum() {

		// BSTNode current=root;
		Node parent = root;
		if (parent == null) {
			return null;
		}
		while (true) {

			if (parent.rightNode == null) {
				return parent;
			} else {
				parent = parent.rightNode;
			}

		}

	}

	public boolean delete(int data) {

		Node current = root;
		Node parent = root;

		while (current != null) {
			if (current.iData == data) {
				break;
			}
			parent = current;
			if (data < current.iData) {

				current = current.leftNode;
			} else {
				parent = current;
				current = current.rightNode;
			}

		}

		if (current == null) {
			return false;
		}

		if (current.rightNode == null && current.leftNode == null) {
			if (current == root) {
				root = null;
			}
			if (current == parent.leftNode) {
				parent.leftNode = null;
			} else if (current == parent.rightNode) {
				parent.rightNode = null;
			}

		} else if (current.rightNode == null) {
			if (current == root) {
				root = current.leftNode;
			} else if (current == parent.leftNode) {
				parent.leftNode = current.leftNode;
			} else if (current == parent.rightNode) {
				parent.rightNode = current.leftNode;
			}
		} else if (current.leftNode == null) {
			if (current == root) {
				root = current.rightNode;
			} else if (current == parent.leftNode) {
				parent.leftNode = current.rightNode;
			} else if (current == parent.rightNode) {
				parent.rightNode = current.rightNode;
			}
		} else {
			Node succesor = getSuccessor(current);
			succesor.leftNode = current.leftNode;
			if (current == root) {
				root = succesor;
			} else {
				if (current == parent.leftNode) {
					parent.leftNode = succesor;
				} else if (current == parent.rightNode) {
					parent.rightNode = succesor;
				}
			}
		}

		return true;
	}

	public void inOrderTraversal(Node node) {

		if (node != null) {
			inOrderTraversal(node.leftNode);
			System.out.print(node);
			inOrderTraversal(node.rightNode);
		}

	}

	public void reverseOrderTraversal(Node node) {

		if (node != null) {
			reverseOrderTraversal(node.leftNode);
			System.out.print(node);
			reverseOrderTraversal(node.rightNode);
		}

	}

	public void OrderTraversal(Node node, int k) {

		if (node != null) {

			// for(int i=0;i<=k;i++){
			// System.out.print(" ");
			// }

			// System.out.println("");
			OrderTraversal(node.leftNode, k / 2);
			System.out.print(node);
			OrderTraversal(node.rightNode, k + k / 2);
		}

	}

	public Node getSuccessor(Node delNode) {
		Node succesor = delNode;
		Node succesorParent = delNode;

		Node current = delNode.rightNode;
		while (current != null) {
			succesorParent = succesor;
			succesor = current;
			current = current.leftNode;
		}

		if (succesor != delNode.rightNode) {
			succesorParent.leftNode = succesor.rightNode;
			succesor.rightNode = delNode.rightNode;
		}

		return succesor;
	}
	
	
}

