package Arrays;
import java.util.Arrays;
/**
 * https://stackoverflow.com/questions/7685/merge-sort-a-linked-list
 * 
 * @author harmanbir
 *
 */
public class MergeTwoSortedArray {
	 static int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
	    static int arr2[] = new int[]{2, 3, 8, 13};
	     
	    static void merge(int arr1[], int arr2[])
	    { 
	    	int m=arr1.length;
	    	int n=arr2.length;
	        // Iterate through all elements of ar2[] starting from
	        // the last element
	        for (int i=n-1; i>=0; i--)
	        {
	            /* Find the smallest element greater than ar2[i]. Move all
	               elements one position ahead till the smallest greater
	               element is not found */
	            int j, last = arr1[m-1];
	            for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--)
	                arr1[j+1] = arr1[j];
	      
	            // If there was a greater element
	            if (j != m-2 || last > arr2[i])
	            {
	                arr1[j+1] = arr2[i];
	                arr2[i] = last;
	            }
	        }
	    }
	     
	    // Driver method to test the above function
	    public static void main(String[] args) 
	    {
	        merge(arr1,arr2);
	        System.out.print("After Merging \nFirst Array: ");
	        System.out.println(Arrays.toString(arr1));
	        System.out.print("Second Array:  ");
	        System.out.println(Arrays.toString(arr2));
	    }
	    
	
 /**
	public static void main(String[] args) {
		int[] A = {3,5,7,8,9,-1,-1,-1,-1};
		int[] B = {1,4,6,10};
		
		int a = 4;
		int b = B.length - 1;
		int c = a + b + 1;
		
		mergeIntoA(A, B, a, b,c);
		printA(A);
 
	}
 
	private static void printA(int[] A) {
		System.out.println("----- Array A is ---------");
		for(int i=0; i<A.length ; i++)
		{
			System.out.print(A[i]+" ");
		}
	}
 
	private static void mergeIntoA(int[] arrA, int[] arrB, int a, int b, int c) {
		while(b >= 0 && a>=0)
		{
			if(arrB[b] >= arrA[a])
			{
				arrA[c--] = arrB[b--];
			} else {
				arrA[c--] = arrA[a--];
			}
		}
		
		while(b >= 0)
		{
			arrA[c--] = arrB[b--];
		}
	}
 
**/

}
