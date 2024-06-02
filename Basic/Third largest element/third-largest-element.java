//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class ThirdLargestElement
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n =sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			Solution g = new Solution();
			System.out.println(g.thirdLargest(arr,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int thirdLargest(int a[], int n)
    {
	    int firstLargest=Integer.MIN_VALUE,secondLargest=Integer.MIN_VALUE,thirdLargest=Integer.MIN_VALUE;
	    
	    for(int i=0;i<n;i++)
	    {
	        if(a[i]>firstLargest)
	        {
	            thirdLargest=secondLargest;
	            secondLargest=firstLargest;
	            firstLargest=a[i];
	        }
	        else if(a[i]>secondLargest && a[i]!=firstLargest)
	        {
	            thirdLargest=secondLargest;
	            secondLargest=a[i];
	        }
	        else if(a[i]>thirdLargest && a[i]!=secondLargest)
	        {
	            thirdLargest=a[i];
	        }
	    }
	    
	    return thirdLargest;
    }
}
