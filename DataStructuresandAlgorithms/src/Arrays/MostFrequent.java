package Arrays;
import java.util.HashMap;

/**
 * 
 * @author harmanbir
 *2. Most Frequent

Given an integer array, find the most frequent number and it's count in the array. Write the

code in O(1) space. Eg 1 , 3, 4, 5, 2, 2, 3, 2 Output Most frequent number is 2. The

frequency is 3. Return the output as string in 'number: frequency' format. e.g. 2: 3 (Please

note the space after : and frequency. If multiple numbers have the same highest frequency

return the smallest number.
 */
public class MostFrequent {

	public static void main(String[] agrs) {
		HashMap<Integer,Integer> numTable=new HashMap<Integer,Integer>();
		int[] arr=new int[]{1 , 3, 4, 5, 2, 2, 3, 2,4,4};
		int max=0;
		int value=Integer.MAX_VALUE;
		for(int i:arr){
			int count=0;
			 if(numTable.containsKey(i))
	            {
				 
				 count=numTable.get(i);
				 count+=1;
	                // increment count corresponding to c
					numTable.put(  i ,  count );
	            }
	            else
	            { 
	            	count=1;
	            	numTable.put( i , count ) ;
	            }
		       if(count>max){
		    	   max=count;
		    	   value=i;
		       }
			
			
		}
		if(value!=Integer.MAX_VALUE){
			System.out.println("Value is "+value+":"+numTable.get(value));
		}
		
	}
	
}
