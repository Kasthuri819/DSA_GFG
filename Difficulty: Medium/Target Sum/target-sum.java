//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(N,A, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    private static final int MOD=(int)1e9+7;
    
    static int findTargetSumWays( int n, int[] arr ,int target) {
        
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        if (totSum - target < 0 || (totSum - target) % 2 == 1)
            return 0;

        return countPartitionsSpaceOptimized(arr,(totSum - target) / 2);
    }
    
    private static int countPartitionsSpaceOptimized(int[] num,int tar) {
        
	    int n = num.length;

        int[][] dp = new int[n][tar + 1];

        if (num[0] == 0)
            dp[0][0] = 2; 
        else
            dp[0][0] = 1; 

        if (num[0] != 0 && num[0] <= tar)
            dp[0][num[0]] = 1; 

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= tar; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (num[ind] <= target)
                    taken = dp[ind - 1][target - num[ind]];

                dp[ind][target] = (notTaken + taken) % MOD;
            }
        }

        return dp[n - 1][tar];
	}
};