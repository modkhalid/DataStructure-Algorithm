package recursion;

public class lv1 {
	static void fun(int x) {
		if(x<1)
			return;
		fun(--x);
		System.out.println(x);
		fun(--x);
	}
	static int mult (int a,int b) {
		if(b==0)
			return 0;
		if(b%2==1)
			return mult(2*a,b/2)+a;
		return mult(2*a,b/2);
	}
	
	static int power(int a,int b) {
		if(b==0) {
			return 1;
		}
		if(b%2==0) {
			return power(2*a,b/2);
		}
		return power(2*a,b/2)*a;
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
//		int arr[]= {1,2,3,4,5,6};
//		System.out.println(max(arr,6));
//		System.out.println(mult(4, 5));
		System.out.println(power(2,3));
	}
}
