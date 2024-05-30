//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        
        int n=s.length(),right=0,left=0,maxLen=-1;
		
		if(n==0||k==0) return -1;
		
		Map<Character,Integer> map=new HashMap<>();
		
		while(right<n)
		{
			map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
			
			while(map.size()>k)
			{
				map.put(s.charAt(left),map.get(s.charAt(left))-1);
				if(map.get(s.charAt(left))==0)
				{
					map.remove(s.charAt(left));
				}
				left++;
			}
			if(map.size()==k)
			{
				maxLen=Math.max(maxLen, right-left+1);
			}
			right++;
		}
		
		return maxLen;
    }
}