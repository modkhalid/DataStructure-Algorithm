package L2_basic1;

import java.util.ArrayList;

public class L3Array {
	public static void main(String[] args) {
//		byte b=(byte)257;
//		System.out.println(b);
		int arr[] = { 1, 2, 4, 5, 6, 7, 8, 9 };
		int sarr[] = {3, 4, 5, 7, 9, 11 };
//		System.out.println(Intersection(arr, sarr));
//		System.out.println(sum(arr, sarr));
//		System.out.println();
//		printpallindrone("nitin");
//		StringBuilder sb=new StringBuilder();
//		sb.append("modkhalid");
//		System.out.println(sb);
//		char str[]= {'h','a','r'};
//		sb.append(str);
//		System.out.println(sb);
//		sb.insert(3, "mod");
//		System.out.println(sb);
//		sb.deleteCharAt(3);
//		System.out.println(sb);
		System.out.println(power(1,0));
//		sb.re
		
	}

	public static ArrayList<Integer> Intersection(int arr[], int sarr[]) {

		int i = 0, j = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		while (i < arr.length && j < sarr.length) {
			if (arr[i] < sarr[j]) {
				i++;
			} else if (arr[i] > sarr[j]) {
				j++;
			} else {
				ans.add(arr[i]);
				i++;
				j++;
			}
		}

		return ans;

//		return null;
	}

	public static ArrayList<Integer> sum(int arr[], int sarr[]) {
		ArrayList<Integer> ans = new ArrayList<>();
		int i = arr.length - 1;
		int j = sarr.length - 1;
		int sum, carry = 0;
		while (i >= 0 || j >= 0) {
			if(i<0) {
				sum=sarr[j]+carry;
			}else if(j<0) {
				sum=arr[i]+carry;
			}else {
				sum=arr[i]+sarr[j]+carry;
			}
			
			ans.add(0, sum%10);
			carry=sum/10;
			i--;
			j--;
			
		}

		return ans;
	}
	
	public static boolean isPalindrone(String str) {
		int left=0;
		int right=str.length()-1;
		while(left<right) {
			if(str.charAt(left)!=str.charAt(right)) {
				return false;
			}	
			left++;
			right--;
		}
		return true;
	}
	
	public static void printpallindrone(String str) {
		for (int i = 0; i < str.length();i++) {
			for (int j = i+1; j <= str.length(); j++) {
				String ss=str.substring(i, j);
				if(isPalindrone(ss))
					System.out.println(ss);
			}
		}
	}
	
	
	public static long power(int a,int b){
		if(b==0)
			return 1;
		return a*power(a,b-1);
	}
}



