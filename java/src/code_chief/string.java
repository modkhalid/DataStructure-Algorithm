package code_chief;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class string {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader sc=new BufferedReader(isr);
		int t=Integer.parseInt(sc.readLine());
		while(t>0) {
			int n=Integer.parseInt(sc.readLine());
			String str[]=new String[n];
			str[0]=sc.readLine();
			int counter=str[0].length();
			for (int i = 1; i < str.length; i++) {
				str[i]=sc.readLine();
				int l=str[i].length();
				for (int j = 0; j < str[0].length(); j++) {
					int x=str[i].indexOf(str[0].charAt(j));
					if(x!=-1) {
						if(l==x+1) {
							str[i]=str[i].substring(0, x);
						}else {
							str[i]=str[i].substring(0, x)+str[i].substring(x+1);
						}
						l--;
					}else {
						if(counter==j+1){
							str[0]=str[0].substring(0, j);
						}else {
							str[0]=str[0].substring(0, j)+str[0].substring(j+1);
						}
						
						counter--;
						j--;
					}
				}

			}
			System.out.println(counter);

			
			
			t--;
		}
		
	}
}
