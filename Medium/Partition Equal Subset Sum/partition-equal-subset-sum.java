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
       int sum=0;
       
       for(int i=0;i<N;i++)
       {
           sum+=arr[i];
       }
       
       if(sum%2!=0)
       {
           return 0;
       }
       
       int target=sum/2;
       boolean dp[]=new boolean[target+1];
       
       dp[0]=true;
       
       for(int num:arr)
       {
           for(int j=target;j>=num;j--)
           {
               dp[j]|=dp[j-num];
           }
       }
       
       return dp[target]?1:0;
    }
}