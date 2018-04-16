package MoreTrees;

import java.util.ArrayList;
import java.util.List;


public class NTree<T> {

	private Node<T> root;

	public NTree(Node<T> root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return (root == null) ? true : false;
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public boolean exists(T key) {
		return find(root, key);
	}

	public int getNumberOfNodes() {
		return getNumberOfDescendants(root) + 1;
	}

	public int getNumberOfDescendants(Node<T> node) {
		int n = node.getChildren().size();
		for (Node<T> child : node.getChildren())
			n += getNumberOfDescendants(child);

		return n;

	}

	private boolean find(Node<T> node, T keyNode) {
		boolean res = false;
		if (node.getData().equals(keyNode))
			return true;

		else {
			for (Node<T> child : node.getChildren())
				if (find(child, keyNode))
					res = true;
		}

		return res;
	}
	
    private Node<T> findNode(Node<T> node, T keyNode)
    {
    	if(node == null)
    		return null;
    	if(node.getData().equals(keyNode))
    		return node;
    	else
    	{
    		Node<T> cnode = null;
    		for (Node<T> child : node.getChildren())
    			if ((cnode = findNode(child, keyNode)) != null)
    				return cnode;
    	}
    	return null;         
    } 

	public ArrayList<Node<T>> getPreOrderTraversal() {
		ArrayList<Node<T>> preOrder = new ArrayList<Node<T>>();
		buildPreOrder(root, preOrder);
		return preOrder;
	}

	public ArrayList<Node<T>> getPostOrderTraversal() {
		ArrayList<Node<T>> postOrder = new ArrayList<Node<T>>();
		buildPostOrder(root, postOrder);
		return postOrder;
	}

	private void buildPreOrder(Node<T> node, ArrayList<Node<T>> preOrder) {
		preOrder.add(node);
		for (Node<T> child : node.getChildren()) {
			buildPreOrder(child, preOrder);
		}
	}

	private void buildPostOrder(Node<T> node, ArrayList<Node<T>> postOrder) {
		for (Node<T> child : node.getChildren()) {
			buildPostOrder(child, postOrder);
		}
		postOrder.add(node);
	}

	public ArrayList<Node<T>> getLongestPathFromRootToAnyLeaf() {
		ArrayList<Node<T>> longestPath = null;
		int max = 0;
		for (ArrayList<Node<T>> path : getPathsFromRootToAnyLeaf()) {
			if (path.size() > max) {
				max = path.size();
				longestPath = path;
			}
		}
		return longestPath;
	}

	public void getMaxDepth()
	{
		ArrayList<Node<T>> longestpath= getLongestPathFromRootToAnyLeaf();
		System.out.println("maximum depth is "+ longestpath.size());
		for(Node<T> node : longestpath){
			System.out.print(node.getData()+" ");
		}
	}
	
	public ArrayList<ArrayList<Node<T>>> getPathsFromRootToAnyLeaf() {
		ArrayList<ArrayList<Node<T>>> paths = new ArrayList<ArrayList<Node<T>>>();
		ArrayList<Node<T>> currentPath = new ArrayList<Node<T>>();
		getPath(root, currentPath, paths);

		return paths;
	}

	private void getPath(Node<T> node, ArrayList<Node<T>> currentPath,
			ArrayList<ArrayList<Node<T>>> paths) {
	//	if (currentPath == null)
		//	return;

		currentPath.add(node);

		if (node.getChildren().size() == 0) {
			// This is a leaf
			paths.add(clone(currentPath));
		}
		for (Node<T> child : node.getChildren())
			getPath(child, currentPath, paths);

		//int index = currentPath.indexOf(node);
		//for (int i = index; i < currentPath.size(); i++)
			currentPath.remove(node);
	}

	private ArrayList<Node<T>> clone(ArrayList<Node<T>> list) {
		ArrayList<Node<T>> newList = new ArrayList<Node<T>>();
		for (Node<T> node : list)
			newList.add(new Node<T>(node));

		return newList;
	}
	
	public static void main(String[] args){
		Node<Integer> rootnode=new Node<Integer>(1);
		
		NTree<Integer> newtree=new NTree<Integer>(rootnode);
		
		//add children to node
		Node<Integer> childnode1=new Node<Integer>(2);
		Node<Integer> childnode2=new Node<Integer>(3);
		Node<Integer> childnode3=new Node<Integer>(4);
		Node<Integer> childnode4=new Node<Integer>(5);
		newtree.getRoot().addChildAt(0, childnode1);
		newtree.getRoot().addChildAt(1, childnode2);
		newtree.getRoot().addChildAt(2, childnode3);
		newtree.getRoot().addChildAt(3, childnode4);
		
		//addChildren to childnode 1
		Node<Integer> childnode5=new Node<Integer>(6);
		Node<Integer> childnode6=new Node<Integer>(7);
	
		newtree.getRoot().getChildAt(0).addChildAt(0, childnode5);
		newtree.getRoot().getChildAt(0).addChildAt(1, childnode6);
		
		//addChildren to childnode 2
		Node<Integer> childnode7=new Node<Integer>(8);
		Node<Integer> childnode8=new Node<Integer>(9);
		newtree.getRoot().getChildAt(1).addChildAt(0, childnode7);
		newtree.getRoot().getChildAt(1).addChildAt(1, childnode8);
		
		//addChildren to childnode 3
		Node<Integer> childnode9=new Node<Integer>(10);
		Node<Integer> childnode10=new Node<Integer>(11);
		newtree.getRoot().getChildAt(2).addChildAt(0, childnode9);
		newtree.getRoot().getChildAt(2).addChildAt(1, childnode10);
		
		//addChildren to childnode 4
		Node<Integer> childnode11=new Node<Integer>(12);
		Node<Integer> childnode12=new Node<Integer>(13);
		newtree.getRoot().getChildAt(3).addChildAt(0, childnode11);
		newtree.getRoot().getChildAt(3).addChildAt(1, childnode12);
		
		//addChildren to grandchildnode  11
		Node<Integer> childnode13=new Node<Integer>(14);
		newtree.getRoot().getChildAt(3).getChildAt(0).addChildAt(0, childnode13);
		
		newtree.getMaxDepth();
	}
}


class Node<T> {
	private T data;
	private List<Node<T>> children;
	private Node<T> parent;

	public Node(T data) {
		this.data = data;
		this.children = new ArrayList<Node<T>>();
	}

	public Node(Node<T> node) {
		this.data = (T) node.getData();
		children = new ArrayList<Node<T>>();
	}

	public void addChild(Node<T> child) {
		child.setParent(this);
		children.add(child);
	}

	public void addChildAt(int index, Node<T> child) {
		child.setParent(this);
		this.children.add(index, child);
	}

	public void setChildren(List<Node<T>> children) {
		for (Node<T> child : children)
			child.setParent(this);

		this.children = children;
	}

	public void removeChildren() {
		this.children.clear();
	}

	public Node<T> removeChildAt(int index) {
		return children.remove(index);
	}
	
	
	public void removeThisIfItsAChild(Node<T> childToBeDeleted)
	{
		List <Node<T>> list = getChildren();
		list.remove(childToBeDeleted);
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getParent() {
		return this.parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public List<Node<T>> getChildren() {
		return this.children;
	}

	public Node<T> getChildAt(int index) {
		return children.get(index);
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;

		if (obj instanceof Node) {
			if (((Node<?>) obj).getData().equals(this.data))
				return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}

}