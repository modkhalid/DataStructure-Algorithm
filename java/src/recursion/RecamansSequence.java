package recursion;

import java.util.HashMap;
import java.util.Scanner;

public class RecamansSequence {

	public static int calculateRaceman(int n, HashMap<Integer, Integer> map) {
		if (n == 0)
			return 0;
//		System.out.println(map.get(n - 1) -n);
		if (map.get(n - 1)-n > 0 && !map.containsValue(map.get(n - 1)-n )) {
			return map.get(n - 1) - n;
		}
		return map.get(n - 1) + n;
	}

	public static int[] RacemanSequence() {
		int arr[] = new int[100];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			arr[i]=calculateRaceman(i, map);
			map.put(i,arr[i]);
		}

		return arr;
	}

	public static void main(String[] args) {
		int arr[]=RacemanSequence();
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0) {
			
			int n=sc.nextInt();
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			t--;
		}
	}
}
