package Algorithms;

import java.util.Scanner;

public class selection_sort {
	
	public static void sort(int arr[]) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	
	public static void sort_best(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int min_i=i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<arr[min_i]) {
					min_i=j;
				}
			}
			if(i!=min_i) {
				int temp=arr[i];
				arr[i]=arr[min_i];
				arr[min_i]=temp;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int arr[]=new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
//		sort(arr);
		sort_best(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}