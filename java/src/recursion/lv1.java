package recursion;

public class lv1 {
	static void fun(int x) {
		if(x<1)
			return;
		fun(--x);
		System.out.println(x);
		fun(--x);
	}
	public  static int max(int arr[],int n) {
		if(n==1)
			return arr[0];
		
		int x=max(arr,n-1);
		if(x>arr[n-1])
			return x;
		return arr[n-1];
	}
	public static void main(String[] args) {
//		fun(3);
		int arr[]= {1,2,3,4,5,6};
		System.out.println(max(arr,6));
	}
}
