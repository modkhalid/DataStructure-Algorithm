package L2_basic1;

import java.util.Scanner;

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
		int counter = 0;
		int n = this.n * 2 - 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= counter; j++) {
				System.out.print("*");
			}
			System.out.println();

			if (i < n / 2)
				counter++;
			else
				counter--;
		}
	}

	void l14() {
		int counter = n - 1;
		int n = this.n * 2 - 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= counter; j++) {
				System.out.print("*");
			}
			System.out.println();

			if (!(i < n / 2))
				counter++;
			else
				counter--;
		}
	}

	public void l14b() {
		int space = n - 1;
		int n = this.n * 2 - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < this.n; j++) {
				if (space > j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			if (i < n / 2) {
				space--;
			} else {
				space++;
			}
			System.out.println();

		}
	}

	public void l15() {
		int space = 0;
		int n = this.n * 2 - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < this.n; j++) {
				if (space > j)
					System.out.print("  ");
				else
					System.out.print("*");
			}
			System.out.println();
			if (i < n / 2) {
				space++;
			} else {
				space--;
			}
		}
	}

	public void l17() {
		int space = this.n;
		int ospace = 0;
		int n = this.n * 2 - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < this.n; j++) {
				if (j < space)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			for (int j = 0; j < this.n; j++) {
				if (j < ospace)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
			if (!(i < n / 2)) {
				space++;
				ospace--;
			} else {
				space--;
				ospace++;
			}
		}
	}

	public void pascals() {
//		System.out.println();
		int space = n - 1;
		int counter = 0;
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = 0; j < n; j++) {
				if (j < space) {
					System.out.print("  ");
				} else {
					if (!flag) {
						System.out.print(i + 1 + " ");
						flag = true;
					} else {
						System.out.print(0 + " ");
					}
				}
			}
			for (int j = 0; j < counter; j++) {
				if (j == counter - 1) {
					System.out.println(i + 1 + " ");
				} else {
					System.out.print("0 ");
				}
			}
			counter++;
			System.out.println();
			space--;
		}

	}
	
	
	public void rotate() {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int r=sc.nextInt();
		int ans=n;
		int counter=0;
		while(n!=0) {
			counter++;
			n/=10;
		}
		r=r%counter;
//		System.out.println(r);
		for (int i = 0; i < r; i++) {
			ans=((ans%10)*(int)Math.pow(10, counter-1))+ans/10;
		}
		System.out.println(ans);
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
//		pd.l13();
//		pd.l14();
//		pd.l15();
//		pd.l17();
//		pd.pascals();
		pd.rotate();
	}
}
