//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        
        int stringLength=s.length();
        int count[]=new int[26];
        
        for(int i=0;i<stringLength;i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
                count[s.charAt(i)-'a']++;
            }
            else if(s.charAt(i)>='A' && s.charAt(i)<='Z')
            {
                count[s.charAt(i)-'A']++;
            }
        }
        
        for(int i=0;i<26;i++)
        {
            if(count[i]==0)
                return false;
        }
        
        return true;
    }
}

//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends