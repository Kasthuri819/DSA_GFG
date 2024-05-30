//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int numberOfSubarrays(int arr[], int N, int target){
        
        return binarySubarraySum(arr,N,target)-binarySubarraySum(arr,N,target-1);
    }
    
    private int binarySubarraySum(int arr[],int n,int target)
    {
        int left=0,right=0,count=0,sum=0;
        
        while(right<n)
        {
            sum+=arr[right];
            
            while(sum>target)
            {
                sum=sum-arr[left];
                left++;
            }
            count=count+(right-left+1);
            right++;
        }
        
        return count;
    }
}