package LongestCommonSequence;

public class LongestCommonSubstring {
	//static StringBuilder sbuilder = new StringBuilder();
		//static char current;
		//static int count = 1;

		public static void main(String[] args) {

			 char X[] = "ggggggGeeksforGeeksdddgee".toCharArray();
			 char Y[] = "GeeksQuiz".toCharArray();

			//char X[] = "abcrfghwetf".toCharArray();
			//char Y[] = "abrfghwwetxyab".toCharArray();

			// char X[] = "xyayz".toCharArray();
			// char Y[] = "axyza".toCharArray();

			int m = X.length;
			int n = Y.length;
			int[] result;

			result = lcs(X, Y, m, n);
			int length=result[0];
			System.out.println("Length of LCS is " + length);
			int index=result[1];
            for(int i=(index-length+1);i<=index;i++) {
            	System.out.print(X[i]);
            }
			//System.out.println("List of LCS");
		//	printlcs(L, X, Y, m, n);
			//System.out.println("");
			//System.out.println("List of LCS");
		//	printlcs_method2(L, X, Y, m, n);
			// return 0;

		}

	
		static int max(int a, int b) {
			return (a > b) ? a : b;
		}

		/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
		static int[] lcs(char[] X, char[] Y, int m, int n) {
			int[][] L = new int[m + 1][n + 1];
			int i, j;
            int length=0;
            int index=0;
            int[] resultholder= {0,0};
		
			for (i = 0; i <= m; i++) {
				for (j = 0; j <= n; j++) {
					if (i == 0 || j == 0) {
						L[i][j] = 0;

					} else if (X[i - 1] == Y[j - 1]) {
						L[i][j] = L[i - 1][j - 1] + 1;
						//length=max(length,L[i][j]);
						if(L[i][j]>length) {
						index=i-1;
						length=L[i][j];
						}
					} else {
						L[i][j] =0;
					}

				}
			}
			resultholder[0]=length;
			resultholder[1]=index;		
			return resultholder;
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
					i--;l++;
				} else if (L[i][j] > L[i][j - 1]) {
					lcs[l] = Y[j - 1];
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
