//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        
        return ratInMazeOptimal(mat);
    }
    
    private static ArrayList<String> ratInMazeOptimal(int[][] mat) {

		ArrayList<String> result=new ArrayList<String>();
		int n=mat.length;
		int visited[][]=new int[n][n];
		
		if(mat[0][0]==0 || mat[n-1][n-1]==0) return result;
		
		int di[]=new int[] {1,0,0,-1};
		int dj[]=new int[] {0,-1,1,0};
		
		solveOptimal(0,0,mat,n,result,"",visited,di,dj);
		
		return result;
	}
    
    private static void solveOptimal(int i, int j, int[][] mat, int n, ArrayList<String> result, String move,
			int[][] visited, int[] di, int[] dj) {

		if(i==n-1 && j==n-1)
		{
			result.add(move);
			return;
		}
		
		String dir="DLRU";
		
		for(int index=0;index<4;index++)
		{
			int nexti=i+di[index];
			int nextj=j+dj[index];
			
			if(nexti>=0 && nextj>=0 && nexti<n && nextj<n && 
					visited[nexti][nextj]==0 && mat[nexti][nextj]==1)
			{
				visited[i][j]=1;
				solveOptimal(nexti,nextj, mat,n, result, move+dir.charAt(index), visited, di, dj);
				visited[i][j]=0;
			}
		}
		
	}
}