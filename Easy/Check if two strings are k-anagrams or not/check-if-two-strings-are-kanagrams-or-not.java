//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
class GFG {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		String str1=sc.next();
    		String str2=sc.next();
    		int k=sc.nextInt();
            Solution ob = new Solution();
    		if (ob.areKAnagrams(str1, str2, k) == true)
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        
        int s1Length=s1.length();
        int s2Length=s2.length();
        
        if(s1Length!=s2Length)
        {
            return false;
        }
        
        if(s1Length==k)
        {
            return true;
        }
        
        Map<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<s1Length;i++)
        {
            char ch=s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        for(int j=0;j<s2Length;j++)
        {
            char ch=s2.charAt(j);
            if(map.containsKey(ch) && map.get(ch)>0)
            {
                map.put(ch,map.get(ch)-1);
            }
            else
            {
                k--;
            }
        }
        
        return k>=0?true:false;
    }
}