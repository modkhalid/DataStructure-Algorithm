package recursion;

import java.util.ArrayList;

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
			ArrayList<String> rr = this.mazePathDMM(sr+i, sc, er, ec);
			for (String rrr : rr) {
				mr.add("H" + i + rrr);
			}
		}

		for (int i = 1; i <= ec; i++) {
			ArrayList<String> rr = this.mazePathDMM(sr, sc+i, er, ec);
			for (String rrr : rr) {
				mr.add("V" + i + rrr);
			}
		}
		
		for (int i = 1; i <= er && i<=ec; i++) {
			ArrayList<String> rr = this.mazePathDMM(sr+i, sc+i, er, ec);
			for (String rrr : rr) {
				mr.add("D" + i + rrr);
			}
		}

		return mr;
	}

	public static void main(String[] args) {
		April13 a = new April13();
//		System.out.println(a.boardPath(0, 10));
//		System.out.println(a.mazePathD(0, 0, 2, 2));
		System.out.println(a.mazePathDMM(0, 0, 2, 2));
	}
}
