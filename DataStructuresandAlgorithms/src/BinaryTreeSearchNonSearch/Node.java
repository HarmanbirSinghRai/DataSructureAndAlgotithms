package BinaryTreeSearchNonSearch;

public class Node {
	int iData;
	char value;
	Node leftNode;
	Node rightNode;

	public Node(int data, char a) {
		iData = data;
		value = a;
	}

	@Override
	public String toString() {
		return iData + " ";
	}
}