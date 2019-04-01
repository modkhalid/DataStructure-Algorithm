package L2_basic1;

class PatternDeveloper{
//	constructor
	private int n;
	public PatternDeveloper(int n) {
		this.n=n;
	}
	public PatternDeveloper() {
		this(5);
	}
	
	
//	methods
	public void l1() {
		int n=this.n;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}


public class Pattern {
	public static void main(String[] args) {
		PatternDeveloper pd=new PatternDeveloper();
		pd.l1();
	}
}
