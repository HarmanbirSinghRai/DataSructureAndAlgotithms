package Chapter4StacksQueues.HarmanCode;

public class StackPushPop {
	
	public static void main(String args[]){
		StackArray sarr=new StackArray(10);
		
	sarr.push(20);
	sarr.push(21);
	sarr.push(22);
	sarr.push(23);
	sarr.push(24);
	sarr.push(25);
	sarr.push(26);
	sarr.push(27);
	sarr.push(28);
	sarr.push(29);
	sarr.push(30);
	
	while(sarr.isEmpty()==false)
	System.out.println(sarr.pop());
	}

}
