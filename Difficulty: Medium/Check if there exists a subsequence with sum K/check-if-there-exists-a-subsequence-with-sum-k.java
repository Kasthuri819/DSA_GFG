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
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
     
      Solution obj = new Solution();
      boolean ans = obj.checkSubsequenceSum(n,a,k);
      System.out.println(ans?"Yes":"No");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    
    
    return solver(arr,0,0,K);

  }
  
  private static boolean solver(int[] arr,int sum,int index,int k)
  {
      if(index==arr.length)
      {
          if(sum==k)
            return true;
          else
            return false;
      }
      
      if(sum>k)
      {
          return false;
      }
      
      if(solver(arr,sum+arr[index],index+1,k)) return true;
      
      if(solver(arr,sum,index+1,k)) return true;
      
      return false;
  }
}
     