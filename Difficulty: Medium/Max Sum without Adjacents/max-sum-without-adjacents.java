//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
       
       int prev1=arr[0],prev2=0,curr=Integer.MIN_VALUE;
						
		for(int i=1;i<n;i++)
		{
			int notTake=prev1;
			int take=arr[i];
			if(i>1)
				take+=prev2;
			
			curr=Math.max(notTake, take);
			prev2=prev1;
			prev1=curr;
		}
		
		return prev1;
    }
}