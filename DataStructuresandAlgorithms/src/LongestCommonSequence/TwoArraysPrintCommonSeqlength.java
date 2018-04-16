package LongestCommonSequence;

public class TwoArraysPrintCommonSeqlength {
	//static StringBuilder sbuilder = new StringBuilder();
	//static char current;
	//static int count = 1;

	public static void main(String[] args) {

		 char X[] = "AGGTAB".toCharArray();
		 char Y[] = "GXTXAYB".toCharArray();

		//char X[] = "abcrfghwetf".toCharArray();
		//char Y[] = "abrfghwwetxyab".toCharArray();

		// char X[] = "xyayz".toCharArray();
		// char Y[] = "axyza".toCharArray();

		int m = X.length;
		int n = Y.length;
		int[][] L;

		L = lcs(X, Y, m, n);
		System.out.println("Length of LCS is \n" + L[m][n]);
		System.out.println("List of LCS");
		printlcs(L, X, Y, m, n);
		System.out.println("");
		System.out.println("List of LCS");
		printlcs_method2(L, X, Y, m, n);
		// return 0;

	}

	// McCreight's Algorithm.check this algorithm
	/* Utility function to get max of 2 integers */
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static int[][] lcs(char[] X, char[] Y, int m, int n) {
		int[][] L = new int[m + 1][n + 1];
		int i, j;

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that
		 * L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (i = 0; i <= m; i++) {
			for (j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;

				} else if (X[i - 1] == Y[j - 1]) {
					L[i][j] = L[i - 1][j - 1] + 1;

					/////// //if(L[i-1][j-1]>0 && L[i][j]>count){
					// if( L[i][j]>count){
					// sbuilder.append(current) ;
					// count = L[i][j];

					// }
					// current=X[i-1];
				} else {
					L[i][j] = max(L[i - 1][j], L[i][j - 1]);
				}

			}
		}
		// sbuilder.append(current);
		return L;
		/* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
		// System.out.println("Length of LCS is \n"+ L[m][n]);
		// System.out.println("LCS is " +sbuilder.toString());
	}

	static void printlcs(int[][] L, char[] X, char[] Y, int m, int n) {
		int i = m;
		int j = n;
		int l = 0;
		int index = Math.min(i, j);
		char[] lcs = new char[index + 1];
		while (i > 0 && j > 0) {
			if (L[i][j] == L[i - 1][j]) {
				i--;
			} else if (L[i][j] == L[i][j - 1]) {
				j--;
			} else if (L[i][j] > L[i - 1][j]) {
				lcs[l] = X[i - 1];
				//System.out.println("" + X[i - 1]);
				i--;l++;
			} else if (L[i][j] > L[i][j - 1]) {
				lcs[l] = Y[j - 1];
				//System.out.println("" + Y[j - 1]);
				j--;l++;
			}

		}
		for (int k = l-1; k >= 0; k--) {

			System.out.print(lcs[k]);

		}

	}

	static void printlcs_method2(int[][] L, char[] X, char[] Y, int m, int n) {
		int i = m;
		int j = n;
		int l = 0;

		int index = Math.min(i, j);
		// int index2=index;
		char[] lcs = new char[index + 1];
		while (i > 0 && j > 0) {
			if (X[i - 1] == Y[j - 1]) {
				lcs[l] = X[i - 1];
				i--;
				j--;
				l++;
			} else if (L[i - 1][j] > L[i][j - 1]) {
				i--;
			} else {
				j--;
			}

		}
		for (int k = l-1; k >= 0; k--) {

			System.out.print(lcs[k]);

		}

	}

}