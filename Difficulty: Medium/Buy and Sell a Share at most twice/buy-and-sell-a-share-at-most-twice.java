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
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine().trim());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] prices) {
        
        int front[]=new int[5];
		
		int profit=Integer.MIN_VALUE;
		
		for(int index=n-1;index>=0;index--)
		{
			int curr[]=new int[5];
			for(int transaction=0;transaction<4;transaction++)
			{
				if(transaction%2==0)
				{
					profit=Math.max(0+front[transaction],-prices[index]+front[transaction+1]);
				}
				else
				{
					profit=Math.max(0+front[transaction],prices[index]+front[transaction+1]);
				}
				
				curr[transaction]=profit;
			}
			
			front=curr;
		}
		
		return front[0];
    }
}
        