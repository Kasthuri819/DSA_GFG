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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    
    private static final int MOD=(int)1e9+7;

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int prev[]=new int[sum+1];
		int curr[]=new int[sum+1];
		
	    if(arr[0]==0)
	      prev[0]=2;
	    else{
	      prev[0]=1;
		  if(arr[0]<=sum) prev[arr[0]]=1;
	    }
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=sum;j++)
			{
				int notTaken=prev[j];
				int taken=0;
				
				if(arr[i]<=j)
				{
					taken=prev[j-arr[i]];
				}
				
				curr[j]=(notTaken+taken)%MOD;
			}
			prev=curr.clone();
		}
		
		return prev[sum];
	} 
}


