
/**
 * 
*Check if an integer array is arithmetic sequence.
*https://www.careercup.com/question?id=5724684365594624
*Example: 1, 2, 3, 4, 5, 6, 7, 8 =&gt; true
*		1, 3, 5, 7, 9 =&gt; true
*
*Array may not be sorted.</p>
 */

package CareerCupQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ArrayInSequence {
	
	public static void main(String[] args){
		ArrayList<Integer> arlist=new ArrayList<Integer>();
		int[] arry=new int[10];
		int arth=45;
		int diff=3;
		//arry[0]=arth;
		for (int i=0;i<10;i++){
			//int a=(int)Math.ceil(java.lang.Math.random()*10);
			arry[i]=arth+i*diff;
		//diff=3;
		}
		
		arry=RandomizeArray(arry);
		//Collections.shuffle(Arrays.asList(arry));
	for (int i=0;i<10;i++){
		System.out.print(arry[i]+" ");
		
	}
	//boolean result=arthmeticProgression(arry);
	boolean result=checkArithmecticProgression(arry);
	System.out.println("Array is arithmetic " + result);
	/**System.out.println(" ");
	for (int i=0;i<10;i++){
		
		System.out.print((int)Math.ceil(java.lang.Math.random()*10)+" ");
	}**/
}
	
	public static boolean arthmeticProgression(int[] arry){
		int diff=0;
		if(arry.length==1){
			return true;
		}if(arry.length==2){
		  return (arry[1]>arry[0])?true:false;
		}
		diff=arry[1]-arry[0];
		for(int i=2;i<arry.length;i++){
			if(arry[i]!=arry[0]+diff*i)
				return false;
		}
		return true;
		
	}
	
	
	public static int[] RandomizeArray(int[] array){
		final Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
	
	public static boolean checkArithmecticProgression(int[] arry){
		
		int diff=0;
		int length=arry.length;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		boolean[] diffset =new boolean[length];
		if(length==0){
			return false;
		}
		if(length==1){
			return true;
		}if(length==2){
		  return (arry[1]!=arry[0])?true:false;
		}
		for(int i=0;i<arry.length;i++){
			if(arry[i]<min){
				min=arry[i];
			}
			
			if(arry[i]>max){
				max=arry[i];
			}
		}
		diff=(max-min)/(length-1);
		int count=0;
		for (int i=0;i<length;i++){
			
			int diffvarr=(arry[i]-min)/diff;
			if(!(diffvarr>=0&&diffvarr<=length)){
				continue;
			}
			if(diffset[diffvarr]==false){
				diffset[diffvarr]=true;
				count++;
			}
		}
		if(count!=length){
			return false;
		}
		
		return true;
	}
}
