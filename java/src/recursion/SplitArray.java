package recursion;

public class SplitArray {
	public static void split(int arr[],int vidx,int s1,int s2,String ans1,String ans2) {
		if(vidx==arr.length) {
			if(s1==s2) {
				System.out.println(ans1+ " and "+ans2);
				
			}
			return;
		}
		int res=arr[vidx];
		split(arr,vidx+1,s1+res,s2,ans1+" "+res,ans2);
		split(arr,vidx+1,s1,s2+res,ans1,ans2+" "+res);
		
	}
	public static void main(String[] args) {
		int arr[]= {1,2,3};
		split(arr, 0, 0, 0, "", "");
		
	}
}
