//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);

            int arr[] = new int[n];
            int dep[] = new int[n];

            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) dep[i] = Integer.parseInt(str[i]);

            System.out.println(new Solution().findPlatform(arr, dep));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i=0,j=0,n=arr.length;
        int platforms_needed=0,max_platforms=0;
        
        while(i<n && j<n)
        {
            if(arr[i]<=dep[j])
            {
                platforms_needed++;
                i++;
            }
            else
            {
                platforms_needed--;
                j++;
            }
            
            max_platforms=Math.max(max_platforms,platforms_needed);
        }
        
        return max_platforms;
    }
}
