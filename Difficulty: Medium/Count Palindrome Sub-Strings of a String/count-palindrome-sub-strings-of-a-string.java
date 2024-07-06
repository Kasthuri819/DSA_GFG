//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            String S = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.CountPS(S, N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int CountPS(String s, int n) {
        
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            String substr="";
            for(int j=i;j<n;j++)
            {
                substr+=s.charAt(j);
                
                if(isPalindrome(substr) && substr.length()>=2)
                {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private static boolean isPalindrome(String s)
    {
        int start=0,end=s.length()-1;
        
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}