package recursion;

public class April11 {
	static String spelling[] = {   "ZERO", "ONE", "TWO","THREE", 
							"FOUR", "FIIVE", "SIX",
							"SEVEN", "EIGHT", "NINE" };

	public static void TOH(int n, char a, char b, char c) {
		if (n > 0) {
			TOH(n - 1, a, c, b);
			System.out.println("Move " + a + " to " + c);
			TOH(n - 1, b, a, c);
		}
	}

	public static boolean issorted(int arr[], int index) {
		if (index == 0) {
			return true;
		}
		if (arr.length == 1)
			return true;
		return arr[index] < arr[index - 1] ? false : issorted(arr, index - 1);
	}

//	optimize power

	public static int powerLogN(int a, int b) {
		if (b == 0)
			return 1;
		int ans = powerLogN(a, b / 2);
		ans *= ans;
		if (b % 2 == 1)
			return a * ans;
		return ans;
	}

	public static void IncDec(int n) {
		if (n == 0) {
			System.out.println();
			return;
		}
		System.out.print(n + " ");
		IncDec(n - 1);
		System.out.print(n + " ");

	}

	public static int mult(int a, int b, boolean flag) {
		if (b == 0)
			return 0;
		int ans = Math.abs(a) + mult(a, Math.abs(b) - 1, false);

		if (flag) {
			int num1 = 1, num2 = 1;
			if (a < 0)
				num1 = -1;
			if (b < 0)
				num2 = -1;
			return ans * num1 * num2;
		}

		return ans;

	}

	public static int getInt(String str, int count) {
		if (str.length() == 0)
			return 0;
		int ch = Character.getNumericValue(str.charAt(0));
		return (int) Math.pow(10, count) * ch + getInt(str.substring(1), count - 1);

	}

	public static int Bricks4N(int n) {
		if (n == 4)
			return 2;
		if (n < 4)
			return 1;
		return Bricks4N(n - 1) + Bricks4N(n - 4);
	}

	public static void F2048(int n) {
		if(n==0)
			return ;
		F2048(n/10);
		System.out.print(spelling[n%10]+" ");
	}
	
	public static int linearSearch(int arr[],int item,int vind) {
		if(vind>=arr.length)
			return -1;
		if(arr[vind]==item)
			return vind;
		return linearSearch(arr, item, vind+1);
	}
	
	public static void main(String[] args) {
//		TOH(64, 'A', 'B', 'C');
		int arr[]= {1,4,5,6,78,98};
//		System.out.println(issorted(arr, arr.length-1));
//		System.out.println(powerLogN(2, 9));
//		IncDec(5);
//		System.out.println(mult(-5, -3, true));
//		String str="123456";
//		int a=Integer.parseInt(str);
//		System.out.println(a);
//		System.out.println(getInt(str, str.length()-1));
//		System.out.println(Bricks4N(9));
//		F2048(2048);
		System.out.println(linearSearch(arr, 78, 0));
	}
}
