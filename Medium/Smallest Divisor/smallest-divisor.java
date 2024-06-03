//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] a, int k) {
        
        
        int n=a.length,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			max=Integer.max(max, a[i]);
		}
		
		int low=1,high=max;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(sumDivisor(a,mid)<=k)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		return low;
        
    }
    
    private static int sumDivisor(int[] a, int mid) {
		
		int sum=0;
		
		for(int i=0;i<a.length;i++)
		{
			sum+=Math.ceil((double)a[i]/(double)mid);
		}
		return sum;
	}
}