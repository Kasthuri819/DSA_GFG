//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minCandy(int n, int ratings[]) {
        
        int i=1,sum=1;
		
		while(i<n)
		{
			if(ratings[i]==ratings[i-1])
			{
				sum=sum+1;
				i++;
				continue;
			}
			
			int peak=1;
			
			while(i<n && ratings[i]>ratings[i-1])
			{
				peak++;
				sum=sum+peak;
				i++;
			}
			
			int down=1;
			
			while(i<n && ratings[i]<ratings[i-1])
			{
				sum=sum+down;
				i++;
				down++;
			}
			
			if(down>peak)
				sum=sum+(down-peak);
		}
		
		return sum;
        
    }
}
