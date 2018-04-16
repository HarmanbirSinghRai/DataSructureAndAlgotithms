package LinkedLists;

public class DoubleLink {

	public int iData;
	public DoubleLink next;
	public DoubleLink previous;
	
	
	public DoubleLink(int a){
		iData=a;
	}
	
	public void display(){
		System.out.print("{" + iData  + "} ");
	}
}
