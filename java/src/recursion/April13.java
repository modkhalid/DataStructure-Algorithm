package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class April13 {
	
	public ArrayList<String> boardPath(int curr, int end) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		if (curr > end) {
			return new ArrayList<String>();
		}

		ArrayList<String> mr = new ArrayList<String>();
		ArrayList<String> rr;
		for (int i = 1; i <= 6; i++) {
			rr = this.boardPath(curr + i, end);
			for (String s : rr) {
				mr.add(i + s);
			}
		}

		return mr;
	}

	public ArrayList<String> mazePath(int sr, int sc, int er, int ec) {
		if (sr > er || sc > ec) {
			return new ArrayList<String>();
		}
		if (sr == er && sc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();
		ArrayList<String> rr = mazePath(sr + 1, sc, er, ec);
		for (String rrr : rr) {
			mr.add("H" + rrr);
		}
		rr = mazePath(sr, sc + 1, er, ec);
		for (String rrr : rr) {
			mr.add("V" + rrr);
		}
		return mr;
	}

	public ArrayList<String> mazePathD(int sr, int sc, int er, int ec) {
		if (sr > er || sc > ec) {
			return new ArrayList<String>();
		}
		if (sr == er && sc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();
		ArrayList<String> rr = mazePathD(sr + 1, sc, er, ec);
		for (String rrr : rr) {
			mr.add("H" + rrr);
		}
		rr = mazePathD(sr, sc + 1, er, ec);
		for (String rrr : rr) {
			mr.add("V" + rrr);
		}
		rr = mazePathD(sr + 1, sc + 1, er, ec);
		for (String rrr : rr) {
			mr.add("D" + rrr);
		}
		return mr;
	}

	public ArrayList<String> mazePathDMM(int sr, int sc, int er, int ec) {
		if (sr > er || sc > ec) {
			return new ArrayList<String>();
		}
		if (sr == er && sc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();

		for (int i = 1; i <= er; i++) {
			ArrayList<String> rr = this.mazePathDMM(sr + i, sc, er, ec);
			for (String rrr : rr) {
				mr.add("H" + i + rrr);
			}
		}

		for (int i = 1; i <= ec; i++) {
			ArrayList<String> rr = this.mazePathDMM(sr, sc + i, er, ec);
			for (String rrr : rr) {
				mr.add("V" + i + rrr);
			}
		}

		for (int i = 1; i <= er && i <= ec; i++) {
			ArrayList<String> rr = this.mazePathDMM(sr + i, sc + i, er, ec);
			for (String rrr : rr) {
				mr.add("D" + i + rrr);
			}
		}

		return mr;
	}

	public void countLexical(int curr, int end) {
		if (curr > end)
			return;
		System.out.println(curr);
		if (curr == 0) {
			for (int i = 1; i <= 9; i++) {
				this.countLexical(curr * 10 + i, end);
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				this.countLexical(curr * 10 + i, end);
			}
		}
	}

	public static int findMin(int arr[], int low, int high, int item) {
		if (low == high) {
			return arr[low];
		}

		int r = low + (high - low) / 2;
		int ans1 = findMin(arr, low, r, item);
		int ans2 = findMin(arr, r + 1, high, item);

		return Math.min(Math.abs(ans1 - item), Math.min(Math.abs(ans2 - item), Math.abs((ans1 & ans2) - item))) + item;
	}

	public static void Permutation(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			Permutation(ros, ans + ch);
		}
	}

	public static ArrayList<String> perm(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		ArrayList<String> mr = new ArrayList<String>();
		ArrayList<String> rr = perm(str.substring(1));
		for (String rrr : rr) {
			for (int i = 0; i <= rrr.length(); i++) {
				mr.add(rrr.substring(0, i) + ch + rrr.substring(i));
//				String ss=
			}
		}
		return mr;

	}

	public static void permutationRemoveDuplicates(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		boolean visited[] = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			
			String ros = str.substring(0, i) + str.substring(i + 1);
			if(!visited[ch]) {
				permutationRemoveDuplicates(ros, ans + ch);
				visited[ch]=true;
			}

		}
	}
	public static int permutationsRemoveDupliA2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		int res = 0;
		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			boolean flag = true;

			for (int j = i + 1; j < ques.length(); j++) {
				if (ch == ques.charAt(j)) {
					flag = false;
					break;
				}
			}
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (flag)
				res += permutationsRemoveDupliA2(roq, ans + ch);
		}

		return res;
	}


	public static int fun(int arr[], int vi, int item, int ei) {
		/*if (vi == arr.length - 1 || vi == ei)
			return arr[vi] & arr[vi];

		Pair p = new Pair(vi, ei);
		if (map.containsKey(p)) {
			return map.get(p);
		}
//		if (board[vi][ei] != -1) {
//			return board[vi][ei];
//		}
		int ans1 = arr[vi] & fun(arr, vi + 1, item, ei);
		int ans2 = arr[ei] & fun(arr, vi, item, ei - 1);
		int ans3 = fun(arr, vi + 1, item, ei);
		int ans4 = fun(arr, vi, item, ei + 1);

		int min = Math.min(Math.abs(ans1 - item),
				Math.min(Math.abs(ans2 - item), Math.min(Math.abs(ans3 - item), Math.abs(ans4 - item))));
//		return Math.min(Math.abs(ans1-item), Math.abs(ans2-item));
//		if (Math.abs(ans1 - item) < Math.abs(ans2 - item)) {
////			board[vi][ei]=ans1;
//			map.put(p, ans1);
//			return ans1;
//		}
////		board[vi][ei]=ans2;
		map.put(p, min + item);
		return ans2;*/
		return -1;

	}
	
	
	public static void coin(int n, String ans) {
		if(n==0) {
			System.out.println(ans);
			return ;
			
		}
		coin(n-1, ans+"H");
		coin(n-1,ans+"T");
	}
	
	
	public static int knight(boolean board[][],int row ,int col,String ans,int posf) {
		if(posf==board.length) {
			System.out.print(ans+" ");
			return 1;
		}
		int res=0;
		for(int c=col;c<board.length;c++) {
			if(isSafeKNight(board, row, c)) {
				board[row][c]=true;
				res+=knight(board, row, c+1, ans+"{"+row+"-"+c+"} ", posf+1);
				board[row][c]=false;
			}
		}
		
		for (int r = row+1; r < board.length; r++) {
			
			for(int c=0;c<board.length;c++) {
				if(isSafeKNight(board, r, c)) {
					board[r][c]=true;
					res+=knight(board, r, c+1, ans+"{"+r+"-"+c+"} ", posf+1);
					board[r][c]=false;
				}
			}
		}
		return res;
	}
	
	
	
	public static boolean isSafeKNight(boolean board[][],int row,int col) {
		int r=row;
		int c=col;
		
		if(r-2>=0 && c-1>=0 && board[r-2][c-1])
			return false;
		if(r-1>=0 && c-2>=0 && board[r-1][c-2])
			return false;
		
		if(r-2>=0 && c+1<board.length && board[r-2][c+1])
			return false;
		
		if(r-1>=0 && c+2<board.length && board[r-1][c+2])
			return false;

		return true;
		
	}
	
	
	public static void perDic(String str,String ans,String ques) {
		if(str.length()==0) {
			if(!ans.equals(ques)) {
				System.out.println(ans);
			}
			return;
		}
		char com=str.charAt(0);
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)<com) {
				continue;
			}else {
				char ch=str.charAt(i);
				String ros=str.substring(0,i)+str.substring(i+1);
				
				perDic(ros, ans+ch,ques);
			}
		}
	}
	
//	public static int coin(int n, String ans) {
//
//		if (n == 0) {
//			System.out.println(ans);
//			return 1;
//		}
//
//		int hc = coin(n - 1, ans + "H");
//		int tc = coin(n - 1, ans + "T");
//
//		return hc + tc;
//	}
	public static void main(String[] args) {
//		permutationRemoveDuplicates("ABAAA", "");
//		permutationsRemoveDupliA2("aba", "");
//		System.out.println(coin(2, ""));
//		coin(100,"");
//		System.out.println(knight(new boolean[2][2], 0, 0, "", 0));
		

//		Scanner sc=new  Scanner(System.in);
//		int n=sc.nextInt();
		
		perDic("bac", "","bac");
		/*
		 * // April13 a = new April13(); // System.out.println(a.boardPath(0, 10)); //
		 * System.out.println(a.mazePathD(0, 0, 2, 2)); //
		 * System.out.println(a.mazePathDMM(0, 0, 2, 2)); // a.countLexical(0, 100); //
		 * String str="hackerearth hackathons"; // StringTokenizer t=new
		 * StringTokenizer(str,"h"); // while(t.hasMoreElements()) { //
		 * System.out.print(t.nextToken()); // } // System.out.println(10%6); // int
		 * arr[]; // System.out.println(arr[1]); // int a1=45; // int b=98; //
		 * System.out.println(a1+b+" "); // TreeSet<StringBuffer> ts=new
		 * TreeSet<StringBuffer>(); // ts.add(new StringBuffer("H")); // ts.add(new
		 * StringBuffer("A")); // ts.add(new StringBuffer("C")); // ts.add(new
		 * StringBuffer("K")); // ts.add(new StringBuffer("E")); // ts.add(new
		 * StringBuffer("R")); // System.out.println(ts1); // System.out.println(9&9);
		 * // int arr[] = {5,6,7,9,78,20,32}; // int P=2; // int l=arr.length-1; //
		 * System.out.println(Math.abs(P-findMin(arr, 0, l, P))); //
		 * System.out.println(Math.abs(fun(arr, 0, 2, arr.length-1))); //
		 * Arrays.fill(board, -1); // System.out.println(4&7); //
		 * System.out.println(6&7&9); // Permutation("ABC", ""); //
		 * System.out.println(perm("abc"));
		 * 
		 */

	}
	
}
