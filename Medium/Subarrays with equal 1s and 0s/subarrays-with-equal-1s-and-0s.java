//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        Map<Integer,Integer> frequencyMap=new HashMap<>();
        
        
        int sum=0,count=0;
        
        for(int i=0;i<n;i++)
        {
            sum+=arr[i]==0?-1:1;
            
            if(sum==0)
                count++;
            
            if(frequencyMap.containsKey(sum))
            {
                count+=frequencyMap.get(sum);
            }
            frequencyMap.put(sum,frequencyMap.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}


