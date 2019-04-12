package recursion;

/*
 * all about the recursion
 * April 11,12
 */

public class April11 {
	static String spelling[] = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };

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
		if (n == 0)
			return;
		F2048(n / 10);
		System.out.print(spelling[n % 10] + " ");
	}

	public static int linearSearch(int arr[], int item, int vind) {
		if (vind >= arr.length)
			return -1;
		if (arr[vind] == item)
			return vind;
		return linearSearch(arr, item, vind + 1);
	}

	public static int BinarySearch(int arr[], int item, int low, int high) {
		if (low > high) {
			return -1;
		}
		int r = low + (-low + high) / 2;
		if (arr[r] == item)
			return r;
		if (arr[r] > item)
			return BinarySearch(arr, item, low, r - 1);
		return BinarySearch(arr, item, r + 1, high);
	}

	public static void swap(int a, int b) {
		int t = a;
		a = b;
		b = t;
	}

	public static void BubbleSort(int arr[], int n) {
		if (n == 1)
			return;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int t = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = t;
			}
		}
		BubbleSort(arr, n - 1);
	}

	public static void bubbleSort2(int arr[], int j, int n) {
		if (n == 1)
			return;
		if (j == n - 1) {
			bubbleSort2(arr, 0, n - 1);
			return;
		}
		if (arr[j] > arr[j + 1]) {
			int t = arr[j];
			arr[j] = arr[j + 1];
			arr[j + 1] = t;
		}
		bubbleSort2(arr, j + 1, n);
		return;
	}

	public static void mergeSort(int arr[], int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}

	}
	
	public static void quickSort(int arr[],int low,int high) {
		if(low>high)
			return;
		int pi=partition(arr,low,high);
		quickSort(arr, low, pi-1);
		quickSort(arr, pi+1, high);
	}

	private static int partition(int[] arr, int low, int high) {
		int pivat=arr[high];
		int j=low;
		for (int i = low; i < high; i++) {
			if(arr[i]<pivat) {
//				j++;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				j++;
				
			}	
		}
		
		int temp=arr[j];
		arr[j]=pivat;
		arr[high]=temp;
		return j;
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int larr[] = new int[mid - low + 1];
		int rarr[] = new int[high - mid];

		for (int i = 0; i < larr.length; i++) {
			larr[i] = arr[low + i];
		}
		for (int i = 0; i < rarr.length; i++) {
			
			rarr[i] = arr[mid + i + 1];
		}

		int lh = larr.length;
		int rh = rarr.length;
		int j = 0, k = 0, i = low;

		while (j < lh && k < rh) {
			if (larr[j] < rarr[k]) {
				arr[i] = larr[j];
				j++;
			} else {
				arr[i] = rarr[k];
				k++;
			}
			i++;
		}

		while (j < lh) {
			arr[i] = larr[j];
			j++;
			i++;
		}

		while (k < rh) {
			arr[i] = rarr[k];
			k++;
			i++;
		}

	}

	public static void main(String[] args) {
//		TOH(64, 'A', 'B', 'C');
		int arr[] = { 1, 4, 6, 785, 5, 6, 78, 98 };
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
//		System.out.println(linearSearch(arr, 78, 0));
//		System.out.println(BinarySearch(arr, 9878, 0, arr.length-1));
//		bubbleSort2(arr, 0, arr.length);
//		mergeSort(arr, 0, arr.length - 1);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println("\n\n");
		
		quickSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
