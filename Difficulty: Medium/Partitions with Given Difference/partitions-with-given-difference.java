//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    
    private static final int MOD=(int)1e9+7;
    
    public static int countPartitions(int n, int d, int[] arr) {
        
        int totalSum=0;
		
		for(int i=0;i<n;i++)
		{
			totalSum+=arr[i];
		}
		
		if((totalSum-d)<0 || (totalSum-d)%2==1) return 0;
		
		return countPartitionsSpaceOptimized(arr,n,(totalSum-d)/2);
    }
    
    private static int countPartitionsSpaceOptimized(int[] arr, int n, int target) {
		
		int prev[]=new int[target+1];
		int curr[]=new int[target+1];
		
		if(arr[0]==0)
			prev[0]=2;
		else
			prev[0]=1;
		
		if(arr[0]!=0 && arr[0]<=target) prev[arr[0]]=1;
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=target;j++)
			{
				int notTaken=prev[j];
				int taken=0;
				
				if(arr[i]<=j)
				{
					taken=prev[j-arr[i]];
				}
				
				curr[j]=(taken+notTaken)%MOD;
			}
			prev=curr.clone();
		}
		return prev[target];
	}
}
        
