package recursion;

public class April12 {
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

	public void quickSort(int arr[],int low,int high) {
		if(low<high) {
			int pi=this.partition(arr, low, high);
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
			
		}
	}
	
	public int partition(int arr[],int low,int high) {
		int pivat=arr[high];
		int j=low-1;
		int i=low;
		while(i<high) {
			if(arr[i]<pivat) {
				++j;
				int t=arr[i];
				arr[i]=arr[j];
				arr[j]=t;
			}
			i++;
		}
		++j;
		arr[high]=arr[j];
		arr[j]=pivat;
		return j;
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
		a.quickSort(arr, 0, arr.length-1);
		for (int ar : arr) {
			System.out.print(ar + " ");
		}
	}
}
