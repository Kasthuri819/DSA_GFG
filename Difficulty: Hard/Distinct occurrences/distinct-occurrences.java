//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int  subsequenceCount(String s, String t)
    {
        int m=s.length(),n=t.length();
        int MOD = 1000000007;
	    int dp[][]=new int[m+1][n+1];
	    
	    for(int i=0;i<=m;i++)
	    {
	        dp[i][0]=1;
	    }
	    
	    for(int i=1;i<=m;i++)
	    {
	        for(int j=1;j<=n;j++)
	        {
	            if(s.charAt(i-1)==t.charAt(j-1))
	            {
	                dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%MOD;
	            }
	            else
	            {
	                dp[i][j]=dp[i-1][j];
	            }
	        }
	    }
	    
	    return dp[m][n];
    }
}