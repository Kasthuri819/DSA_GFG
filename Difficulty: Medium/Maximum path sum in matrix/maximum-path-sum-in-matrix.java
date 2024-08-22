//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int n, int matrix[][])
    {
		int dp[][]=new int[n][n];
		
		for(int j=0;j<n;j++)
		{
			dp[0][j]=matrix[0][j];
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				int upward=matrix[i][j]+dp[i-1][j];
				int leftDiagonal=matrix[i][j];
				if(j-1>=0) 
					leftDiagonal+=dp[i-1][j-1];
				else
					leftDiagonal+=(int)-1e9;
				int rightDiagonal=matrix[i][j];
				if(j+1<n) 
					rightDiagonal+=dp[i-1][j+1];
				else
					rightDiagonal+=(int)-1e9;
				
				dp[i][j]=Math.max(upward, Math.max(leftDiagonal, rightDiagonal));
			}
		}
		
		int max=Integer.MIN_VALUE;
		
		for(int j=0;j<n;j++)
		{
			max=Math.max(max,dp[n-1][j]);
		}
		
		return max;
    }
}