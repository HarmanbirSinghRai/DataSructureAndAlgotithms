package Stack;


	class StackDemo {  
	    int stck[] = new int[10];  
	    int tempStck[] = new int[10];  
	    int tos;  
	  
	    // Initialize top-of-stack  
	    StackDemo() {  
	        tos = -1;  
	    }  
	  
	    // Push an item onto the stack  
	    public void push(int item) {  
	        if (tos == 9) {  
	            System.out.println("Stack is full.");  
	        } else {  
	            ++tos;  
	            stck[tos] = item;  
	            if (tos == 0) {  
	                tempStck[tos] = item;  
	            } else {  
	                tempStck[tos] = Math.min(item, tempStck[tos - 1]);  
	                ;  
	            }  
	        }  
	    }  
	  
	    public Integer pop() {  
	        if (tos < 0) {  
	            System.out.println("Stack underflow.");  
	            return null;  
	        } else {  
	            return stck[tos--];  
	        }  
	    }  
	  
	    public Integer findMin() {  
	        if (tos < 0) {  
	            return null;  
	        } else {  
	            return tempStck[tos];  
	        }  
	    }  
	}  
	  
	public class StackMin1 {  
	    public static void main(String args[]) {  
	        StackDemo mystack1 = new StackDemo();  
	        // push some numbers onto the stack  
	        for (int i = 0; i < 10; i++) {  
	            mystack1.push((int)Math.ceil(java.lang.Math.random()*100));  
	        }  
	        for (int i = 0; i < 10; i++) {  
	        System.out.println(mystack1.pop());  
	        
	        System.out.println("Minimum Element in mystack1 = "  
	                + (mystack1.findMin() == null ? "Stack Empty" : mystack1  
	                        .findMin()));  
	        }
	        StackDemo mystack2 = new StackDemo();  
	        // Try to find minimum element in empty Stack  
	        System.out.println("Minimum Element in mystack2 = "  
	                + (mystack2.findMin() == null ? "Stack Empty" : mystack2  
	                        .findMin()));  
	    }  
	}  
