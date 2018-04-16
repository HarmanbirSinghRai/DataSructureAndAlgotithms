package Recursion.Harmancode;

import java.util.Scanner;

public class knapSack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of items: ");
		int n = sc.nextInt();
		int[] wt = new int[n + 1];
		int[] val = new int[n + 1];

		int i = 0;
		while (i <=n) {
			if (i == 0) {
				wt[i] = 0;
				val[i] = 0;
				i++;
			} else {
				System.out.println("Enter the value of item: ");
				val[i] = sc.nextInt();
				System.out.println("Enter the weight of item: ");
				wt[i] = sc.nextInt();
				i++;
			}
		}

		System.out.println("Enter the maximum capacity: ");
		int W = sc.nextInt();

		System.out.println("The maximum value that can be put in a knapsack of capacity W is: " + kpsack(n, val, wt, W));
	}

	public static int kpsack(int n, int[] val, int[] wt, int W) {

		int i, w = 0;
		int k[][] = new int[n + 1][W + 1];

		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {

				if (i == 0 || w == 0) {
					k[i][w] = 0;

				} else if (wt[i] <= w) {
					k[i][w] = max(val[i] + k[i - 1][w - wt[i]], k[i - 1][w]);
				} else {
					k[i][w] = k[i - 1][w];
				}
			}
		}
		return k[n][W];
	}

	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
