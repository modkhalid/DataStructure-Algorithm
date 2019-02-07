package code_chief;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class appy_chef {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader bis = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(bis);
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {

			String[] data = in.readLine().split(" ");
			int n = Integer.parseInt(data[0]);
			int a = Integer.parseInt(data[1]);
			int b = Integer.parseInt(data[2]);
			int k = Integer.parseInt(data[3]);
			int counter = 0;
			for (int j = 2; j < n; j++) {
				if (((j % a == 0 && j % b != 0) || (j % a != 0 && j % b == 0)) && !(j%a==0 && j%b==0) ) {
					counter++;
				}
				if(counter>=k)
					break;
			}
			if(counter>=k)
				System.out.println("Win");
			else
				System.out.println("Lose");

		}

	}
}
