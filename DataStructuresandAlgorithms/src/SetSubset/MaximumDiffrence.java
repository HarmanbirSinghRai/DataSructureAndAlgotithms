package SetSubset;

public class MaximumDiffrence {
	/* The function assumes that there are at least two
    elements in array.
    The function returns a negative value if the array is
    sorted in decreasing order.
    Returns 0 if elements are equal  */
 int maxDiff(int arr[], int arr_size) 
 {
     int max_diff =Integer.MIN_VALUE;
     int min_element = arr[0];
     int i;
     for (i = 1; i < arr_size; i++) 
     {
    	int currentdiff= arr[i] - min_element;
         if (currentdiff > max_diff)
             max_diff = currentdiff;
         if (arr[i] < min_element)
             min_element = arr[i];
     }
     return max_diff;
 }

 /* Driver program to test above functions */
 public static void main(String[] args) 
 {
     MaximumDiffrence maxdif = new MaximumDiffrence();
     //int arr[] = {1, 2, 90, 10, 110};//109
     //int arr[] =  {2, 3, 10, 6, 4, 8, 1};//8
     int arr[] =  {7, 9, 5, 6, 3, 2};//9
     int size = arr.length;
     System.out.println("MaximumDifference is " + 
                             maxdif.maxDiff(arr, size));
}
}
