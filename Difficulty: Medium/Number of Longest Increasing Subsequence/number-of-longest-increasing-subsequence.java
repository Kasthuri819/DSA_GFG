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
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.NumberofLIS(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int NumberofLIS(int N, int arr[]){
        
        int dp[]=new int[N],count[]=new int[N],max=Integer.MIN_VALUE;
        
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        
        for(int index=0;index<N;index++)
        {
            for(int prevIndex=0;prevIndex<index;prevIndex++)
            {
                if(arr[prevIndex]<arr[index] && 1+dp[prevIndex]>dp[index])
                {
                    dp[index]=1+dp[prevIndex];
                    count[index]=count[prevIndex];
                }
                else if(arr[prevIndex]<arr[index] && 1+dp[prevIndex]==dp[index])
                {
                    count[index]+=count[prevIndex];
                }
            }
            max=Math.max(max,dp[index]);
        }
        
        int nolis=0;
        
        for(int i=0;i<N;i++)
        {
            if(dp[i]==max)
            {
                nolis+=count[i];
            }
        }
        
        return nolis;
    }
}