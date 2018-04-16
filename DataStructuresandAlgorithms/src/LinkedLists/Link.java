package LinkedLists;

public class Link {
	public int iData;
	public Link next;
	
	public Link(int a){
		iData=a;
	}
	
	public void display(){
		System.out.print("{" + iData  + "} ");
	}

}
