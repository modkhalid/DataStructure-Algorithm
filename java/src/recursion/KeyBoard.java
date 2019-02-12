package recursion;

import java.util.ArrayList;

public class KeyBoard {
	public static String getCode(char ch) {
		if(ch=='1') 
			return "abc";
		else if(ch=='2') 
			return "def";
		else if(ch=='3') 
			return "ghi";
		else if(ch=='4') 
			return "jkl";
		else if(ch=='5') 
			return "mno";
		else if(ch=='6') 
			return "pqr";
		else if(ch=='7') 
			return "stu";
		else if(ch=='8') 
			return "vwx";
		else if(ch=='9') 
			return "yz";
		else if(ch=='0') 
			return "@#";
		else 
			return "";
	}

	public static ArrayList<String> keyBordDisplay(String key) {
		if(key.length()==0) {
			ArrayList<String> br=new ArrayList<>();
			br.add("");
			return br;
		}
		char ch=key.charAt(0);
		ArrayList<String> mr=new ArrayList<>();
		String code=getCode(ch);
		ArrayList<String> rr=keyBordDisplay(key.substring(1));
		for (int i = 0; i < code.length(); i++) {
			for(String res:rr) {
				mr.add(code.charAt(i)+res);
			}
		}
		return mr;
		
	}
	public static void main(String[] args) {
		System.out.println(keyBordDisplay("456"));
	}
}
