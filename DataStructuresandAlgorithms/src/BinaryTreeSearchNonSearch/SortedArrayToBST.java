package BinaryTreeSearchNonSearch;

public class SortedArrayToBST {
	
	public static void main(String[] args) {
		BST bst = new BST();
	
		 int[] arr = { 1, 2, 3, 4, 5, 6, 7 };  
		  sortedArrayToBST(arr,bst); 
		 bst.inOrderTraversal(bst.root); 


	}
	
	public static void sortedArrayToBST(int arr[],BST bst) {  
	
		bst.root=sortedArrayToBST(arr, 0, arr.length - 1);  
    }  
  
    public static  Node sortedArrayToBST(int arr[], int start, int end) {  
  
        if (start > end) {  
            return null;  
        }  
        
    
        int mid = (start + end) / 2;  
        int val=arr[mid];
       
        Node node = new Node(val,Integer.toString(val).charAt(0));  
  
        node.leftNode= sortedArrayToBST(arr, start, mid - 1);  
        node.rightNode=sortedArrayToBST(arr, mid + 1, end);  
        
        return node;
  
  
    }  

}
