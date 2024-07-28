//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.kvowelwords(N,K);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    private static final double MOD=1e9+7;
    private static final int ALPHABETS=26;
    private static final int VOWELS=5;
    
    public int kvowelwords(int N,int K){
       
       double dp[][]=new double[N+1][K+1];
       
       for(int j=0;j<=K;j++)
       {
           dp[0][j]=1;
       }
       
       for(int i=1;i<=N;i++)
       {
           for(int j=0;j<=K;j++)
           {
               dp[i][j]=(dp[i-1][K]*(ALPHABETS-VOWELS))%MOD;
               
               if(j>0)
               {
                   dp[i][j]=(dp[i][j]+dp[i-1][j-1]*VOWELS%MOD)%MOD;
               }
           }
       }
       
       return (int)dp[N][K];
    }
}
