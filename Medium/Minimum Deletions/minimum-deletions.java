//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends




//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String S) {
        
       int stringLength=S.length();
       
       return stringLength - longestPalindromicSubsequence(S);
    }
    
    private static int longestPalindromicSubsequence(String s)
    {
        String reversed=new StringBuilder(s).reverse().toString();
        return lcs(s,reversed);
    }
    
    private static int lcs(String s1,String s2)
    {
        int n=s1.length(),m=s2.length();
        
        int dp[][]=new int[n+1][m+1];
        
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