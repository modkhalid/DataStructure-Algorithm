package DynamicProgramming;

import java.util.Arrays;

class All {
	static int mam[] = new int[1000];
	static int mamo[][] = new int[1000][1000];

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
	
	public static int vines(int arr[],int count,int be,int en) {
		if(be>en) {
			return 0;
		}
		if(mamo[be][en]!=-1) {
			return mamo[be][en];
		}
		int	ans1=count*arr[en]+vines(arr, count+1, be, en-1);
		int ans2= count*arr[be]+vines(arr, count+1, be+1, en);
		mamo[be][en]=Math.max(ans1, ans2);
		return mamo[be][en];
	}
	
//	public static boolean isSorted(int arr[],int n) {
//		if(n==1)
//			return true;
//		if(a[0]<arr[1] && isSorted(arr+1, n-1))
//			return true;
//	}
}

public class Nto1 {

	public static void main(String[] args) {
		Arrays.fill(All.mam, -1);
		for (int a[]:All.mamo) {
			Arrays.fill(a, -1);
		}
//		System.out.println(All.NoOfWays(10));
		int arr[]= {2,3,5,1,4};
		System.out.println(All.vines(arr, 1,0,arr.length-1));
	}
}
