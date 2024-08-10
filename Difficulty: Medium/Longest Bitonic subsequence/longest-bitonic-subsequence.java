//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] nums = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.LongestBitonicSequence(n, nums);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        
        int dp1[]=new int[n];
		
		Arrays.fill(dp1, 1);
		
		for(int index=0;index<n;index++)
		{
			for(int prevIndex=0;prevIndex<index;prevIndex++)
			{
				if(nums[prevIndex]<nums[index] && 1+dp1[prevIndex]>dp1[index])
				{
					dp1[index]=1+dp1[prevIndex];
				}
			}
		}
		
		int dp2[]=new int[n],max=0;
		
		Arrays.fill(dp2, 1);
		
		for(int index=n-1;index>=0;index--)
		{
			for(int prevIndex=n-1;prevIndex>index;prevIndex--)
			{
				if(nums[prevIndex]<nums[index] && 1+dp2[prevIndex]>dp2[index])
				{
					dp2[index]=1+dp2[prevIndex];
				}
			}
		}
		
		for(int i=0;i<n;i++)
		{
		    if(dp1[i]>1 && dp2[i]>1)
		        max=Math.max(max, dp1[i]+dp2[i]-1);
		}
		
		return max;
    }
}
