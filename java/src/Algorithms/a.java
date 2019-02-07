package Algorithms;

import java.util.Scanner;

public class a {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		String str[]=new String[size];
		for (int i = 0; i < size; i++) {
			str[i]=sc.next();
			for (int j = 0; j < str[i].length(); j++) {
//				String s=str[i];
			
				int temp=Character.getNumericValue(str[i].charAt(j));
//				System.out.println(temp);
				if(temp<9-temp) {
//					
//					str[i].charAt(j)='a';
//					System.out.println(temp);
					temp=9-temp;
					str[i]=str[i].substring(0, j)+temp+str[i].substring(j+1);
				}
				
			}
		}
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
	
}
