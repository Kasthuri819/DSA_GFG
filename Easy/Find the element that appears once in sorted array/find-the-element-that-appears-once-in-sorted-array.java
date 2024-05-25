//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        int left=0,right=n-1;
        
        while(left<right)
        {
            int mid=left+(right-left)/2;
            
            if(mid%2==1) mid--;
            
            if(arr[mid]==arr[mid+1])
            {
                left=mid+2;
            }
            else
            {
                right=mid;
            }
        }
        
        return arr[left];
    }
}