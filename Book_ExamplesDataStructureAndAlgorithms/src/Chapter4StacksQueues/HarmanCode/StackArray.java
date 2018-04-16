package Chapter4StacksQueues.HarmanCode;

public class StackArray {
	
	int arr[];
	int size;
	int maxsize;
	
	StackArray(int a){
		arr=new int[a];
		size=-1;
		maxsize=a;
	}
	
	public void push(int item){
		
		if(size+1<maxsize){
			arr[++size]=item;
			
		}else{
			System.out.println("Stack is full");
		}
	}
	
	
	public int pop(){
		int item;
		if(size>=0){
		item=arr[size];
		arr[size]=0;
		
		size--;
	
		return item;
		}else{
			System.out.println("Stack is full");
			return -1;
			
		}
	}
   public int getSize() {
	   return size+1;
         }
   public boolean isEmpty(){
	   if(size==-1){
		   return true;
	   }else{
		   return false;
	   }
   }

   
   
}
	
	


