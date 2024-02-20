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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        
        Arrays.sort(arr);
        String str1=arr[0];
        String str2=arr[n-1];
        String result="";
        
        for(int i=0;i<str1.length();i++)
        {
            if(str1.charAt(i)==str2.charAt(i))
            {
                result+=str1.charAt(i);
            }
            else
            {
                break;
            }
        }
        
        if(result=="")
        {
            return "-1";
        }
        else
        {
            return result;
        }
    }
}