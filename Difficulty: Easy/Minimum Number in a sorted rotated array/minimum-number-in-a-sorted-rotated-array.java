//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }
    
}
// } Driver Code Ends


class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        int result=Integer.MAX_VALUE;
        
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            if(arr[low]<=arr[high])
            {
                result=Math.min(result,arr[low]);
                break;
            }
            if(arr[low]<=arr[mid])
            {
                result=Math.min(arr[low],result);
                low=mid+1;
            }
            else
            {
                result=Math.min(arr[mid],result);
                high=mid-1;
            }
        }
        
        return result;
    }
}