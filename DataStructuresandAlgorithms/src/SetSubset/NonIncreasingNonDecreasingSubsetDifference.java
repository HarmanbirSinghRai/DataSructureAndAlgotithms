package SetSubset;
/*
 * https://careercup.appspot.com/question?id=5666344952397824
 * This was the 2nd round. Face to face. DS and Algo 
Q1) Given an array 'A' of size 'n' and a number 'm' such that 'm <= n'. For all subsets of 'A' of size 'm', 
return the difference between the number of non-increasing and non-decreasing sub-sequences. 

 */
public class NonIncreasingNonDecreasingSubsetDifference {

	public static void main(String[] args){
		
        //int sequence[] = {1, 2, 3, 4, 1, 8, 9, 11, 2, 1, 0,5,6,8,1,1,0};
        int sequence[] = {1, 2, 3, 4, 1, 8, 9, 11, 2, 1, 0};
        int subset=2;
        printDifference(sequence,subset);
      printDifferenceVersion2(sequence,subset);
       printDifferenceVersion3(sequence,subset);
}
	// copied from https://careercup.appspot.com/question?id=5666344952397824
	public static void printDifference(int[] sequence,int m){
		/**
         * n = 11
         * arr = {1, 2, 3, 4, 1, 8, 9, 11, 2, 1, 0}
         * m = 3
         * increasing sequences of size 3 = [(1,2,3),(2,3,4),(1,8,9),(8,9,11)]
         * decreasing sequences of size 3 = [(11,2,1),(2,1,0)]
         * diff =
         */
       int length=sequence.length;
      //  int sequence[] = {1, 2, 3, 4, 1, 8, 9, 11, 2, 1, 0};
        int incCount[] = new int[length];
        int decCount[] = new int[length];
        int diff = 0;

        incCount[0] = 1;
        decCount[0] = 1;
        for( int i = 1; i <= length - 1; i++ ){
            if( sequence[i] >= sequence[i-1] ) {
                incCount[i] = incCount[i-1] + 1;
                decCount[i] = 1;
            }else{
                incCount[i] = 1;
                decCount[i] = decCount[i-1] + 1;
            }
        }

        for( int i = 1; i <= sequence.length - 1; i++ ){
            if( incCount[i] >= m) diff += 1;
            if( decCount[i] >= m) diff -= 1;
        }

        System.out.println(Math.abs(diff));
		
		
	}
	

		public static void printDifferenceVersion3(int[] sequence,int m){
			/**
	         * n = 11
	         * arr = {1, 2, 3, 4, 1, 8, 9, 11, 2, 1, 0}
	         * m = 3
	         * increasing sequences of size 3 = [(1,2,3),(2,3,4),(1,8,9),(8,9,11)]
	         * decreasing sequences of size 3 = [(11,2,1),(2,1,0)]
	         * diff =
	         */

	      //  int sequence[] = {1, 2, 3, 4, 1, 8, 9, 11, 2, 1, 0};
	       // int incCount[] = new int[11];
	      //  int decCount[] = new int[11];
			int length=sequence.length;
           int incremetor=0;
           int decrementor=0;
	       int  incCount = 1;
	       int  decCount = 1;
	        for( int i = 1; i <= length - 1; i++ ){
	            if( sequence[i] >= sequence[i-1] ) {
	            	incCount = incCount + 1;
                    decCount = 1;
	                if(incCount>=m){
	                	incremetor++;
	                }
	            }else{
	                incCount = 1;
	                decCount = decCount + 1;
	                if(decCount>=m){
	                	decrementor++;
	                }
	            }
	        }
           
	      //  for( int i = 1; i <= sequence.length - 1; i++ ){
	       //     if( incCount[i] >= m) diff += 1;
	      //      if( decCount[i] >= m) diff -= 1;
	      //  }

	        System.out.println(Math.abs(incremetor-decrementor));
			
			
		}
		
	
	public static void printDifferenceVersion2(int[] sequence,int m){
		
		int  increment=0;
		int decrement=0;
		int length=sequence.length;
		for(int i=0;i<=length-m;i++){
			int incCounter=0, decCounter=0 ;
			
			for(int j=i;j<i+m-1;j++){
				if(sequence[j]<=sequence[j+1]){
					incCounter++;
				}else{
					decCounter++;
				}
				
			}
			if(incCounter==m-1) {increment++;}
			if(decCounter==m-1) {decrement++;}
			incCounter=0;decCounter=0;
		}
		
		System.out.println(Math.abs(increment-decrement));
		
	}
}