//{ Driver Code Starts
// //Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());//testcases
        
        while(t-- > 0)
        {
            //input a number n
            long n = Long.parseLong(read.readLine());
            
            
            // if n is less than equal to zero then 
            //it can't be a power of 2 so we print No
            if(new Solution().isPowerofTwo(n) == true)
              System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        
        if(n==1)
            return true;
            
        long low=1,high=n;
            
        while(low<=high)
        {
            long mid=(low+high)/2;
            
            if(Math.pow(2,mid)==n)
            {
                return true;
            }
            if(Math.pow(2,mid)>n)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        
        
        return false;
        
    }
    
}