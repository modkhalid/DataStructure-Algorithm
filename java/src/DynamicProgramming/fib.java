package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class fib {
	static int mam[] = new int[10000];

	public static int fibo(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (mam[n] != -1)
			return mam[n];
		int ans = fibo(n - 1) + fibo(n - 2);
		mam[n] = ans;
		return ans;
	}

	public static void main(String[] args) {
		Arrays.fill(mam, -1);
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0) {
			int n=sc.nextInt();
			System.out.println(fibo(n));
			
			t--;
		}

	}
}
