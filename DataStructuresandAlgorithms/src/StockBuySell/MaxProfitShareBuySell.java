

package StockBuySell;
/**
 * http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
 * http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 Input:  
Price = [10, 22, 5, 75, 65, 80]
    K = 2
Output:  87
Trader earns 87 as sum of 12 and 75
Buy at price 10, sell at 22, buy at 
5 and sell at 80

Input:  
Price = [12, 14, 17, 10, 14, 13, 12, 15]
    K = 3
Output:  12
Trader earns 12 as sum of 5, 4 and 3
Buy at price 12, sell at 17, buy at 10 
and sell at 14 and buy at 12 and sell
at 15
 
Input:  
Price = [100, 30, 15, 10, 8, 25, 80]
    K = 3
Output:  72
Only one transaction. Buy at price 8 
and sell at 80.

Input:  
Price = [90, 80, 70, 60, 50]
    K = 1
Output:  0
Not possible to earn. 
 *
 */


public class MaxProfitShareBuySell {

	public static void main(String[] args){
		
     	int transaction=2;
		int price[]={5,22,10,75,65,80};
		//int price[]={10,22,65,80};
		//int transaction=3;
		//int price[]={100, 30, 15, 10, 8, 25, 80};
		int profit=maxProfit2(price,price.length,transaction);
		
		System.out.println("Max profit is "+ profit);
	}
	
	static int maxProfit(int[] price,int n,int k){
		 // table to store results of subproblems
	    // profit[t][i] stores maximum profit using
	    // atmost t transactions up to day i (including
	    // day i)
	   // int [][]profit=new int[k+1][n+1];
	    int [][]profit=new int[k+1][n];
	 
	    // For day 0, you can't earn money
	    // irrespective of how many times you trade
	    for (int i = 0; i <= k; i++)
	        profit[i][0] = 0;
	 
	    // profit is 0 if we don't do any transation
	    // (i.e. k =0)
	    for (int j= 0; j < n; j++)
	        profit[0][j] = 0;
	 
	    // fill the table in bottom-up fashion
	    for (int i = 1; i <= k; i++)
	    {
	        for (int j = 1; j < n; j++)
	        {
	            int max_so_far = Integer.MIN_VALUE;
	 
	            for (int m = 0; m < j; m++){
	            	int thistrade=price[j] - price[m] + profit[i-1][m];

                    /**int thistrade=price[j] - price[m] ;//+ profit[i-1][m-1];
	            	if(m>0) {
	            	thistrade=thistrade+profit[i-1][m-1];
	            	}**/
	                max_so_far = Math.max(max_so_far,thistrade);
	            }
	               int previousdaytransaction=profit[i][j-1];
	            profit[i][j] = Math.max(previousdaytransaction, max_so_far);
	        }
	    }
	    
	   
	 
	 
	    return profit[k][n-1];
	}
	
	
	static int maxProfit2(int[] price,int n,int k){
		 // table to store results of subproblems
	    // profit[t][i] stores maximum profit using
	    // atmost t transactions up to day i (including
	    // day i)
	   // int [][]profit=new int[k+1][n+1];
	    int [][]profit=new int[k+1][n];
	 
	    // For day 0, you can't earn money
	    // irrespective of how many times you trade
	    for (int i = 0; i <= k; i++)
	        profit[i][0] = 0;
	 
	    // profit is 0 if we don't do any transation
	    // (i.e. k =0)
	    for (int j= 0; j < n; j++)
	        profit[0][j] = 0;
	 
	 
	    
	    for (int i = 1; i <= k; i++)
	    {
	    	 int max_so_far = Integer.MIN_VALUE;
	        for (int j = 1; j < n; j++)
	        {
	           
	 
	          //  for (int m = 0; m < j; m++){
	          //  	int thistrade=price[j] - price[m] + profit[i-1][m];
	        	int thistrade=0;
	        	    if(j>1) {
	        	     thistrade=profit[i-1][j-2]-price[j-1];
	        	    }else {
	        	    	 thistrade=0-price[j-1];
	        	    }
	                max_so_far = Math.max(max_so_far,thistrade);
	            
	               int previousdaytransaction=profit[i][j-1];
	            profit[i][j] = Math.max(previousdaytransaction, price[j] + max_so_far);
	        }
	    }
	 
	 
	    return profit[k][n-1];
	}
}
