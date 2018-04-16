package Chapter4StacksQueues.HarmanCode;

public class QueueArray2 {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;

	// --------------------------------------------------------------
	public QueueArray2(int s) // constructor
	{
		maxSize = s + 1; // array is 1 cell larger
		queArray = new long[maxSize]; // than requested
		front = 0;
		rear = -1;
	}

	// --------------------------------------------------------------
	public void insert(long j) // put item at rear of queue
	{
		if(!isFull()){
		if (rear == maxSize - 1)
			rear = -1;
		queArray[++rear] = j;
		}
	}

	// --------------------------------------------------------------
	public long remove() // take item from front of queue
	{
		long temp=-1;
		if(!isEmpty()){
		 temp = queArray[front++];
		if (front == maxSize)
			front = 0;
		
		}
		return temp;
	}

	// --------------------------------------------------------------
	public long peek() // peek at front of queue
	{
		return queArray[front];
	}

	// --------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (rear + 1 == front || (front + maxSize - 1 == rear));
	}

	// --------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{
		return (rear + 2 == front || (front + maxSize - 2 == rear));
	}

	// --------------------------------------------------------------
	public int size() // (assumes queue not empty)
	{
		if (rear >= front) // contiguous sequence
			return rear - front + 1;
		else
			// broken sequence
			return (maxSize - front) + (rear + 1);
	}
	// --------------------------------------------------------------
	
	public static void main(String[] args)
	{
	QueueArray2 theQueue = new QueueArray2(5); // queue holds 5 items
	theQueue.insert(10); // insert 4 items
	theQueue.insert(20);
	theQueue.insert(30);
	theQueue.insert(40);
	theQueue.insert(50);
	theQueue.insert(50);
	theQueue.remove(); // remove 3 items
	theQueue.remove(); // (10, 20, 30)
	theQueue.remove();
	theQueue.remove();
	theQueue.remove();
	theQueue.insert(50); 
	theQueue.remove();
	theQueue.remove();
	long a=theQueue.peek();
	System.out.print(a);
	System.out.println(" ");
	// insert 4 more items
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
} // end class Queue