//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    private static final int MOD=(int)1e9+7;
    
    static int uniquePaths(int n, int m, int[][] grid) {
        
        int prev[]=new int[m];
		
		for(int i=0;i<n;i++)
		{
			int curr[]=new int[m];
			
			for(int j=0;j<m;j++)
			{
				if(grid[i][j]==0)
				{
					curr[j]=0;
				}
				else if(i==0 && j==0)
				{
					curr[j]=1;
				}
				else
				{
					int up=0,left=0;
					if(i>0) up=prev[j];
					if(j>0) left=curr[j-1];
					
					curr[j]=(up+left)%MOD;
				}
			}
			
			prev=curr;
		}
		
		return prev[m-1];
    }
};