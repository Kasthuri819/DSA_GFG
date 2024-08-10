//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> res = obj.LargestSubset(N, arr);
            int isValidSeq = 1, sz = res.size();
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    if ((res.get(i) % res.get(j) == 0) ||
                        (res.get(j) % res.get(i) == 0))
                        continue;
                    else {
                        isValidSeq = 0;
                        break;
                    }
                }
            }
            System.out.println(isValidSeq + " " + sz);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> LargestSubset(int n, int[] arr) {
        
        int dp[]=new int[n],hash[]=new int[n];
		
		Arrays.fill(dp,1);
		Arrays.fill(hash,1);
		
		Arrays.sort(arr);
		
		for(int index=0;index<n;index++)
		{
			hash[index]=index;
			
			for(int prevIndex=0;prevIndex<=index-1;prevIndex++)
			{
				if(arr[index]%arr[prevIndex]==0 && 1+dp[prevIndex]>dp[index])
				{
					dp[index]=1+dp[prevIndex];
					hash[index]=prevIndex;
				}
			}
		}
		
		int ans=-1,lastIndex=-1;
		
		for(int i=0;i<n;i++)
		{
			if(dp[i]>ans)
			{
				ans=dp[i];
				lastIndex=i;
			}
		}
		
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		resultList.add(arr[lastIndex]);
		
		while(hash[lastIndex]!=lastIndex)
		{
			lastIndex=hash[lastIndex];
			resultList.add(arr[lastIndex]);
		}
		
		return resultList;
    }
}
