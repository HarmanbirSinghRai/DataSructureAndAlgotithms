import java.util.*;  
  
/** 
 * https://modernpathshala.com/Learn/data-structure/Tutorial/8388/counting-sort
 * 
 */  
public class CountingSort {  
  
    public static int[] sort(int[] inputArray) {  
        int[] outputArray = new int[inputArray.length];  
        // find max element  
        int max = inputArray[0];  
        for (int i = 1; i < inputArray.length; i++) {  
            if (inputArray[i] > max) {  
                max = inputArray[i];  
            }  
        }  
        int[] auxArray = new int[max+1];  
          
        // count number of times each element has occured  
        for (int i = 0; i < inputArray.length; i++) {  
            auxArray[inputArray[i]] = auxArray[inputArray[i]] + 1;  
        }  
        // indexing of each element in final array  
        for (int i = 1; i < auxArray.length; i++) {  
            auxArray[i] = auxArray[i] + auxArray[i - 1];  
        }  
        //build outputArray based on indexing in each element in auxArray  
        for (int j = inputArray.length-1; j >=0; j--) {  
            outputArray[--auxArray[inputArray[j]]] = inputArray[j];  
        }  
          
        return outputArray;   
    }  
  
    public static void main(String[] args) {  
  
        int[] unsorted = { 10, 2, 6, 8, 0, 8, 4, 6, 6, 8, 3, 4, 4, 7, 8, 8 };  
        System.out.println("Before sorting : " + Arrays.toString(unsorted));  
  
        int[] sorted = sort(unsorted);  
        System.out.println("After sorting :  " + Arrays.toString(sorted));  
  
    }  
}  