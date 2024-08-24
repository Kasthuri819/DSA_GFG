//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int solve(int n, int m, int grid[][]) {
       
       int front[][]=new int[m][m];
		int curr[][]=new int[m][m];

		for(int j1=0;j1<m;j1++)
		{
			for(int j2=0;j2<m;j2++)
			{
				if(j1==j2)
					front[j1][j2]=grid[n-1][j1];
				else
					front[j1][j2]=grid[n-1][j1]+grid[n-1][j2];
			}
		}


		for(int i=n-2;i>=0;i--)
		{
			for(int j1=0;j1<m;j1++)
			{
				for(int j2=0;j2<m;j2++)
				{
					int max=Integer.MIN_VALUE;

					for(int dj1=-1;dj1<=1;dj1++)
					{
						for(int dj2=-1;dj2<=1;dj2++)
						{
							int value;

							if(j1==j2)
								value=grid[i][j1];
							else
								value=grid[i][j1]+grid[i][j2];

							if((j1+dj1<0 || j1+dj1>=m) || (j2+dj2<0 ||j2+dj2>=m))
								value+=(int)-1e9;
							else
								value+=front[j1+dj1][j2+dj2];

							max=Math.max(max, value);
						}
					}

					curr[j1][j2]=max;
				}
			}
			
			for(int k=0;k<m;k++)
			{
				front[k]=curr[k].clone();
			}
		}
		
		return front[0][m-1];
    }
}