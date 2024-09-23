//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        for (int tc = 0; tc < t; tc++) {
            String[] greedStr = sc.nextLine().split(" ");
            String[] cookieStr = sc.nextLine().split(" ");

            int[] greed = Arrays.stream(greedStr).mapToInt(Integer::parseInt).toArray();
            int[] cookie =
                Arrays.stream(cookieStr).mapToInt(Integer::parseInt).toArray();

            Solution obj = new Solution();
            System.out.println(obj.maxChildren(greed, cookie));
        }
        sc.close();
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static int maxChildren(int greed[], int cookies[]) {
    
        int l=0,r=0,n=greed.length,m=cookies.length;
		
		Arrays.sort(greed);
		Arrays.sort(cookies);
		
		while(l<m && r<n)
		{
			if(cookies[l]>=greed[r])
			{
				r++;
			}
			l++;
		}
		
		return r;
  }
}
     