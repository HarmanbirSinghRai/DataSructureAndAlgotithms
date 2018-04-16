package Arrays;
public class MedianOfTwoSortedArray {  
  
    public static void main(String[] args) {  
        int[] arr1 = {1,2,3,4,5};  
        int[] arr2 = {6,7,8,9,10};  
        System.out.println(median(arr1, arr2));  
    }  
  
    public static float median(int[] arr1, int[] arr2)  
    {  
        int N = arr1.length;  
        return median(arr1, 0, N -1 , arr2, 0, N - 1);  
    }  
    public static float median(int[] arr1, int low1, int high1, int[] arr2, int low2, int high2)  
    {  
        int mid1 = (high1 + low1 ) / 2;  
        int mid2 = (high2 + low2 ) / 2;  
  
        if (arr1[mid1] == arr2[mid2]){  
            return arr1[mid1];  
        }  
        else if (high1 - low1 == 1){  
            return (float) ((Math.max(arr1[low1] , arr2[low2]) + Math.min(arr1[high1] , arr2[high2]))/2.0);  
        }  
        else if (arr1[mid1] > arr2[mid2]){  
             return median(arr1, low1, mid1 , arr2, mid2 , high2);   
        }  
        else{  
            return median(arr1, mid1 , high1, arr2, low2 , mid2 );   
        }  
    }     
}  