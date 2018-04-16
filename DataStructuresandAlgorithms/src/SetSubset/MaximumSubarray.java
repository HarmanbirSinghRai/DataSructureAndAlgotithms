package SetSubset;

/*
 * http://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class MaximumSubarray {
	
	
	
	// A utility funtion to find maximum of two integers
	int max(int a, int b) { return (a > b)? a : b; }
	 
	// A utility funtion to find maximum of three integers
	int max(int a, int b, int c) { return max(max(a, b), c); }
	 
	
	int maxSubArraySum(int arr[], int l, int h)
	{
	   // Base Case: Only one element
	   if (l == h)
	     return arr[l];
	 
	   // Find middle point
	   int m = (l + h)/2;
	 
	   /* Return maximum of following three possible cases
	      a) Maximum subarray sum in left half
	      b) Maximum subarray sum in right half
	      c) Maximum subarray sum such that the subarray crosses the midpoint */
	   int left=maxSubArraySum(arr, l, m);
	   int right=maxSubArraySum(arr, m+1, h);
	   int midscross=maxCrossingSum(arr, l, m, h);
	   int combined=left+right;
	   System.out.println("Left "+left+" Right "+right+" midscross "+midscross+" Combined "+combined );
	 /**  return max(maxSubArraySum(arr, l, m),
	              maxSubArraySum(arr, m+1, h),
	              maxCrossingSum(arr, l, m, h));**/
	   return max(left,right,midscross); 
	}
	
	int maxCrossingSum(int arr[], int l, int m, int h)
	{
	    // Include elements on left of mid.
	    int sum = 0;
	    int left_sum = Integer.MIN_VALUE;
	    for (int i = m; i >= l; i--)
	    {
	        sum = sum + arr[i];
	        if (sum > left_sum)
	          left_sum = sum;
	    }
	 
	    // Include elements on right of mid
	    sum = 0;
	    int right_sum = Integer.MIN_VALUE;
	    for (int i = m+1; i <= h; i++)
	    {
	        sum = sum + arr[i];
	        if (sum > right_sum)
	          right_sum = sum;
	    }
	 
	    // Return sum of elements on left and right of mid
	    return left_sum + right_sum;
	}
	
	public static void main(String[] args) 
	 {
		MaximumSubarray maxdif = new MaximumSubarray();
	     int arr[] = {-2, -5, 6, -2, -3, 1, 5, -6};//109
	     //int arr[] =  {2, 3, 10, 6, 4, 8, 1};//8
	     //int arr[] =  {7, 9, 5, 6, 3, 2};//9
	     int size = arr.length;
	     /**System.out.println("MaximumSubarray is " + 
	                             maxdif.maxSubArraySum(arr,0, size-1));**/
	     
	     System.out.println("MaximumSubarray is " + 
                 maxdif.maxSubArraySum_Kadane(arr));
	}
	
	//The Kadane’s Algorithm 
	 int maxSubArraySum_Kadane(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
 
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

}
