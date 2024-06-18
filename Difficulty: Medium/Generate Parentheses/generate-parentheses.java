//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        ArrayList<String> parenthesesList=new ArrayList<>();
        solver(n,0,0,"",parenthesesList);
        
        return parenthesesList;
    }
    
    private static void solver(int n,int open,int close,String parentheses,ArrayList<String> parenthesesList)
    {
        
        if(open==n && close==n)
        {
            parenthesesList.add(parentheses);
            return;
        }
        
        if(open<n)
        {
            solver(n,open+1,close,parentheses+'(',parenthesesList);
        }
        
        if(close<open)
        {
            solver(n,open,close+1,parentheses+')',parenthesesList);
        }
    }
}