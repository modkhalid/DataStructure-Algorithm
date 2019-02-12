package recursion;

import java.util.ArrayList;

public class Subsequence {
	public static ArrayList<String> getSubsequence(String str){
		if(str.length()==0) {
			ArrayList<String> br=new ArrayList<>();
			br.add("");
			return br;
		}
		char ch=str.charAt(0);
		String ros=str.substring(1);
		ArrayList<String> mr =new ArrayList<>();
		
		ArrayList<String> rr=getSubsequence(ros);
		for(String rrr:rr) {
			mr.add(rrr);
			int x=ch+0;
			mr.add((ch+0)+rrr);
			mr.add(ch+rrr);
		}
		return mr;
		
	}
	public static void main(String[] args) {
		System.out.println(getSubsequence("abc"));
	}
}
