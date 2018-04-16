package LinkedLists;

public class CircularLinkedList {
	
	public static void main(String[] args){
		DoublyEndedlist theList = new DoublyEndedlist();
		theList.insertFirst(22); // insert at front
		theList.insertFirst(44);
		theList.insertFirst(66);
		theList.insertLast(11); // insert at rear
		theList.insertLast(33);
		theList.insertLast(55);
		theList.insertLastLink(theList.First);
		
		System.out.println(isCircular(theList));
	}
	
	@SuppressWarnings("unused")
	public static boolean isCircular(DoublyEndedlist theList) {
		
		if(theList.First==null) {
			return false;
		}
		
		DoubleLink First=theList.First;
		DoubleLink link=First.next;
		while(link!=null&&!(First==link)) {
			link=link.next;
		}
		
		if(First==link) {
		return true;	
		}
		return false;
	}
	
	
	int detectAndRemoveLoop(DoublyEndedlist LList) {
		DoubleLink node=LList.First;
		DoubleLink slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
 
            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
               // removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }
	
	
	// Function to remove loop
    void removeLoop(DoubleLink loop, DoubleLink head) {
    	DoubleLink ptr1 = loop;
    	DoubleLink ptr2 = loop;
 
        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }
 
        // Fix one pointer to head
        ptr1 = head;
 
        // And the other pointer to k nodes after head
        ptr2 = head;
        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }
 
        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
 
        // Get pointer to the last node
        ptr2 = ptr2.next;
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
 
        /* Set the next node of the loop ending node
         to fix the loop */
        ptr2.next = null;
    }
 

}
