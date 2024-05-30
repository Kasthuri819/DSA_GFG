//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        
        int n=S.length(),left=0,right=0,maxLen=0;
        
        Map<Character,Integer> map=new HashMap<>();
        
        while(right<n)
        {
            if(map.containsKey(S.charAt(right)))
            {
                left=Math.max(map.get(S.charAt(right))+1,left);
            }
            maxLen=Math.max(maxLen,right-left+1);
            map.put(S.charAt(right),right);
            right++;
        }
        
        return maxLen;
    }
}