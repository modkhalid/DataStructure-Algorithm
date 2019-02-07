package basic_crux;

import java.util.Scanner;

public class CheckPrime {
	public static boolean checkPrime(int n) {
		boolean flag=false;
		for (int i = 2; i <= n/2; i++) {
			if(n%i==0) {
				flag=false;
				return flag;
			}
				
		}
		return true;
	}
	
	public static int fabonacci(int n) {
		if(n==1)
			return 1;
		if(n==0)
			return 0;
		return fabonacci(n-1)+fabonacci(n-2);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		System.out.println(checkPrime(sc.nextInt())?"Prime":"no");
		System.out.println(fabonacci(sc.nextInt()));
		
	}
}
