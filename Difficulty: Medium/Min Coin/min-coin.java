//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String S = br.readLine().trim();
            String[] S1 = S.split(" ");
            int n = Integer.parseInt(S1[0]);
            int amount = Integer.parseInt(S1[1]);
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < s1.length; i++) nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.MinCoin(nums, amount);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int MinCoin(int[] arr, int amount) {
        
        int n=arr.length;
        int prev[]=new int[amount+1];
		int curr[]=new int[amount+1];
		
		for(int target=0;target<=amount;target++)
		{
			if(target%arr[0]==0)
				prev[target]=target/arr[0];
			else
				prev[target]=(int)1e9;
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=amount;j++)
			{
				int notTake=0+prev[j];
				int take=Integer.MAX_VALUE;
				if(arr[i]<=j)
				{
					take=1+curr[j-arr[i]];
				}
				
				curr[j]=Math.min(notTake, take);
			}
			
			prev=curr.clone();
		}
		
		int result=prev[amount];
		
		return result>=1e9?-1:result;
    }
}