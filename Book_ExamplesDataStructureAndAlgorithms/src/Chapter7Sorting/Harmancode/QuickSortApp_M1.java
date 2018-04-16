package Chapter7Sorting.Harmancode;

public class QuickSortApp_M1 {

	public static void main(String[] args) {

		int count = 10;// Integer.parseInt(args[0]);
		ArrayQS sh = new ArrayQS(count);
		for (int i = 1; i <= count; i++) {

			int n = (int) (java.lang.Math.random() * 99);
			sh.insert(n);
		}

		sh.display();
		// sh.recQuickSort(0,count-1);
		sh.recQuickSort2(0, count - 1);
		sh.display();
	}

}

class ArrayQS {
	private int[] arrsh;
	private int nElemns;

	ArrayQS(int count) {
		arrsh = new int[count];
		nElemns = 0;
	}

	public void insert(int a) {
		arrsh[nElemns++] = a;

	}

	public void display() {
		for (int i = 0; i < nElemns; i++) {
			System.out.print(arrsh[i] + " ");
		}
		System.out.println("");
	}

	public void recQuickSort(int left, int right) {

		if (left >= right) {
			return;
		}
		int pivot = arrsh[right];
		int partition = partitionIt(left, right, pivot);
		recQuickSort(left, partition - 1);
		recQuickSort(partition + 1, right);

	}

	public int partitionIt(int left, int right, int pivot) {

		int leftptr = left - 1;
		int rightptr = right;

		while (true) {
			while (arrsh[++leftptr] < pivot)
				;

			while (rightptr > 0 && arrsh[--rightptr] > pivot)
				;

			if (leftptr >= rightptr) {
				break;
			} else {
				swap(leftptr, rightptr);
			}
		}
		swap(leftptr, right);
		return leftptr;
	}

	public void swap(int left, int right) {
		int temp = arrsh[left];
		arrsh[left] = arrsh[right];

		arrsh[right] = temp;
	}

	public void recQuickSort2(int left, int right) {
		int size = right - left + 1;
		if (size <= 3) // manual sort if small
			manualSort(left, right);
		else // quicksort if large
		{
			int median = medianOf3(left, right);
			int partition = partitionIt2(left, right, median);
			recQuickSort2(left, partition - 1);
			recQuickSort2(partition + 1, right);
		}
	} // end recQuickSort()

	public int medianOf3(int left, int right) {
		int center = (left + right) / 2;
		// order left & center
		if (arrsh[left] > arrsh[center])
			swap(left, center);
		// order left & right
		if (arrsh[left] > arrsh[right])
			swap(left, right);
		// order center & right
		if (arrsh[center] > arrsh[right])
			swap(center, right);
		swap(center, right - 1); // put pivot on right
		return arrsh[right - 1]; // return median value
	} // end medianOf3()

	public int partitionIt2(int left, int right, int pivot) {
		int leftPtr = left; // right of first elem
		int rightPtr = right - 1; // left of pivot
		while (true) {
			while (arrsh[++leftPtr] < pivot)
				// find bigger
				; // (nop)
			while (arrsh[--rightPtr] > pivot)
				// find smaller
				; // (nop)
			if (leftPtr >= rightPtr) // if pointers cross,
				break; // partition done
			else
				// not crossed, so
				swap(leftPtr, rightPtr); // swap elements
		} // end while(true)
		swap(leftPtr, right - 1); // restore pivot
		return leftPtr;
	} // end partitionIt()

	public void manualSort(int left, int right) {
		int size = right - left + 1;
		if (size <= 1)
			return; // no sort necessary
		if (size == 2) { // 2-sort left and right
			if (arrsh[left] > arrsh[right])
				swap(left, right);
			return;
		} else // size is 3
		{ // 3-sort left, center, & right
			if (arrsh[left] > arrsh[right - 1])
				swap(left, right - 1); // left, center
			if (arrsh[left] > arrsh[right])
				swap(left, right); // left, right
			if (arrsh[right - 1] > arrsh[right])
				swap(right - 1, right); // center, right
		}
	} // end manualSort()
}