package Chapter4StacksQueues.HarmanCode;

import java.util.Scanner;

public class ReverseWordStack {
	String original;
	String reversed;
	
	ReverseWordStack(String in){
		original=in;
		}
	
	public String doReverse(){
		StringBuilder sb=new StringBuilder();
		char[] starr=original.toCharArray();
		StackArrayChar sac=new StackArrayChar(starr.length);
		for(int i=0;i<starr.length;i++){
			sac.push(starr[i]);
		}
		while(sac.isEmpty()==false){
			sb.append(sac.pop());
		}
		
		reversed=sb.toString();
		return reversed;
		
	}
	
 public static void main(String args[]){
	 
	 System.out.println("Please enter String to be reversed");
	 Scanner in = new Scanner(System.in);
	 String input=in.next();
	 ReverseWordStack rws=new ReverseWordStack(input);
	 System.out.println("revrsed String is " +rws.doReverse());
	 
 }

}
