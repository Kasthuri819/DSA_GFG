//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long arr[]=new long[n];
		  long brr[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      arr[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      brr[i]=sc.nextLong();
		  }
		  Solution ob = new Solution();
		  System.out.println(ob.check(arr,brr,n)==true?"1":"0");
		  
		  
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        if(A.length!=B.length)
            return false;
            
        HashMap<Long,Integer> hashmap=new HashMap<Long,Integer>();
        
        for(int i=0;i<N;i++)
        {
            hashmap.put(A[i],hashmap.getOrDefault(A[i],0)+1);
        }
        
        for(int j=0;j<N;j++)
        {
            if(!hashmap.containsKey(B[j]))
            {
                return false;
            }
            int count=hashmap.get(B[j]);
            if(count==0)
            {
                return false;
            }
            hashmap.put(B[j],count-1);
        }
        
        return true;
    }
}