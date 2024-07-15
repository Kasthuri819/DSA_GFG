//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        return str.length() - longestPalindromicSubsequence(str);
    }
    
    private static int longestPalindromicSubsequence(String str)
    {
        StringBuilder sb=new StringBuilder(str);
        String reverseStr=sb.reverse().toString();
        
        return longestCommonSubsequence(str,reverseStr,str.length(),reverseStr.length());
    }
    
    private static int longestCommonSubsequence(String s1,String s2,int m,int n)
    {
        int dp[][]=new int[m+1][n+1];
        
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
    }
}