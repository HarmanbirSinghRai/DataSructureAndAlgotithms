package FirstNonRepeatingChar;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class LonelyInteger {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        //getting all the numbers
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        //assigning 0th element as unique
        int unique=0;
        unique=arr[0];
        for(int i=1;i<arr.length;i++)
        {
           unique^=arr[i];
        }
        System.out.println(unique);

	}

}
