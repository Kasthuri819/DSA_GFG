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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minDifference(int arr[], int n) 
	{ 
	   int totalSum=0;
		
		for(int i=0;i<n;i++)
		{
			totalSum+=arr[i];
		}
		
		int k=totalSum;
		boolean prev[]=new boolean[k+1];
		boolean curr[]=new boolean[k+1];
		
		prev[0]=curr[0]=true;
		
		if(arr[0]<=k) prev[arr[0]]=true;
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=k;j++)
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
		
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<=k/2;i++)
		{
			if(prev[i])
			{
				min=Math.min(min,Math.abs((k-i)-i));
			}
		}
		
	    return min;
	} 
}
