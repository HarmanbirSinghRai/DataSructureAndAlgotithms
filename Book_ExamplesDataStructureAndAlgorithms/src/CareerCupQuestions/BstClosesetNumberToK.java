
//This was the first round. A written test. I was asked to write a complete program that can execute
//with proper syntax. Also comment on the complexity and add comments to code where necessary. 
//And i had to write it on Paper. Three questions were given and was asked to answer any two. I was given 1hr time for this. 
//
//This was one of the questions 
//Q) You are given a BST and a number k. Find the node in the tree which has the value closest to k.

package CareerCupQuestions;



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
		
		  Node node=bst.NearesstToK(33); 
		  if(node!=null){
		  System.out.println("Node found with key "
		  +node.iData+" and value "+node.value); }
		  else{
		  System.out.println("Node not found"); 
		  }
//		
//		  System.out.println("In Order Traversal ---------------------------");
//		  
//		  bst.inOrderTraversal(bst.root);
//		  
//		  System.out.println(
//		  "revers Order Traversal -------------------------------------");
//		  
//		  bst.reverseOrderTraversal(bst.root);
		  
//		bst.OrderTraversal(bst.root,5);
//		bst.delete(34);
//		System.out.println("");
//		bst.OrderTraversal(bst.root,5);

//		Node node1 = bst.maximum();
//		if (node1 != null) {
//			System.out.println("Maximum Node found with key " + node1.iData
//					+ " and value " + node1.value);
//		} else {
//			System.out.println("Tree is empty");
//		}

	}

}



class Node{
	int iData;
	char value;
	Node leftNode;
	Node rightNode;
	
	public Node(int data,char a){
		iData=data;
		value=a;
	}
	@Override
	public String toString(){
		return iData+" ";
	}
}
class BST{
	Node root;
	
	
	public void insert(int data,char value){
		Node newnode=new Node(data,value);
		Node current=root;
		if(current==null){
			root=newnode;
			return;
		}
		
		while(true){
			Node left=current.leftNode;
			Node right=current.rightNode;
			if(data<=current.iData){
				if(current.leftNode==null){
					current.leftNode=newnode;
					break;
				}else{
					current=current.leftNode;
				}
			}else if(data>current.iData){
				if(current.rightNode==null){
					current.rightNode=newnode;
					break;
				}else{
					current=current.rightNode;
				}
			}else if (data == current.iData) {
				System.out.println("cannot insert Duplicate value "
						+ newnode.iData);
				break;
			}
		}
		
		
	}
	
	
 public Node find (int data)	{
	 
	 Node current=root;
	 
	 while(current!=null){
		 if(current.iData==data){
			 return current;
		 }
		 if(data<current.iData){
			 current=current.leftNode; 
		 }else{
			 current=current.rightNode;
		 }
			 
	 }
	 
	 return null;
	 
 }
 
 public Node NearesstToK (int data)	{
	 
	 Node current=root;
	 Node Closest=null;
	 int minValue=Integer.MAX_VALUE;
	 while(current!=null){
		 if(current.iData==data){
			 return current;
		 }
		 
		 int diff=Math.abs(current.iData-data);
		 if(diff<minValue){
			 minValue=diff;
		     Closest=current;
		 }
		 if(data<current.iData){
			
			 current=current.leftNode; 
		 }else{
			 current=current.rightNode;
		 }
			 
	 }
	 
	 return Closest;
	 
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
 
 public boolean delete(int data){
	 
	 Node current=root;
	 Node parent=root;
	 
	 while(current!=null){
		 if(current.iData==data){
			break;
		 }
		 parent=current;
		 if(data<current.iData){
			
			 current=current.leftNode; 
		 }else{
			 parent=current;
			 current=current.rightNode;
		 }
			 
	 }
	 
	 if(current==null){
	      return false;
	 }	 
	 
	
		 if(current.rightNode==null&&current.leftNode==null){
			 if(current==root){
			      root=null;
				 }
			 if(current==parent.leftNode){
				 parent.leftNode=null; 
			 }else if(current==parent.rightNode){
				 parent.rightNode=null; 
			 }
			 
		 }
		 else if(current.rightNode==null){
			 if(current==root){
			      root=current.leftNode; 
				 }
			 else if(current==parent.leftNode){
				 parent.leftNode=current.leftNode; 
			 }else if(current==parent.rightNode){
				 parent.rightNode=current.leftNode; 
			 }
		 }
		 else if (current.leftNode==null){
			 if(current==root){
			      root=current.rightNode; 
				 }
			 else if(current==parent.leftNode){
				 parent.leftNode=current.rightNode; 
			 }else if(current==parent.rightNode){
				 parent.rightNode=current.rightNode; 
			 }
		 }else{
			 Node succesor=getSuccessor(current);
			 succesor.leftNode=current.leftNode;
			 if(current==root){
				 root=succesor;
			 }else{
			 if(current==parent.leftNode){
				 parent.leftNode=succesor; 
			 }else if(current==parent.rightNode){
				 parent.rightNode=succesor; 
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
			
//			for(int i=0;i<=k;i++){
//				System.out.print(" ");
//			}
		
			//System.out.println("");
			OrderTraversal(node.leftNode,k/2);
			System.out.print(node);
			OrderTraversal(node.rightNode,k+k/2);
		}

	}
	
 public Node getSuccessor(Node delNode){
	 Node succesor=delNode;
	 Node succesorParent=delNode;
	
	 Node current=delNode.rightNode;
	 while(current!=null){
		 succesorParent=succesor;
		 succesor=current;
		 current=current.leftNode;
	 }
	 
	 if(succesor!=delNode.rightNode){
		 succesorParent.leftNode=succesor.rightNode;
		 succesor.rightNode=delNode.rightNode;
	 }
	 

	 
	
	 
	 
//	 if(succesor==null){
//		 return current;
//	 }else{
//	 while(succesor.leftNode!=null){
//		 succesorParent=succesor;
//		 succesor=succesor.leftNode;
//	 }
//	 }
//	 if(succesor.rightNode!=null){
//		 succesorParent.leftNode=succesor.rightNode;
//	 }
	 return succesor;
 }
 
 
	
}
