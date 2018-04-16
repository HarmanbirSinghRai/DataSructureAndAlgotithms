package Chapter4StacksQueues.HarmanCode;

public class StackArrayChar {
	
	char arr[];
	int size;
	int maxsize;
	
	StackArrayChar(int a){
		arr=new char[a];
		size=-1;
		maxsize=a;
	}
	
	public void push(char item){
		
		if(size+1<maxsize){
			arr[++size]=item;
			
		}else{
			System.out.println("Stack is full");
		}
	}
	
	
	public char pop(){
		char item;
		//if(size>=0){
		item=arr[size];
		arr[size]=0;
		
		size--;
	
		return item;
		//}
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
