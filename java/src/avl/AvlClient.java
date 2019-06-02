package avl;

import java.util.Scanner;

public class AvlClient {
	public static void main(String[] args) {
		Avl a=new Avl();
//		a.insert(65);
//		a.insert(66);
//		a.insert(64);
//		a.preorder();
//		
//		a.inorder();
		
		while(true) {
			int choice;
			Scanner sc=new Scanner(System.in);
//			choice=sc.nextInt();
//			switch (choice) {
//			case 1:
//				a.insert(sc.nextInt());
//				break;
//
//			default:
//				a.display();
//				break;
//			}
			a.insert(sc.nextInt());
			a.display();
		}
		
//		a.display();
		
	}
}
