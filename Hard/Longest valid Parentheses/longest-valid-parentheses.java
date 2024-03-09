//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        
        int n=S.length(),max=0;
        
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        
        for(int i=0;i<n;i++)
        {
            if(S.charAt(i)=='(')
            {
                stack.push(i);
            }
            else
            {
                stack.pop();
                
                if(stack.empty())
                {
                    stack.push(i);
                }
                else
                {
                    int len=i-stack.peek();
                    max=Math.max(max,len);
                }
            }
        }
        
        return max;
    }
}