package L2_basic1;

class PatternDeveloper {
//	constructor
	private int n;

	public PatternDeveloper(int n) {
		this.n = n;
	}

	public PatternDeveloper() {
		this(5);
	}

//	methods
	public void l1() {
		int n = this.n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void l2() {
		for (int i = 0; i < n; i++) {
			for (int j = i; j < this.n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void l3() {
		int counter = n - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (counter > j) {
					System.out.print(" ");
				} else
					System.out.print("*");
			}
			System.out.println();
			counter--;
		}
	}

	public void l4() {
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (counter > j) {
					System.out.print(" ");
				} else
					System.out.print("*");
			}
			System.out.println();
			counter++;
		}
	}

	public void squareFrame() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0 || i == n - 1 || j == n - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	public void printReverseNumber(int n) {
		int ans = 0, rem;
		while (n != 0) {
			rem = n % 10;
			ans = ans * 10 + rem;
			n = n / 10;
		}
		System.out.println(ans);
	}

	public void l11() {
		int counter = n - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (counter > j)
					System.out.print(" ");
				else if (j != n - 1)
					System.out.print("* ");
				else
					System.out.print("*");

			}
			System.out.println();
			counter--;
		}
	}

	public void l6() {
		int space = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (space > j)
					System.out.print("  ");
				else
					System.out.print("*");
			}
			space++;
			System.out.println();
		}
	}

	public void l9() {
		int counter = n - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (counter > j)
					System.out.print(" ");
				else if (j != n - 1)
					System.out.print("**");
				else
					System.out.print("*");

			}
			System.out.println();
			counter--;
		}
	}

	public void l13() {
		int counter=0;
		int n=this.n*2-1;
		
		for (int i = 0; i < n; i++) {
			for(int j=0;j<=counter;j++) {
				System.out.print("*");
			}
			System.out.println();
			
			if(i<n/2)
				counter++;
			else
				counter--;
		}
	}

}

public class Pattern {
	public static void main(String[] args) {
		PatternDeveloper pd = new PatternDeveloper(5);
//		pd.squareFrame();
//		pd.printReverseNumber(6589);
//		pd.l11();
//		pd.l6();
//		pd.l9();
		pd.l13();
	}
}
