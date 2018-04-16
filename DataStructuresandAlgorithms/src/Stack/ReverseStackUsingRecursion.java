package Stack;




import java.util.Iterator;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 */
public class ReverseStackUsingRecursion {

    public void reverse(Stack<Integer> stack){
        if(!(stack.size() == 0)){
          
       
        int temp = stack.pop();
        reverse(stack);
        
        pushAtBottom(stack,temp);
        }
    }
    
    private void pushAtBottom(Stack<Integer> stack,int data){
        //if(stack.size() == 0|| data > stack.peek()){
    	 if(stack.size() == 0){
            stack.push(data); //if(stack.size() == 0|| data > stack.peek()){ //if(stack.size() == 0|| data > stack.peek()){
            //if(stack.size() == 0|| data > stack.peek()){
            return;
        }
        int temp = stack.pop();
        pushAtBottom(stack, data);
        stack.push(temp);
    }
    
    private void pushAtBottom2(Stack<Integer> stack,int data){
    	if(stack.size() == 0){
            stack.push(data);
            return;
        }
    	pushAtBottom2(stack,stack.pop());
        
        int temp = stack.pop();
        pushAtBottom(stack, data);
        stack.push(temp);
    }                                                                                         
    
    public static void main(String args[]){
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
        
        ReverseStackUsingRecursion rsu = new ReverseStackUsingRecursion();
        rsu.reverse(stack);
       // rsu.pushAtBottom2(stack,stack.pop());
        
        itr =  stack.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        
    }
    
}

