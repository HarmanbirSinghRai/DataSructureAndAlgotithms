package Chapter5Lists;

public class DoublyEndedlist {
	
	public DoubleLink First;
	public DoubleLink Last;
	
	public DoublyEndedlist(){
		First=null;
		Last=null;
	}
	
	public boolean isEmpty(){
		return First==null ? true:false;
	}

	public void insertFirst(int a){
		DoubleLink newlink=new DoubleLink(a);
		if(isEmpty()){
			Last=newlink;
		}else{
			First.previous=newlink;
		}
		newlink.next=First;
		First=newlink;
			
		
	}
	public void insertLast(int a){
		DoubleLink newlink=new DoubleLink(a);
		if(isEmpty()){
			First=newlink;
		}else{
			Last.next=newlink;
			newlink.previous=Last;
		}
		
		Last=newlink;
		
	}
	
	public DoubleLink deleteFirst(){
		DoubleLink temp=First;
		if(First.next==null){
			Last=null;
		}else{
			First.next.previous=null;
		}
		First=First.next;
		return temp;
	}
	
	public DoubleLink deleteLast(){
		DoubleLink temp=Last;
		if(Last.previous==null){
			First=null;
		}else{
			Last.previous.next=null;
		}
		Last=Last.previous;
		return temp;
	}
	
	public void insertAfter(int key,int a){
		DoubleLink newlink=new DoubleLink(a);
		DoubleLink current=First;
		while(key!=current.iData){
			current=current.next;
			if(current==null)
				return;
		}
		if(current==Last){
			newlink.next=null;
			Last=newlink;
		
		}else{
			
			newlink.next=current.next;
			current.next.previous=newlink;
		
		}
		
		newlink.previous=current;
		current.next=newlink;
	}
	
	public DoubleLink deletekey(int a){
		//DoubleLink temp;
		DoubleLink current=First;
		while(a!=current.iData){
			current=current.next;
			if(current==null)
				return null;
		}
		if(current==Last){
			current.previous.next=null;
			Last=current.previous;
			
		}else if(current==First){
			current.next.previous=null;
			First=current.next;
		}else{
			current.previous.next=current.next;
			current.next.previous=current.previous;
		}
		
		return current;
		
	}
	
	public void displayForward(){
		System.out.print("List (First-->Last): ");
		DoubleLink current=First;
		while(current!=null){
			current.display();
			current=current.next;
		}
		System.out.println(" ");
	}
	
	public void displayBackward(){
		System.out.print("List (Last-->First): ");
		DoubleLink current=Last;
		while(current!=null){
			current.display();
			current=current.previous;
		}
		System.out.println(" ");
	}
	
	public void reverse(){
		DoubleLink current=First;
		DoubleLink previous=null;
		DoubleLink next=null;
		Last=current;
		while(current!=null){
			next=current.next;
			current.next=previous;
			current.previous=next;
			previous=current;
			current=next;
		}
		First=previous;
	}
	
}
