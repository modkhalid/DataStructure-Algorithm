package DynamicProgramming;

import java.util.Arrays;

class All {
	static int mam[] = new int[1000];

	public static int NoOfWays(int n) {

		if (n == 1)
			return 0;
		if (mam[n] != -1)
			return mam[n];
		int ans1=Integer.MAX_VALUE, ans2=Integer.MAX_VALUE, ans3=Integer.MAX_VALUE, ans = 0;
		if (n % 3 == 0)
			ans1 = 1 + NoOfWays(n / 3);
		if (n % 2 == 0)
			ans2 = 1 + NoOfWays(n / 2);
		ans3 = 1 + NoOfWays(n - 1);
		
		ans = Math.min(ans1, Math.min(ans2, ans3));
		mam[n] = ans;
		return ans;
	}
}

public class Nto1 {

	public static void main(String[] args) {
		Arrays.fill(All.mam, -1);
		System.out.println(All.NoOfWays(10));
	}
}
