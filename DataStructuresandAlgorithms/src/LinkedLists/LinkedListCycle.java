package LinkedLists;

//Java program to detect and remove loop in linked list

public class LinkedListCycle {

 static Node head;

 
 // Function that detects loop in the list
 int detectAndRemoveLoop(Node node) {
     Node slow = node, fast = node;
     while (slow != null && fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;

         // If slow and fast meet at same point then loop is present
         if (slow == fast) {
             removeLoop(slow, node);
             return 1;
         }
     }
     return 0;
 }

 // Function to remove loop
 void removeLoop_starightapproach_1(Node loop, Node curr) {
     Node ptr1 = null, ptr2 = null;

     /* Set a pointer to the beging of the Linked List and
      move it one by one to find the first node which is
      part of the Linked List */
     ptr1 = curr;
     while (true) {

         /* Now start a pointer from loop_node and check if it ever
          reaches ptr2 */
         ptr2 = loop;
         while (ptr2.next != loop && ptr2.next != ptr1) {
             ptr2 = ptr2.next;
         }

         /* If ptr2 reahced ptr1 then there is a loop. So break the
          loop */
         if (ptr2.next == ptr1) {
             break;
         }

         /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
         ptr1 = ptr1.next;
     }

     /* After the end of loop ptr2 is the last node of the loop. So
      make next of ptr2 as NULL */
     ptr2.next = null;
 }
 
//Function to remove loop
 void removeLoop(Node loop, Node head) {
	 Node ptr1 = loop;
	 Node ptr2 = loop;

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

 // Function to print the linked list
 void printList(Node node) {
     while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
     }
 }

 // Driver program to test above functions
 public static void main(String[] args) {
     LinkedListCycle list = new LinkedListCycle();
     list.head = new Node(50);
     list.head.next = new Node(20);
     list.head.next.next = new Node(15);
     list.head.next.next.next = new Node(4);
     list.head.next.next.next.next = new Node(10);
     list.head.next.next.next.next.next = new Node(25);
     list.head.next.next.next.next.next.next = new Node(5);
     list.head.next.next.next.next.next.next.next = new Node(35);
     list.head.next.next.next.next.next.next.next.next = new Node(45);
     list.head.next.next.next.next.next.next.next.next.next = new Node(6);
     list.head.next.next.next.next.next.next.next.next.next.next = new Node(18);
     list.head.next.next.next.next.next.next.next.next.next.next.next = new Node(29);
     // Creating a loop for testing 
     list.head.next.next.next.next.next.next.next.next.next.next.next.next = head.next.next.next;
     list.detectAndRemoveLoop(head);
     System.out.println("Linked List after removing loop : ");
     list.printList(head);
 }
}

 class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}


//This code has been contributed by Mayank Jaiswal
