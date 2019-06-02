package recursion;

import java.util.Scanner;

public class April17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		String ans="";
		while(t>0) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			int arr[]=new int[n];
			int sum=0;
			for (int i = 0; i < arr.length; i++) {
				arr[i]=sc.nextInt();		
				sum+=arr[i];
			}
//			System.out.println(coinSister(arr, 0, sum, m, 0)?"1":"0");
			ans+=coinSister(arr, 0, sum, m, 0)?"1\n":"0\n";
			
			t--;
		}
//		fun(3, 0, 0, "");
//		PermSpace("ABC", "");
		System.out.println(ans);
	}
	
	
	public static boolean coinSister(int arr[],int vi,int n,int m,int count) {
		if(n==m && count==1)
			return true;
		
		if(vi==arr.length) {
			
			if(n==m) {
				return true;
				
			}
			return false;
		}
		boolean flag=false;
		flag=coinSister(arr, vi+1, n-arr[vi], m+arr[vi],1);
		if(flag)
			return flag;
		flag=coinSister(arr, vi+1, n, m,1);

		return flag;
	}

	public static void fun(int n, int z, int o, String ans) {
		if (z + o == n) {
			if (o > z)
				System.out.println(ans);
			if (o == z && ans.lastIndexOf('0') != -1)
				System.out.println(ans);
			return;
		}

		if (z + o == n - 1) {
			fun(n, z, o + 1, ans + "1");
			fun(n, z + 1, o, ans + "0");
			return;
		}

		fun(n, z, o + 1, ans + "1");
		if (o > z)
			fun(n, z + 1, o, ans + "0");
	}

	private static void WordBreak(String[] dic, String str, String ans) {
		if (str.length() == 0) {
			System.out.println("(" + ans.substring(1) + ")");
			return;
		}
		char ch = str.charAt(0);
		for (int i = 0; i < dic.length; i++) {
			if (dic[i].startsWith(ch + "")) {
//				System.out.println(dic[i]);
				int l = dic[i].length();
				if (str.length() >= l && dic[i].equals(str.substring(0, l))) {
					WordBreak(dic, str.substring(l), ans + " " + dic[i]);
				}
			}
		}
//		WordBreak(dic, str.substring(1), ans);

	}

	public static void PermSpace(String str, String ans) {
		if (str.length() == 1) {
			System.out.println("(" + ans + str + ")");
			return;
		}
		char ch = str.charAt(0);
		PermSpace(str.substring(1), ans + ch + " ");
		PermSpace(str.substring(1), ans + ch);

	}

//	public static specialKeyboard(int n) {
//		if(n<=6)
//			return n;	
//		
//		return Math.min(a, b)
//		
//	}

	public static int fun(int n) {
		if (n == 2)
			return 1;
		if (n % 2 == 1 || n == 0)
			return 0;

		
		int ans = 0;
//		ans+=2*fun(n-2);
		int j=2;
		for (; j <= n / 2 ; j += 2) {
			if (j == 2)
				ans += 2 * fun(n - 2);
			else
				ans += 2 * (fun(n - j) * (fun(j-2)));
		}
		
		if(n/2%2==1)
			ans += fun(n - j) * (fun(j-2));

		
//			ans--;

		return ans;
	}
}
