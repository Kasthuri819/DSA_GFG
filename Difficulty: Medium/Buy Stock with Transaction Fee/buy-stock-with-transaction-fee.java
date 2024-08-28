//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            long[] prices = new long[N];
            for (int i = 0; i < N; i++) {
                prices[i] = sc.nextLong();
            }
            int fee = sc.nextInt();
            Solution obj = new Solution();
            long res = obj.maximumProfit(prices, N, fee);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long maximumProfit(long prices[], int n, int fee) {
        
        long currNotBuy,frontNotBuy=0,frontBuy=0,currBuy;

		for(int index=n-1;index>=0;index--)
		{
			currNotBuy=Math.max(0+frontNotBuy,-prices[index]+frontBuy);
			currBuy=Math.max(0+frontBuy,prices[index]-fee+frontNotBuy);
			
			frontNotBuy=currNotBuy;
			frontBuy=currBuy;
		}
		
		return frontNotBuy;
    }
}