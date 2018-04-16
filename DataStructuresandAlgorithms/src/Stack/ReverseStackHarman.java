package Stack;

import java.util.Iterator;
import java.util.Stack;

public class ReverseStackHarman {
	
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>();
		
		 stack.push(1);
	        stack.push(2);
	        stack.push(3);
	        stack.push(4);
	        stack.push(5);
	        stack.push(6);
	        
	        Iterator<Integer> itr =  stack.iterator();
	        while(itr.hasNext()){
	            System.out.println(itr.next());
	        }
	        
	        reverse(stack);
	        
	        itr =  stack.iterator();
	        while(itr.hasNext()){
	            System.out.println(itr.next());
	        }
		
	}
	
	

     private static void reverse(Stack<Integer> stack) {
		// TODO Auto-generated method stub
//	void reserve(Stack<Integer> stack) {
		
		 if(stack.size() == 0){
	           
	            return;
	        }
	        int temp = stack.pop();
	        reserve(stack);
	        stack.push(temp);
		
	}



	private static void reserve(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		
	}

}
