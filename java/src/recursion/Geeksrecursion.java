package recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//import com.sun.tools.javac.code.Attribute.Array;

//import com.sun.tools.javac.code.Attribute.Array;

//import com.sun.tools.javac.code.Attribute.Array;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

class Recursion{
	
	
	public int fact(int n) {
		if(n==1)
			return 1;
		return n*fact(n-1);
		
	}
	
	public int josephus(int n,int k) {
		if(n==1)
			return 0;
		return (josephus(n-1,k)+k)%n;
	}
	
	public int evenFind(int n,int count) {
		if(n==1) {
			return count;
		}
		return evenFind(n/2,count+1);
	}
	
	
	public void pattern(int n) {
		int count=n;
		do {
			System.out.print(n+" ");
			n=n-5;
		}while(n>0);

		System.out.print(n+" ");
		n=n+5;

		while(n<=count) {
			System.out.print(n+" ");
			n=n+5;
		}
	}
	
	
	void printer(int n,int c,boolean flag) {
		if(n<=0) {
			System.out.print(n+" ");
			return;
		}
		if(n>c)
			return;
		
		if(flag) {
			System.out.print(n+" ");
			printer(n-5, c,true);
			System.out.print(n+" ");
//			printer(n+5, c,false);
		}
	}
	
	boolean isHappy(int n) {
		int sum=0;
		
//		int counter=0;
		while(n!=0) {
			sum+=(int)Math.pow(n%10, 2);
			n/=10;
		}
		if(sum==1)
			return true;
		if(sum<10)
			return false;
		return isHappy(sum);
	}
	
	public static int path(int sr,int sc,int ec,int er) {
		if(sr==er-1 && sc==ec-1) {
			return 1;
		}
		if(sr>er || sc>ec) {
			return 0;
		}
		
		int ans=0;
		ans+=path(sr+1, sc, ec, er);
		ans+=path(sr, sc+1, ec, er);
		
		return ans;
	}
	
	public static int powerGame(int x,int n,int c,int sum) {
		if(sum==x)
			return 1;
		if(c>Math.pow(x, 1/(float)n) || sum>x)
			return 0;
//		System.out.println();
		int ans=0;
		ans+=powerGame(x, n, c+1, sum+(int)Math.pow(c, n));
		ans+=powerGame(x, n, c+1, sum);
		return ans;
		
	}
	
	public static long[] input() {
		long arr[]=new long[10];
//		Arrays.fill(arr, -1);
		long put=0;
		int counter=1;
		
		for (int i = 0; i < arr.length; i++) {
			long sum=1;
			int s=counter;
			for(int j=0;j<=i;j++) {
				sum*=s;
				s++;
			}
			arr[i]=sum+put;
			put+=sum;
//			System.out.println(sum+" , "+i);
			counter=s;
		}
		
		return arr;
		
		
	}
	
	public void stack(int arr[]) {
		Arrays.sort(arr);
		
		for (int i = arr.length-1; i>=0; i--) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}



public class Geeksrecursion {
	public static void main(String[] args) {
		
		Recursion r=new Recursion();
		long arr[]=r.input();
//		System.out.println(r.fact(5));
//		System.out.println(r.josephus(3, 2));
//		System.out.println((int)Math.pow(2, r.evenFind(6, 0)));
//		r.pattern(16);
//		r.printer(10,10,true);
		
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0) {
			
			int n=sc.nextInt();
			System.out.println(arr[n-1]);
//			int arr[]=new int[n];
//			for (int i = 0; i < arr.length; i++) {
//				arr[i]=sc.nextInt();
//			}
//			r.stack(arr);
			t--;
		}
//		System.out.println(r.isHappy(0));
//		System.out.println(r.path(0, 0, 2, 8));
//		System.out.println(r.powerGame(10, 2, 1, 0));
//		int arr[]={1,8,9,6,3,2,1};
//		r.stack(arr);
//		long arr[]=r.input();
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
	}
	
	
	
	
	
}
