package recursion;

public class April12 {
	public void PDI(int n) {
		if(n<=0) {
			System.out.println(n);
			return;
		}
		System.out.println(n);
		PDI(n-5);
		System.out.println(n);
	}
	
	public void OddEvenPDI(int n) {
		if(n==0)
			return;
		if(n%2==1)
			System.out.println(n);
		OddEvenPDI(n-1);
		if(n%2==0)
			System.out.println(n);
	}
	
	
	
	public static void main(String[] args) {
		April12 a=new April12();
//		a.PDI(16);
		a.OddEvenPDI(9);
	}
}
