package recursion;

import java.util.ArrayList;

public class April12 {
	public static String getCode(char ch) {
		if(ch=='1') 
			return "abc";
		else if(ch=='2') 
			return "def";
		else if(ch=='3') 
			return "ghi";
		else if(ch=='4') 
			return "jkl";
		else if(ch=='5') 
			return "mno";
		else if(ch=='6') 
			return "pqr";
		else if(ch=='7') 
			return "stu";
		else if(ch=='8') 
			return "vwx";
		else if(ch=='9') 
			return "yz";
		else if(ch=='0') 
			return "@#";
		else 
			return "";
	}

	public void PDI(int n) {
		if (n <= 0) {
			System.out.println(n);
			return;
		}
		System.out.println(n);
		PDI(n - 5);
		System.out.println(n);
	}

	public void OddEvenPDI(int n) {
		if (n == 0)
			return;
		if (n % 2 == 1)
			System.out.println(n);
		OddEvenPDI(n - 1);
		if (n % 2 == 0)
			System.out.println(n);
	}

	public void displayReverse(int arr[], int vi) {
		if (vi == arr.length)
			return;
		displayReverse(arr, vi + 1);
		System.out.print(arr[vi] + " ");
	}

	public int maxOfArray(int arr[], int vi) {
		if (vi == arr.length)
			return Integer.MIN_VALUE;
		return Math.max(arr[vi], this.maxOfArray(arr, vi + 1));
	}

	public boolean find(int arr[], int vi, int item) {
		if (vi == arr.length)
			return false;
		return arr[vi] == item || this.find(arr, vi + 1, item);
	}

	/*
	 * 
	 * sorting again
	 * 
	 */

	public void bubbleSort(int arr[], int i, int n) {
		if (n == 1)
			return;
		if (i == n - 1) {
			bubbleSort(arr, 0, n - 1);
			return;
		}

		if (arr[i] > arr[i + 1]) {
			int t = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = t;
		}

		bubbleSort(arr, i + 1, n);
	}

	private void merge(int arr[], int l, int m, int h) {
		int n1 = m - l + 1;
		int n2 = h - m;
		int la[] = new int[n1];
		int ra[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			la[i] = arr[i + l];
		}
		for (int i = 0; i < n2; i++) {
			ra[i] = arr[i + m + 1];
		}

		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (la[i] < ra[j]) {
				arr[k] = la[i];
				i++;
			} else {
				arr[k] = ra[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = la[i];
			i++;
			k++;
		}

		while (j < n2) {

			arr[k] = ra[j];
			j++;
			k++;
		}
	}

	public void mergeSort(int arr[], int l, int h) {
		if (l < h) {
			int mid = l + (h - l) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, h);
			merge(arr, l, mid, h);
		}
	}

	public void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int pi = this.partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);

		}
	}

	public void printSeq(String str,String ans) {
		if(str.length()==0) {
			System.out.print(ans+" ");
			return;
		}
		
		
		this.printSeq(str.substring(1), ans);
		this.printSeq(str.substring(1), ans+str.charAt(0));
	}
	
	public int partition(int arr[], int low, int high) {
		int pivat = arr[high];
		int j = low - 1;
		int i = low;
		while (i < high) {
			if (arr[i] < pivat) {
				++j;
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
			i++;
		}
		++j;
		arr[high] = arr[j];
		arr[j] = pivat;
		return j;
	}

	public ArrayList<String> ss(String str){
		if(str.length()==0)
		{
			ArrayList<String> br=new ArrayList<String>();
			br.add("");
			return br;
		}
		
		ArrayList<String> mr=new ArrayList<>();
		ArrayList<String> rr=this.ss(str.substring(1));
		for(String s:rr) {
			mr.add(s);
			mr.add(str.charAt(0)+s);
		}
		return mr;
		
	}
	
	public ArrayList<String> keypad(String str){
		if(str.length()==0) {
			ArrayList<String> br=new ArrayList<String>();
			br.add("");
			return br;
		}
		ArrayList<String> mr=new ArrayList<String>();
		ArrayList<String> rr=keypad(str.substring(1));
		String s=getCode(str.charAt(0));
		for(int i=0;i<s.length();i++) {
			for(String ss:rr) {
				mr.add(s.charAt(i)+ss);
			}
		}
		return mr;
	}
	public ArrayList<String> permutation(String str){
		if(str.length()==0) {
			ArrayList<String> br=new ArrayList<String>();
			br.add("");
			return br;
		}
		
		ArrayList<String> mr=new ArrayList<String>();
		ArrayList<String> rr=permutation(str.substring(1));
		char ch=str.charAt(0);
		for(String s:rr) {
			for (int i = 0; i <= s.length(); i++) {
				mr.add(s.substring(0, i)+ch+s.substring(i));
			}
		}
		return mr;
	}
	
	public static void main(String[] args) {
		April12 a = new April12();
//		a.PDI(16);
//		a.OddEvenPDI(9);
		int[] arr = { 50, 40, 80, 90, 70, 10, 30, 60, 20 };
//		a.displayReverse(arr, 0);
//		System.out.println(a.maxOfArray(arr, 0));
//		System.out.println(a.find(arr, 0, 202));
//		a.bubbleSort(arr, 0, arr.length);
//		a.mergeSort(arr, 0, arr.length - 1);
//		a.quickSort(arr, 0, arr.length - 1);
//		for (int ar : arr) {
//			System.out.print(ar + " ");
//		}
//		a.printSeq("abc", "");
//		System.out.println(a.ss("abc"));
//		System.out.println(a.keypad("431"));
		System.out.println(a.permutation("abc"));
	}
}
