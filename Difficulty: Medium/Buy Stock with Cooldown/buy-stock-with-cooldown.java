//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextLong();
            }
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long prices[], int N){
        
        long front1[]=new long[2];
		long front2[]=new long[2];
		long curr[]=new long[2];
		
		for(int index=N-1;index>=0;index--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				long profit=0L;
				
				if(buy==0)
				{
					profit=Math.max(0+front1[0],-prices[index]+front1[1]);
				}
				if(buy==1)
				{
					profit=Math.max(0+front1[1],prices[index]+front2[0]);
				}
				
				curr[buy]=profit;
			}
			
			front2=front1.clone();
			front1=curr.clone();
		}
		return front1[0];
    }
}
