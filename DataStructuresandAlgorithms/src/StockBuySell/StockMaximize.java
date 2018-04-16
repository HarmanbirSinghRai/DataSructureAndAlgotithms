package StockBuySell;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StockMaximize {
	public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of stocks");
       // int numOfTestCase = sc.nextInt();
       // for (int i = 0; i < numOfTestCase; i++) {
               int n = sc.nextInt();
               long profit = 0;
               int[] stockPrice = new int[n];
               System.out.println("Enter "+n +" different  stock prices");
               for (int j = 0; j < n; j++) {
                     stockPrice[j] = sc.nextInt();
               }
              
               int currMax = Integer.MIN_VALUE;
              
               for (int j = 1; j < n; j++) {
                     if (currMax < stockPrice[j]) {
                            currMax = stockPrice[j];
                     }
                     profit += (currMax - stockPrice[j]);
               }
               System.out.println(profit);
              
              
      //  }
        sc.close();
 }

}
