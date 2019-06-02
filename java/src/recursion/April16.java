package recursion;

public class April16 {
	/*+
	 * coding block rat maze
	 */
	
	public static int Maze(boolean board[][],int row,int col) {
		if(row>=board.length || col>=board.length || board[row][col]) {
			return 0;
		}		
		if(row==board.length-1 && col==board[0].length-1) {
			return 1;
		}
		int ans=0;
		ans+=Maze(board, row, col+1);
		ans+=Maze(board, row+1, col);
		return ans;
	}
	
	public static void main(String[] args) {
		boolean board[][]= new boolean[4][4];
//		board[0][3]=true;
		board[1][0]=true;
		board[1][2]=true;
		System.out.println(Maze(board, 0, 0));
	}
}
/*

7 5 3 5 6 2 9 
1 2 7 0 9 3 6 
0 6 2 6 1 8 7 
9 2 0 2 3 7 5

*/