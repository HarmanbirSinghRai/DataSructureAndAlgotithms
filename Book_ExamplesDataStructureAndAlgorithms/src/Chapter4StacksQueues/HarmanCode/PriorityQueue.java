package Chapter4StacksQueues.HarmanCode;

public class PriorityQueue {
	private int[] queArray;
	private int maxsize;
	private int nItems;

	PriorityQueue(int size) {
		queArray = new int[size];
		maxsize = size;
		nItems = 0;
	}

	private void insert(int item) {
		if (nItems == 0) {
			queArray[nItems++] = item;
		} else {
			int j;
			for (j = nItems - 1; j >= 0; j--) {
				if (item > queArray[j]) {
					queArray[j + 1] = queArray[j];
				} else {
					break;
				}
			}
			queArray[j + 1] = item;
			nItems++;
		}
	}

	private int remove() {
		int item = -1;
		item = queArray[--nItems];
		return item;
	}

	private int peek() {
		return queArray[nItems - 1];
	}

	// -------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (nItems == 0);
	}

	// -------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{
		return (nItems == maxsize);
	}

	// -------------------------------------------------------------

	public static void main(String[] args) {
		PriorityQueue thePQ = new PriorityQueue(5);
		thePQ.insert(30);
		thePQ.insert(50);
		thePQ.insert(10);
		thePQ.insert(40);
		thePQ.insert(20);
		while (!thePQ.isEmpty()) {
			long item = thePQ.remove();
			System.out.print(item + " "); // 10, 20, 30, 40, 50
		} // end while
		System.out.println("");
	} // end main()
		// -------------------------------------------------------------

}
