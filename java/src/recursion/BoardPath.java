package recursion;

import java.util.ArrayList;

public class BoardPath {
	public static ArrayList<String> path(int curr,int last){
		
		if(curr==last) {
			ArrayList<String>  br=new ArrayList<>();
			br.add("");
			return br;
		}
		if(curr>last) {
			ArrayList<String>  br=new ArrayList<>();
//			br.add("");
			return br;
		}
		ArrayList<String> mr =new ArrayList<>();
		for(int i=1;i<=6;i++) {
			ArrayList<String> rr=path(curr+i, last);
			for (String str:rr) {
				mr.add(i+str);
			}
		}
		return mr;
	}
	public static void main(String[] args) {
		System.out.println(path(0,6));
	}
}
