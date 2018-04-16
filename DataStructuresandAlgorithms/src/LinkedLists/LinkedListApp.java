package LinkedLists;

public class LinkedListApp {
	
	public static void main(String[] args){
		LinkedList ll=new LinkedList();
		ll.insert(10);
		ll.insert(20);
		ll.insert(30);
		ll.insert(40);
		ll.insert(50);
		ll.insert(60);
		Link found=ll.find(50);
		if(found!=null){
			System.out.print("Key Found ");
			found.display();
			
		}else{
			System.out.print("Key not Found");	
		}
		System.out.println("");
		ll.deletekey(90);
		ll.iterate();
		ll.reverse();
		System.out.println("");
		ll.iterate();
		ll.reverseRecursive2(ll.first);
		System.out.println("");
		ll.iterate();
		System.out.println("");
		//ll.iterate();
		//System.out.println("");
		//while(!ll.isEmpty()){
		//	Link temp=ll.deleteFirst();
		//	System.out.print("Deleted link is ");
		//	temp.display();
		//	System.out.println("");
		//}
	}
	
	

}
