package Chapter5Lists;

public class FirstLastlist {
	
	public Link first=null;
	public Link last=null;
	
	FirstLastlist(){
		 first=null;
		last=null;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insertFirst(int key){
		Link newlink=new Link(key);
		if(isEmpty()){
			last=newlink;
		}
		newlink.next=first;
		first=newlink;
	}

	public void insertLast(int key){
		Link newlink=new Link(key);
		if(isEmpty()){
			first=newlink;
		}else{
			last.next=newlink;
		}
		last=newlink;
	}
	
    public void deleteFirst(){
	 
    	if(first.next==null){
    		last=null;
    	}
    	first=first.next;
    	
    }
    
    public void displayList()
    {
    System.out.print("List (first-->last): ");
    Link current = first; // start at beginning
    while(current != null) // until end of list,
    {
    current.display(); // print data
    current = current.next; // move to next link
    }
    System.out.println("");
    }
    
    public void reverse(){
    	Link previous=null;
    	Link current=first;
    	Link temp=first;
    	first=last;
    	last=temp;
    	while(current!=null){
    		Link next=current.next;
    		current.next=previous;
    		previous=current;
    		current=next;
    		
    	}
    //	first=previous;
    }
}
