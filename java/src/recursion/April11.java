package recursion;

public class April11 {
	public static void TOH(int n,char a,char b,char c) {
		if(n>0) {
			TOH(n-1, a, c, b);
			System.out.println("Move "+a+" to "+c);
			TOH(n-1, b, a, c);
		}
	}
	
	public static boolean issorted(int arr[],int index) {
		if(index==0) {
			return true;
		}
		if(arr.length==1) 
			return true;
		return arr[index]<arr[index-1]?false:issorted(arr, index-1);
	}
	
	
//	optimize power
	
	public static int powerLogN(int a,int b) {
		if(b==0)
			return 1;
		int ans=powerLogN(a, b/2);
		ans*=ans;
		if(b%2==1)
			return a*ans;
		return ans;
	}
	
	public static void IncDec(int n) {
		if(n<0) {
			System.out.println();
			return;
		}
		System.out.print(n+" ");
		IncDec(n-1);
		System.out.print(n+" ");
		
	}
	public static void main(String[] args) {
//		TOH(64, 'A', 'B', 'C');
//		int arr[]= {1,4,5,6,78,98};
//		System.out.println(issorted(arr, arr.length-1));
//		System.out.println(powerLogN(2, 9));
		IncDec(5);
	}
}
