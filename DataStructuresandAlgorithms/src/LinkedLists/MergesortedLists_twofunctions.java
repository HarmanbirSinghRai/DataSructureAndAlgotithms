package LinkedLists;


public class MergesortedLists_twofunctions {

	public static void main(String[] args){
		LinkedList ll1=new LinkedList();
		ll1.insert(10);
		ll1.insert(30);
		ll1.insert(50);
		ll1.insert(70);
		ll1.insert(90);
		ll1.insert(110);
		
		LinkedList ll2=new LinkedList();
		ll2.insert(20);
		ll2.insert(40);
		ll2.insert(60);
		ll2.insert(80);
		ll2.insert(100);
		ll2.insert(120);
		
		LinkedList ll3=new LinkedList();
		ll3.first=mergeTwoLists(ll1.first,ll2.first);
		
		//ll3.iterate();
		ll3.reverse();
		ll3.iterate();
		
		System.out.println("");
		
		LinkedList unsorted=new LinkedList();
		unsorted.insert(10);
		unsorted.insert(30);
		unsorted.insert(50);
		unsorted.insert(70);
		unsorted.insert(90);
		unsorted.insert(110);
		unsorted.insert(20);
		unsorted.insert(40);
		unsorted.insert(60);
		unsorted.insert(80);
		unsorted.insert(100);
		unsorted.insert(120);
		LinkedList sorted=new LinkedList();
		sorted.first=mergeSort(unsorted.first);
		sorted.iterate();
		//System.out.println("");
		//while(!ll.isEmpty()){
		//	Link temp=ll.deleteFirst();
		//	System.out.print("Deleted link is ");
		//	temp.display();
		//	System.out.println("");
		//}
	}
	
	
	public static Link mergeTwoLists(Link l1, Link l2) {
	    Link head = new Link(0);
	    Link p = head;
	 
	    while(l1!=null||l2!=null){
	        if(l1!=null&&l2!=null){
	            if(l1.iData > l2.iData){
	                p.next = l1;
	                l1=l1.next;
	            }else{
	                p.next=l2;
	                l2=l2.next;
	            }
	            p = p.next;
	        }else if(l1==null){
	            p.next = l2;
	            break;
	        }else if(l2==null){
	            p.next = l1;
	            break;
	        }
	    }
	 
	    return head.next;
	}
	
	
	/******Merge sort singles list ************/
	static Link sortedMerge(Link a, Link b) 
    {
        Link result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;
 
        /* Pick either a or b, and recur */
        if (a.iData <= b.iData) 
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        } 
        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
 
    }
 
	static Link mergeSort(Link h) 
    {
        // Base case : if head is null
        if (h == null || h.next == null)
        {
            return h;
        }
 
        // get the middle of the list
        Link middle = getMiddle(h);
        Link nextofmiddle = middle.next;
 
        // set the next of middle Link to null
        middle.next = null;
 
        // Apply mergeSort on left list
        Link left = mergeSort(h);
 
        // Apply mergeSort on right list
        Link right = mergeSort(nextofmiddle);
 
        // Merge the left and right lists
        Link sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
 
    // Utility function to get the middle of the linked list
	static Link getMiddle(Link h) 
    {
        //Base case
        if (h == null)
            return h;
        Link fastptr = h.next;
        Link slowptr = h;
         
        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle Link
        while (fastptr != null)
        {
            fastptr = fastptr.next;
            if(fastptr!=null)
            {
                slowptr = slowptr.next;
                fastptr=fastptr.next;
            }
        }
        return slowptr;
    }
	
}



