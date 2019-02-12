package recursion;

import java.util.ArrayList;

public class Permutations {
	public static ArrayList<String> prm(String str){
		if(str.length()==0) {
			ArrayList<String> br=new ArrayList<>();
			br.add("");
			return br;
		}
		char ch=str.charAt(0);
		ArrayList<String> mr=new ArrayList<>();
		ArrayList<String> rr=prm(str.substring(1));
		for(String rrr:rr) {
			for(int i=0;i<=rrr.length();i++) {
			
				mr.add(rrr.substring(0, i)+ch+rrr.substring(i));
			}
		}
		return mr;
		
		
//		return null;
	}
	public static void main(String[] args) {
		System.out.println(prm("abc"));
	}
}
