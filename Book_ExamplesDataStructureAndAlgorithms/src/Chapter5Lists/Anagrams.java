package Chapter5Lists;

import java.util.Scanner;

public class Anagrams {
	public int size;
	public char[] inparr;
	private int count=0;
	public static void main(String[] args){
		Anagrams ang=new Anagrams();
		System.out.println("Please enter word");
		Scanner in = new Scanner(System.in);
		  String input=in.next();
		  in.close();
		ang.size=input.length();
		ang.inparr=input.toCharArray();
		ang.doAnagram(ang.size);
	}
	
	public void doAnagram(int newsize){
		if(newsize==1)
			return;
		else{
		for(int i=1;i<=newsize;i++){
			doAnagram(newsize-1);
			if(newsize==2)
				displayword();
			rotate(newsize);
		}
		}
		 
	}
	
	public void displayword(){
		System.out.print(++count+" ");
		for(int i=0;i<size;i++){
			System.out.print(inparr[i]);
		}
		System.out.print(" ");
		
		if(count%6==0){
			System.out.println("");
		}
		
	}
	
	public void rotate(int newsize){
		int position=size-newsize;
		char temp=inparr[position];
		int j;
		for( j=position;j<size-1;j++){
			inparr[j]=inparr[j+1];
		}
		inparr[j]=temp;
		/**for( j=position+1;j<size;j++){
			inparr[j-1]=inparr[j];
		}
		inparr[j-1]=temp;**/
		
	}

}
