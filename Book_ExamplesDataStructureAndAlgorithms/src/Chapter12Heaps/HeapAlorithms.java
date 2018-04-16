package Chapter12Heaps;




public class HeapAlorithms { 
	
	public static void main(String[] args){
		
		int size=10;
		Heap heap=new Heap(size);
		System.out.println("List of numbers");
		//Method1
	/**	for (int i=0;i<size;i++){
			int a = (int)(java.lang.Math.random()  * 100);
			heap.insert(a);
		}
		System.out.println(" ");
		
		System.out.println("Sorted List");
		for(int i=0;i<size;i++){
			Node top =heap.removeTop();
			top.display();
		}
		
		
	}**/
	
	//method 2 heapsort
	for (int i=0;i<size;i++){
		int a = (int)(java.lang.Math.random()  * 1000);
		heap.insertrandomly(a);
	}
	
	for(int i=size-1;i>=0;i--){
		heap.getNode(i).display();
	}
	heap.heapsort();
	System.out.println(" ");
	
	System.out.println("Sorted List");
	
	for(int i=size-1;i>=0;i--){
		heap.getNode(i).display();
	}

}
}

class Node{
	int iData;
	
	public Node(int data){
		iData=data;
	}
	
	public int getKey(){
		return iData;
	}
	
	public void display(){
		System.out.print(iData+" ");
	}
}


class Heap{
	private Node heapArray[];
	private int maxsize;
	private int currentsize;
	
	public Heap(int size){
		
		heapArray=new Node[size];
		maxsize=size;
		currentsize=0;
		
	}
	
	public void insert(int a){
		
		if(currentsize==maxsize){
			System.out.println("Heap is full");
		}else{
		Node newNode=new Node(a);
		heapArray[currentsize]=newNode;
		trickleUp(currentsize++);
		}
		
	}
	
	public Node getNode(int index){
		return heapArray[index];
	}
	public void trickleUp(int index){
		
		Node newNode=heapArray[index];
		int parent=(index-1)/2;
		
		while (index>0 && heapArray[parent].getKey()<newNode.getKey()){
			
			heapArray[index]=heapArray[parent];
			index=parent;
			parent=(parent-1)/2;
			
		}
		heapArray[index]=newNode;
		
	}
	
	public Node removeTop(){
		
		Node top=heapArray[0];
		heapArray[0]=heapArray[--currentsize];
		trickleDown(0);
		return top;
	}
	
	public void trickleDown(int index){
		
		Node top=heapArray[index];
		
		
		while(index<currentsize/2){
			int largerChild;
			int leftChild=index*2 +1;
			int rightChild=index*2 +2;
			
			if(rightChild<currentsize && heapArray[rightChild].getKey()>heapArray[leftChild].getKey()){
				largerChild=rightChild;
			}else{
				largerChild=leftChild;
			}
			
			if(top.getKey()>=heapArray[largerChild].getKey()){
				break;
			}
			heapArray[index]=heapArray[largerChild];
			index=largerChild;
			
		}
		heapArray[index]=top;
		
	}
	
	public void insertrandomly(int data){
		heapArray[currentsize++]=new Node(data);
	}
	public void insertAtIndex(int index,Node data){
		heapArray[index]=data;
	}
	
	public void heapsort(){
		
		for(int j=currentsize/2-1;j>=0;j--){
			trickleDown(j);
		}
		
		for(int k=currentsize-1;k>=0;k--){
			Node top=removeTop();
			insertAtIndex(k,top);
		}
	}
}