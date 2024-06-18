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
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
    
        ArrayList<String> resultList=new ArrayList<>();
        
        solve(n,"",0,resultList);
        
        return resultList;
  }
  
  private static void solve(int n,String ans,int ind,ArrayList<String> resultList)
  {
      if(ind==n)
      {
          resultList.add(ans);
          return;
      }
      
      if(ind!=0 && ans.charAt(ind-1)=='1')
      {
          solve(n,ans+'0',ind+1,resultList);
      }
      else
      {
          solve(n,ans+'0',ind+1,resultList);
          solve(n,ans+'1',ind+1,resultList);
      }
  }
}
     
     