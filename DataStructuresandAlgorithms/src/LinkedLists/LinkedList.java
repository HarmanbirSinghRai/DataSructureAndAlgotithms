package LinkedLists;

public class LinkedList {
	public Link first;
	
	LinkedList(){
		first=null;
	}
	
	public boolean isEmpty(){
		if(first==null)
			return true;
		else
			return false;
	}
    
	public void insert(int a){
		Link newlink=new Link(a);
		newlink.next=first;
		first=newlink;
	}
	
	public Link deleteFirst(){
		Link temp=first;
		first=first.next;
		return temp;
	}
	
	public void iterate(){
		Link current=null;
		current=first;
		while (current!=null){
			current.display();
			current=current.next;
		}
	}
	
	public Link find(int key){
		Link current=first;
		while(current!=null&&current.iData!=key){
			current=current.next;
		}
		return current;
	}
	
	public void deletekey(int key){
		Link current=first;
		Link previous=first;
		while(current!=null&&current.iData!=key){
			previous=current;
			current=current.next;
		}
		if(current!=null){
			if(current==first){
				first=first.next;
			}else{
				previous.next=current.next;
			}
		}else{
			System.out.println("No Key found to delete");
		}
		
	}
	
	public void reverse(){
		
		Link current=first;
		Link previous=null;
		Link nextlink=null;
		while(current!=null){
			 nextlink=current.next;
			 current.next=previous;
			 previous=current;
			 current=nextlink;
		}
		first=previous;
	}
	
public Link reverseRecursive(Link node){
	
	if(node==null||node.next==null){
		first=node;
		return node;
	}
	Link previous=null;	
	Link current=reverseRecursive(node.next);
	Link returnrecursive=current;
	while(current!=null){
		previous=current;
		current=current.next;
	}
	previous.next=node;
	node.next=null;
	return returnrecursive;
	}


public Link reverseRecursive2(Link node){
	
	if(node==null||node.next==null){
		first=node;
		return node;
	}
	
	Link current=reverseRecursive2(node.next);

	current.next=node;
	node.next=null;
	return node;
	}
}
