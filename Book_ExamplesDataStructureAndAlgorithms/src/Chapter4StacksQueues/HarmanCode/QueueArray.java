package Chapter4StacksQueues.HarmanCode;

public class QueueArray {
	
	private int[] queue;
	private int front;
	private int rear;
	private int nItems;
	private int maxsize;
	
	QueueArray(int size){
		maxsize=size;
		queue= new int[size];
		front=0;
		rear=-1;
		nItems=0;
	}
	
	public void insert(int item){
		
		if(nItems<maxsize){
			if(rear==maxsize-1){
				rear=-1;
			}
			queue[++rear]=item;
			nItems++;
		}
	}
	
	public int remove(){
		int item=-1000000;
		if(!isEmpty()){
			item=queue[front];
			queue[front]=-1;
			front++;
		if(front==maxsize)
			front=0;
		nItems--;
		}
		return item;
		
	}
	
	public int peekFront(){
		return queue[front];
	}
	
	
	public boolean isEmpty(){
		return (nItems==0);
	}

	
	public boolean isFull(){
		return (nItems==maxsize);
	}
	
	public int size(){
		return nItems;
	}
	
	public static void main(String[] args)
	{
	QueueArray theQueue = new QueueArray(5); // queue holds 5 items
	theQueue.insert(10); // insert 4 items
	theQueue.insert(20);
	theQueue.insert(30);
	theQueue.insert(40);
	theQueue.insert(50);
	theQueue.remove(); // remove 3 items
	theQueue.remove(); // (10, 20, 30)
	theQueue.remove();
	theQueue.remove();
	theQueue.remove();
	theQueue.remove();
	theQueue.remove();
	long a=theQueue.peekFront();
	System.out.print(a);
	System.out.println(" ");
	theQueue.insert(50); // insert 4 more items
	theQueue.insert(60); // (wraps around)
	theQueue.insert(70);
	theQueue.insert(80);
	while( !theQueue.isEmpty() ) // remove and display
	{long n = theQueue.remove(); // (40, 50, 60, 70, 80)
	System.out.print(n);
	System.out.print(" ");
	}
	System.out.println("");
	} // end main()
}
