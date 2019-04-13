package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

interface i {
	int j = 45;
}

interface i2 {
	int j = 45;
}

public class April13 implements i, i2 {
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

	public static HashMap<Pair, Integer> map=new HashMap<>();

	public static void main(String[] args) {
		April13 a = new April13();
//		System.out.println(a.boardPath(0, 10));
//		System.out.println(a.mazePathD(0, 0, 2, 2));
//		System.out.println(a.mazePathDMM(0, 0, 2, 2));
//		a.countLexical(0, 100);
//		String str="hackerearth hackathons";
//		StringTokenizer t=new StringTokenizer(str,"h");
//		while(t.hasMoreElements()) {
//			System.out.print(t.nextToken());
//		}
//		System.out.println(10%6);
//		int arr[];
//		System.out.println(arr[1]);
//		int a1=45;
//		int b=98;
//		System.out.println(a1+b+" ");
//		TreeSet<StringBuffer> ts=new TreeSet<StringBuffer>();
//		ts.add(new StringBuffer("H"));
//		ts.add(new StringBuffer("A"));
//		ts.add(new StringBuffer("C"));
//		ts.add(new StringBuffer("K"));
//		ts.add(new StringBuffer("E"));
//		ts.add(new StringBuffer("R"));
//		System.out.println(ts1);
//		System.out.println(9&9);
		int arr[] = {5,6,7,9,78,20,32};
		int P=2;
		int l=arr.length-1;
		System.out.println(Math.abs(P-findMin(arr, 0, l, P)));
//		System.out.println(Math.abs(fun(arr, 0, 2, arr.length-1)));
//		Arrays.fill(board, -1);
//		System.out.println(4&7);
		System.out.println(6&7&9);
		

	}
	
	public static int findMin(int arr[],int low,int high,int item) {
		if(low==high) {
			return arr[low];
		}
		
		int r=low+(high-low)/2;
		int ans1=findMin(arr, low, r, item);
		int ans2=findMin(arr, r+1, high, item);
		
		return Math.min(Math.abs(ans1-item), Math.min(Math.abs(ans2-item), Math.abs((ans1&ans2)-item)))+item;
	}

	public static int fun(int arr[], int vi, int item, int ei) {
		if (vi == arr.length - 1 || vi == ei)
			return arr[vi] & arr[vi];
		
		Pair p=new Pair(vi, ei);
		if(map.containsKey(p)) {
			return map.get(p);
		}
//		if (board[vi][ei] != -1) {
//			return board[vi][ei];
//		}
		int ans1 = arr[vi] & fun(arr, vi + 1, item, ei);
		int ans2 = arr[ei] & fun(arr, vi, item, ei - 1);
		int ans3=fun(arr, vi + 1, item, ei);
		int ans4=fun(arr, vi , item, ei+1);
		
		int min=Math.min(Math.abs(ans1-item), Math.min(Math.abs(ans2-item), Math.min(Math.abs(ans3-item), Math.abs(ans4-item))));
//		return Math.min(Math.abs(ans1-item), Math.abs(ans2-item));
//		if (Math.abs(ans1 - item) < Math.abs(ans2 - item)) {
////			board[vi][ei]=ans1;
//			map.put(p, ans1);
//			return ans1;
//		}
////		board[vi][ei]=ans2;
		map.put(p, min+item);
		return ans2;

	}
}


class Pair{
	int si,ei;
	public Pair(int a,int b) {
		si=a;
		ei=b;
	}
}
//
//class A{
//	int a;
//	public A(int a) {
//		this.a=45;
//	}
//}
//
//class B extends A{
////	@Override
//	public B(int a) {
//		super(54);
//		this.a=89;
//	}
//}