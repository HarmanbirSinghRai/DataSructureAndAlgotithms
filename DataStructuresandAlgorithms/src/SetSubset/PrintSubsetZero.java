/**
  Print all subset of a given set which sums up to ZERO 
{8,3,5,1,-4,-8} 
so ans will be : {8,-8} 
{3,5,-8} 
{3,1,-4} 

size of set can be upto 50 but elemet of set can be as big as 18 digit number
 */


package SetSubset;

import java.util.Arrays;
import java.util.Stack;

public class PrintSubsetZero {
	private static Stack<Long> stk;
	public static void main(String[] args){
		long[] zarr={8,3,5,1,-4,-8};
		int total=0;
	printsubsets(zarr,total);
		//printZeroSubsets(zarr);
		
	}
	public static void printsubsets(long[] zarr){
		stk=new Stack<Long>();
		printsubsets(zarr,0,0);
		
	}
	public static void printsubsets (long[] zarr,int next,long sum){
		
		if(sum==0){
			for(long y:stk)
			System.out.print(y +","); 
			
			System.out.println();
		}
		if(next<zarr.length && Long.MAX_VALUE-sum<zarr[next]){
			return;
		}
		for(int i=next;i<zarr.length;i++){
			long value=zarr[i];
			
			stk.push(value);
			printsubsets(zarr,i+1,sum+value);
			stk.pop();
		}
		//System.exit(0);
	}
	
	////////method2 passing stack and total

	
	public static void printsubsets(long[] zarr, int total ){
		Stack<Long> stack=new Stack<Long>();
		printsubsets(zarr,0,0,stack,total,zarr.length);
		
	}
	public static void printsubsets (long[] zarr,int next,long sum,Stack<Long> stack,int total, int arrlength){
		
		if(sum==total){
			for(long y:stack)
			System.out.print(y +","); 
			
			System.out.println();
		}
		if(next<zarr.length && Long.MAX_VALUE-sum<zarr[next]){
			return;
		}
			
		for(int i=next;i<arrlength;i++){
			long value=zarr[i];
			
			stack.push(value);
			printsubsets(zarr,i+1,sum+value,stack,total,arrlength);
			stack.pop();
		}
		//System.exit(0);
	}
	

}
