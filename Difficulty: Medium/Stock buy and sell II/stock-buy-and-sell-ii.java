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
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        
        int frontNotBuy=0,frontBuy=0;
		int currNotBuy,currBuy;
		
		for(int index=n-1;index>=0;index--)
		{
			currNotBuy=Math.max(0+frontNotBuy,-prices[index]+frontBuy);
			
			currBuy=Math.max(0+frontBuy,prices[index]+frontNotBuy);
			
			frontNotBuy=currNotBuy;
			frontBuy=currBuy;
		}
		
		return frontNotBuy;
    }
}
        
