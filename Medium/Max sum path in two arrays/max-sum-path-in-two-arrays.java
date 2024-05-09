//{ Driver Code Starts
import java.util.*;

class ArrPathSum1
{
	// Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int ar1[] = new int[m];
			int ar2[] = new int[n];
			for(int i=0; i<m; i++)
				ar1[i] = sc.nextInt();
			for(int i=0; i<n; i++)
				ar2[i] = sc.nextInt();
		
		Solution g = new Solution();
		System.out.println(g.maxPathSum(ar1,ar2));
		T--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method
    * ar1 : 1st array
    * ar2 : 2nd array
    */
    int maxPathSum(int A[], int B[])
    {
         int i = 0, j = 0;
        int sumA = 0, sumB = 0;
        int result = 0,M=A.length,N=B.length;

        while (i < M && j < N) {
            if (A[i] < B[j]) {
                sumA += A[i++];
            } else if (A[i] > B[j]) {
                sumB += B[j++];
            } else {
                result += Math.max(sumA, sumB) + A[i];
                sumA = 0;
                sumB = 0;
                i++;
                j++;
            }
        }

        while (i < M)
            sumA += A[i++];
        while (j < N)
            sumB += B[j++];

        result += Math.max(sumA, sumB);

        return result;
    }
}