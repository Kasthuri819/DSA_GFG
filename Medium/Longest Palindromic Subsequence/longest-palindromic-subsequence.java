//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        return LongestPalindromicSubsequence(S);
    }
    
    private int LongestPalindromicSubsequence(String s)
    {
        String reversed=new StringBuilder(s).reverse().toString();
        return lcs(s,reversed);
    }
    
    private int lcs(String s1,String s2)
    {
        int n=s1.length(),m=s2.length();
        
        int dp[][]=new int[n+1][m+1];
        
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        
        for(int i=0;i<n;i++)
        {
            dp[i][0]=0;
        }
        
        for(int j=0;j<m;j++)
        {
             dp[0][j]=0;
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
}