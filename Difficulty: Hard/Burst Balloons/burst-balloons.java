//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int N, int[] arr) {
    
        int newArr[]=new int[N+2];
		
		newArr[0]=1;
		newArr[N+1]=1;
		
		for(int i=0;i<N;i++)
		{
			newArr[i+1]=arr[i];
		}
		
		return burstBalloonsTabulation(N,newArr);
  }
  
  private static int burstBalloonsTabulation(int n, int[] arr) {
		
		int dp[][]=new int[n+2][n+2];
		
		for(int i=n;i>=1;i--)
		{
			for(int j=1;j<=n;j++)
			{
				if(i>j) continue;
				
				int max=Integer.MIN_VALUE;
				
				for(int ind=i;ind<=j;ind++)
				{
					int cost=arr[i-1]*arr[ind]*arr[j+1]+dp[i][ind-1]+dp[ind+1][j];
					max=Math.max(max, cost);
				}
				
				dp[i][j]=max;
			}
		}
		
		return dp[1][n];
	}
}
     