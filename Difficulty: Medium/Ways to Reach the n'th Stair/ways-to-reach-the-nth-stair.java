//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    
    private static final int MOD=(int)1e9+7;
    
    int countWays(int n)
    {
        
       int prev1=1,prev2=1;
		
		for(int i=2;i<=n;i++)
		{
			int curr=(prev1+prev2)%MOD;
			prev1=prev2;
			prev2=curr;
		}
		
		return prev2;
    }
}

