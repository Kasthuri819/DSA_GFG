//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int K, int N, int A[]) {
        
        int front[]=new int[2*K+1];
		
		for(int index=N-1;index>=0;index--)
		{
			int curr[]=new int[2*K+1];
			for(int transaction=0;transaction<2*K;transaction++)
			{
				int profit=Integer.MIN_VALUE;
				
				if(transaction%2==0)
				{
					profit=Math.max(0+front[transaction],-A[index]+front[transaction+1]);
				}
				else
				{
					profit=Math.max(0+front[transaction],A[index]+front[transaction+1]);
				}
				
				curr[transaction]=profit;
			}
			
			front=curr;
		}
		
		return front[0];
    }
}