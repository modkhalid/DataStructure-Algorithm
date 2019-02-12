package recursion;

import java.util.ArrayList;

public class mazePath {
	
	
	public static  ArrayList<String> mazePath(int cr,int cc,int er,int ec){
		if(cr==er && cc==ec) {
			ArrayList<String> br=new ArrayList<>();
			br.add("");
			return br;
			
		}
		if(cr>er || cc>ec) {
			ArrayList<String> br=new ArrayList<>();
			return br;
		}
		ArrayList<String> mr=new ArrayList<>();
		
		ArrayList<String> hor=mazePath(cr, cc+1, er, ec);
		for(String str:hor) {
			mr.add('H'+str);
		}
		
		hor=mazePath(cr+1, cc, er, ec);
		for(String str:hor) {
			mr.add('V'+str);
		}
		
		hor=mazePath(cr+1, cc+1, er, ec);
		for(String str:hor) {
			mr.add('D'+str);
		}
		return mr;
	}
	
	
	public static int NumberPath(int cr,int cc,int er,int ec) {
		if(cr==er && cc==ec) {
			return 1;
			
		}
		if(cr>er || cc>ec) {
			return 0;
		}
		int res=0;
		res+=NumberPath(cr, cc+1, er, ec);
		res+=NumberPath(cr+1, cc, er, ec);
		res+=NumberPath(cr+1, cc+1, er, ec);
		return res;
		
	}
	public static void main(String[] args) {
		System.out.println(mazePath(0, 0, 2, 2));
		System.out.println(NumberPath(0, 0, 2, 2));
	}
}
