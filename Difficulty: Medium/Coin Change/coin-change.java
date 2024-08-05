//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        
        long prev[]=new long[sum+1];
		long curr[]=new long[sum+1];
		
		for(int target=0;target<=sum;target++)
		{
			prev[target]=target%coins[0]==0?1:0;
		}
		
		for(int i=1;i<N;i++)
		{
			for(int j=0;j<=sum;j++)
			{
				long notTake=prev[j];
				long take=0;
				
				if(coins[i]<=j)
				{
					take=curr[j-coins[i]];
				}
				
				curr[j]=notTake+take;
			}
			
			prev=curr.clone();
		}
		return prev[sum];
    }
}