package SetSubset;

/**
 * 
 * @author HSingh Two Finite, strictly increasing, integer sequences are given.
 *         Any common integer bet ween the two sequences constitute an
 *         intersection point. Take for example the following two sequences
 *         where intersection points are printed in bold: First= 3 5 7 9 20 25
 *         30 40 55 56 57 60 62 Second= 1 4 7 11 14 25 44 47 55 57 100 You can
 *         walk over these two sequences in the following way: 1. You may start
 *         at the beginning of any of the two sequences. Now start moving
 *         forward. 2. At each intersection point, you have the choice of either
 *         continuing with the same sequence you’re currently on, or switching
 *         to the other sequence. The objective is Finding a path that produces
 *         the maximum sum of data you walked over. In the above example, the
 *         largest possible sum is 450 which is the result of adding 3, 5, 7, 9,
 *         20, 25, 44, 47, 55, 56, 57, 60, and 62
 * 
 *         this is the same problem which I saw in SPOJ Problem Set
 */

public class TwoArraysPathWithMaximumdata {

	public static void main(String[] args) {

		//int[] arr1 = { 3, 5, 7, 9, 20, 25, 30, 40, 55, 56, 57, 60, 62 };
		//int[] arr2 = { 1, 4, 7, 11, 14, 25, 44, 47, 55, 57, 100 };
		
		int[] arr1 = { 3, 5, 7, 9, 20, 25, 30, 40, 55, 56, 57,100  };
		int[] arr2 = { 1, 4, 7, 11, 14, 25, 44, 47, 55, 57,60, 62  };

		System.out.println("Maximum sum is " + MaximumPathSum(arr1, arr2));
	}

	/** 
	 1)Here I used the logic of merge sort if/esle , where I will check 
	 * which array has smaller number then add it to its own sum and 
	 * increment that particular array(other array is no incremented). 
	 2)Now next time again check next number from teh smaller element 
	 *array(as it got incremented last time) against the same number
	 * from other array and again do the above logic.
	 3)This way I will be able to reach the intersection point and 
	 *also keep the sums form both arrays till that time.Now I can 
	 *decide which sum is bigger and then use it.**/
	public static int MaximumPathSum(int[] arr1, int[] arr2) {
		int maxsum = 0;
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;
		int arrayindex1 = 0;
		int arrayindex2 = 0;
		int arr1length = arr1.length;
		int arr2length = arr2.length;
		StringBuilder path = new StringBuilder();
		StringBuilder path1 = new StringBuilder();
		StringBuilder path2 = new StringBuilder();
		while (arrayindex1 < arr1length && arrayindex2 < arr2length) {

			if (arr1[arrayindex1] < arr2[arrayindex2]) {
				sum1 = sum1 + arr1[arrayindex1];
				path1.append(arr1[arrayindex1] + ",");
				arrayindex1++;
			} else if (arr1[arrayindex1] > arr2[arrayindex2]) {
				sum2 = sum2 + arr2[arrayindex2];
				path2.append(arr2[arrayindex2] + ",");
				arrayindex2++;
			} else {

				sum1 = sum1 + arr1[arrayindex1];
				sum2 = sum2 + arr2[arrayindex2];
				path1.append(arr1[arrayindex1] + ",");
				path2.append(arr2[arrayindex2] + ",");
				// int sum=sum1>=sum2?sum1:sum2;
				if (sum1 >= sum2) {
					sum = sum1;
					path.append(path1);
				} else {
					sum = sum2;
					path.append(path2);
				}
				maxsum = maxsum + sum;
				sum1 = 0;
				sum2 = 0;
				path1.setLength(0);
				path2.setLength(0);
				arrayindex1++;
				arrayindex2++;
			}
		}

		while (arrayindex1 < arr1length) {
			path1.append(arr1[arrayindex1] + ",");
			sum1 = sum1 + arr1[arrayindex1++];
		}
		while (arrayindex2 < arr2length) {
			path2.append(arr2[arrayindex2] + ",");
			sum2 = sum2 + arr2[arrayindex2++];
		}

		if (sum1 >= sum2) {
			sum = sum1;
			path.append(path1);
		} else {
			sum = sum2;
			path.append(path2);
		}
		maxsum = maxsum + sum;
		System.out.println(path);
		return maxsum;
	}
	
}
	/***
	public static int MaximumPathSum(int[] arr1, int[] arr2) {
		int maxsize = 0;
		// int array1=-1;
		// int array2=-1;
		int array = 0;
		// int arraycommon;
		int arr1length = arr1.length;
		int arr2length = arr2.length;
		// int[] arrayref=new arrayref[];
		if (arr1 == null || arr1length == 0 || arr2 == null || arr2length == 0) {
			return maxsize;
		} else {
			while (array < arr1length && array < arr2length) {

				if (arr1[array] >= arr2[array]) {
					maxsize = maxsize + arr1[array];
				} else if (arr1[array] < arr2[array]) {
					maxsize = maxsize + arr2[array];
				}
				array++;
			}

			while (array < arr1length) {
				maxsize = maxsize + arr1[array++];
			}
			while (array < arr2length) {
				maxsize = maxsize + arr1[array++];
			}
		}
		return maxsize;
	}

	public static int MaximumPathSum2(int[] arr1, int[] arr2) {
		int maxsum = 0;
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;
		int array1 = 0;
		int array2 = 0;
		StringBuilder path = new StringBuilder();
		StringBuilder path1 = new StringBuilder();
		StringBuilder path2 = new StringBuilder();
		int arr1length = arr1.length;
		int arr2length = arr2.length;

		while (array1 < arr1length && array2 < arr2length) {

			sum1 = sum1 + arr1[array1];
			path1.append(arr1[array1] + ",");
			sum2 = sum2 + arr2[array2];
			path2.append(arr2[array2] + ",");
			if (arr1[array1] == arr2[array2]) {
				// int sum=sum1>=sum2?sum1:sum2;
				if (sum1 >= sum2) {
					sum = sum1;
					path.append(path1);
				} else {
					sum = sum2;
					path.append(path2);
				}
				maxsum = maxsum + sum;
				sum1 = 0;
				sum2 = 0;
				path1.setLength(0);
				path2.setLength(0);
			}
			// maxsum =maxsize+ arrayref[array];
			array1++;
			array2++;
		}

		while (array1 < arr1length) {
			path1.append(arr1[array1] + ",");
			sum1 = sum1 + arr1[array1++];
		}
		while (array2 < arr2length) {
			path2.append(arr2[array2] + ",");
			sum2 = sum2 + arr2[array2++];
		}

		if (sum1 >= sum2) {
			sum = sum1;
			path.append(path1);
		} else {
			sum = sum2;
			path.append(path2);
		}

		// int sum=sum1>=sum2?sum1:sum2;
		maxsum = maxsum + sum;
		System.out.println(path);
		return maxsum;
	}


}****/
