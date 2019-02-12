package recursion;

public class subsetProblem {
	
	public static void subS(int arr[],int target,int vidx,String ans) {
		if(vidx==arr.length) {
			if(target==0) {
				System.out.print(ans +" ");
			}
			return;
		}
		int res=arr[vidx];
		subS(arr, target-res, vidx+1, ans+" "+res);
		subS(arr, target, vidx+1, ans);
	}
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6};
		subS(arr, 7, 0, "");
		
	}
}
