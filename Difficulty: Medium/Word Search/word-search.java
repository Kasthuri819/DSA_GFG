//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        int rows=board.length,cols=board[0].length;

		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(word.charAt(0)== board[i][j])
				{
					if(dfs(board,word,i,j,0))
					{
						return true;
					}
				}
			}
		}

		return false;
    }
    
    private static boolean dfs(char[][] board, String word, int i, int j, int index) {

		if(index==word.length())
		{
			return true;
		}

		if(i<0 || i>=board.length || j<0 || j>=board[0].length || 
		word.charAt(index)!=board[i][j])
		{
			return false;
		}

		char temp=board[i][j];
		board[i][j]='#';

		boolean found=dfs(board, word, i+1, j, index+1)||
				dfs(board, word, i-1, j, index+1)||
				dfs(board, word, i, j-1, index+1)||
				dfs(board, word, i, j+1, index+1);

		board[i][j]=temp;

		return found;
	}
}