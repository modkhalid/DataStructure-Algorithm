package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class April15 {
	public static boolean isPal(int arr[], int si, int ei) {
		if (si >= ei)
			return true;
		return arr[si] == arr[ei] && isPal(arr, si + 1, ei - 1);
	}

	public static void ReverseArray(int arr[], int si, int ei) {
		if (si >= ei)
			return;
		int temp = arr[si];
		arr[si] = arr[ei];
		arr[ei] = temp;
		ReverseArray(arr, si + 1, ei - 1);
	}

	public static void main(String[] args) {

//			Scanner sc=new Scanner(System.in);
//			int n,q;
//			n=sc.nextInt();
//			q=sc.nextInt();
//			long a[]=new long[n];
//			long b[]=new long[n];
//			
//			for(int i=0;i<n;i++)
//			    a[i]=sc.nextLong();
//			    
//			for(int i=0;i<n;i++)
//			    b[i]=sc.nextLong();
//			 
//			String ans="";
//			for(int i=0;i<q;i++){
//			    int l=sc.nextInt();
//			    int r=sc.nextInt();
//			    
////			    System.out.println(find(a,b,l,r));
//			    ans+=String.valueOf(find(a,b,l-1,r-1))+"\n";
//			}
//			System.out.println(ans);
//			System.out.println(MoveXEnd("abxxxcxzdxuyo"));
//			System.out.println(CountRemoveReplaceHi("this is khalidhi"));
//			System.out.println(twins("AXAXA"));
//		s();
		System.out.println(CodesOfString("1125"));
	}

	public static String MoveXEnd(String str) {
		if (str.length() == 1)
			return str;
		char ch = str.charAt(0);
		String ans = MoveXEnd(str.substring(1));
		return ch == 'x' ? ans + ch : ch + ans;
	}

	public static long find(long a[], long b[], int l, int r) {
		long sum = 0;
		for (int i = l; i <= r; i++)
			sum += a[i] * b[i];
		return sum;
	}

	public static ArrayList<String> CodesOfString(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		ArrayList<String> mr = new ArrayList<String>();
		
		
		char c=(char)( Integer.parseInt(str.substring(0,1))+96);
		System.out.println(c);
		ArrayList<String> rr=CodesOfString(str.substring(1));
		for (String rrr : rr) {
			mr.add(c + rrr);
		}
		
		
		if (str.length() >= 2) {
			char ch = (char) (Integer.parseInt(str.substring(0, 2)) + 97);
			rr = CodesOfString(str.substring(2));
			for (String rrr : rr) {
				mr.add(ch + rrr);
			}
		}

		return mr;
	}

	public static void s() {
		char c = (char) 97;
		System.out.println(c);
	}

	public static int CountRemoveReplaceHi(String str) {
		if (str.length() == 0 || str.length() == 1)
			return 0;
		if (str.substring(0, 2).equals("hi")) {
			return 1 + CountRemoveReplaceHi(str.substring(2));
		} else {
			return CountRemoveReplaceHi(str.substring(1));
		}
	}

	public static int twins(String str) {
		if (str.length() == 2) {
			return 0;
		}
		char ch = str.charAt(0);
		if (ch == str.charAt(2)) {
			return 1 + twins(str.substring(1));
		}

		return twins(str.substring(1));
	}
}

//	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		int n=sc.nextInt();
//		int arr[]=new int [n];
//		for(int i=0;i<n;i++)
//			arr[i]=sc.nextInt();
////		System.out.println(isPal(arr, 0, n-1));
//		ReverseArray(arr, 0, arr.length-1);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]+" ");
//		}
//	}
