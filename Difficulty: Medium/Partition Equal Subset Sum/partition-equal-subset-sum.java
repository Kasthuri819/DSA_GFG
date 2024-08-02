//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        return partitionEqualSubsetSumSpaceOptimizedApproach(arr,N)?1:0;
    }
    
    private static boolean partitionEqualSubsetSumSpaceOptimizedApproach(int[] arr, int n) {
		
		int totalSum=0;
		
		for(int i=0;i<n;i++)
		{
			totalSum+=arr[i];
		}
		
		if(totalSum%2==1) return false;
		
		int target=totalSum/2;
		
		return subsetSumEqualToTarget(arr,n,target);
	}

	private static boolean subsetSumEqualToTarget(int[] arr, int n, int target) {
		
		boolean prev[]=new boolean[target+1];
		boolean curr[]=new boolean[target+1];
		
		prev[0]=curr[0]=true;
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=target;j++)
			{
				boolean notTake=prev[j];
				boolean take=false;
				
				if(arr[i]<=j)
				{
					take=prev[j-arr[i]];
				}
				
				curr[j]=take||notTake;
			}
			
			prev=curr.clone();
		}
		
		return prev[target];
	}
}