package code_chief;

import java.util.Scanner;

public class FoodProblem {
	static int neg = Integer.MIN_VALUE;

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String ans = "";
		while (t > 0) {
			ans += fun(sc.nextInt(), sc) + "\n";
			t--;
		}
		System.out.print(ans);

	}

	public static int fun(int n, Scanner sc) {
		int sum = 0;
		int A[] = new int[n];
		int B[] = new int[n];
//		int C[] = new int[n];
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			A[i] = t + sum;
			sum += t;
		}
		int res1 = sum;
		int res2 = neg;
		sum = 0;
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			sum += t;
			B[i] = sum;

			if (res2 < A[i] - sum)
				res2 = A[i] - sum;
		}
		res2 += sum;
		return Math.max(res1, Math.max(res2, sum));
	}
}
