package LinkedLists;

public class DoublyLinkedApp {
	public static void main(String[] args)
	{ // make a new list
		DoublyEndedlist theList = new DoublyEndedlist();
	theList.insertFirst(22); // insert at front
	theList.insertFirst(44);
	theList.insertFirst(66);
	theList.insertLast(11); // insert at rear
	theList.insertLast(33);
	theList.insertLast(55);
	theList.displayForward(); // display list forward
	theList.displayBackward(); // display list backward
	theList.deleteFirst(); // delete first item
	theList.deleteLast(); // delete last item
	theList.deletekey(11); // delete item with key 11
	theList.displayForward(); // display list forward
	theList.insertAfter(22, 77); // insert 77 after 22
	theList.insertAfter(33, 88); // insert 88 after 33
	theList.displayForward(); // display list forward
	theList.reverse();
	theList.displayForward();
	//theList.displayBackward();
	theList.reverserecursive(theList.First);
	theList.displayForward();
	} // end main()

}
