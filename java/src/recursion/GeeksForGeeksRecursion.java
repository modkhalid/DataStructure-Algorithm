package recursion;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class GeeksForGeeksRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Stack<Integer> s = new Stack<>();
			int n = sc.nextInt();
			while (n-- > 0)
				s.push(sc.nextInt());
			GfG g = new GfG();
			Stack<Integer> a = g.sort(s);
			while (!a.empty()) {
				System.out.print(a.peek() + " ");
				a.pop();
			}
			System.out.println();
		}
	}
}

class GfG {
	public Stack<Integer> sort(Stack<Integer> s) {
		int arr[] = new int[s.size()];
		Stack<Integer> m = s;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = m.pop();
			System.out.println(arr[i]);
		}
//		Arrays.sort(arr);
		sort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			m.push(arr[i]);
		}

		return m;
	}

	public void merge(int arr[], int beg, int mid, int end) {

		int l = mid - beg + 1;
		int r = end - mid;

		int LeftArray[] = new int[l];
		int RightArray[] = new int[r];

		for (int i = 0; i < l; ++i)
			LeftArray[i] = arr[beg + i];

		for (int j = 0; j < r; ++j)
			RightArray[j] = arr[mid + 1 + j];

		int i = 0, j = 0;
		int k = beg;
		while (i < l && j < r) {
			if (LeftArray[i] <= RightArray[j]) {
				arr[k] = LeftArray[i];
				i++;
			} else {
				arr[k] = RightArray[j];
				j++;
			}
			k++;
		}
		while (i < l) {
			arr[k] = LeftArray[i];
			i++;
			k++;
		}

		while (j < r) {
			arr[k] = RightArray[j];
			j++;
			k++;
		}
	}

	void sort(int arr[], int beg, int end) {
		if (beg < end) {
			int mid = (beg + end) / 2;
			sort(arr, beg, mid);
			sort(arr, mid + 1, end);
			merge(arr, beg, mid, end);
		}
	}
}