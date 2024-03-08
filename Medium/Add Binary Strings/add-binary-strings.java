//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        
        char carry='0';
        StringBuilder sb=new StringBuilder();
        int i=A.length()-1;
        int j=B.length()-1;
        
        while(i>=0 || j>=0)
        {
            char tempA=i>=0?A.charAt(i):'0';
            char tempB=j>=0?B.charAt(j):'0';
            
            if(tempA==tempB)
            {
                if(carry=='0')
                {
                    sb.append("0");   
                }
                else
                {
                    sb.append("1");
                }
                carry=tempA;
            }
            else if(tempA!=tempB)
            {
                if(carry=='0')
                {
                    sb.append("1");   
                }
                else
                {
                    sb.append("0");
                    carry='1';
                }
            }
            i--;
            j--;
        }
        
        if(carry=='1')
        {
            sb.append("1");
        }
        
        
        sb.reverse();
        
        while(1<sb.length() && sb.charAt(0)=='0')
        {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}