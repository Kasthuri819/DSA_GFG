//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    private static final int MOD=(int)1003;
    
    static int countWays(int n, String s){
        
        int dp[][][]=new int[n][n][2];
		
		for(int i=n-1;i>=0;i--)
		{
			for(int j=0;j<=n-1;j++)
			{
				if(i>j) continue;
				
				for(int isTrue=0;isTrue<=1;isTrue++)
				{
					if(i==j)
					{
						if(isTrue==1)
						{
							dp[i][j][isTrue]=s.charAt(i)=='T'?1:0;
						}
						else
						{
							dp[i][j][isTrue]=s.charAt(i)=='F'?1:0;
						}
						continue;
					}
					
					int ways=0;
					
					for(int ind=i+1;ind<=j-1;ind+=2)
					{
						int lt=dp[i][ind-1][1];
						int lf=dp[i][ind-1][0];
						int rt=dp[ind+1][j][1];
						int rf=dp[ind+1][j][0];
						
						char operator=s.charAt(ind);
						
						if(operator=='&')
						{
							if(isTrue==1)
								ways=(ways+(lt*rt)%MOD)%MOD;
							else
								ways=(ways+(lt*rf)%MOD+(lf*rt)%MOD+(lf*rf)%MOD)%MOD;
						}
						else if(operator=='|')
						{
							if(isTrue==1)
								ways=(ways+(lt*rt)%MOD+(lt*rf)%MOD+(lf*rt)%MOD)%MOD;
							else
								ways=(ways+(lf*rf)%MOD)%MOD;
						}
						else
						{
							if(isTrue==1)
								ways=(ways+(lt*rf)%MOD+(lf*rt)%MOD)%MOD;
							else
								ways=(ways+(lt*rt)%MOD+(lf*rf)%MOD)%MOD;
						}
						
						dp[i][j][isTrue]=ways;
					}
				}
			}
		}
		return dp[0][n-1][1];
        
    }
}