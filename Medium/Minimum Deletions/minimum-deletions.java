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
        
        int n = S.length();
        // Create a 2D array to store the minimum number of deletions required
        int[][] dp = new int[n][n];
        
        // Fill the dp array
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (S.charAt(i) == S.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
            }
        }
        
        // Return the minimum number of deletions required to make the whole string palindrome
        return dp[0][n - 1];
        
    }
}