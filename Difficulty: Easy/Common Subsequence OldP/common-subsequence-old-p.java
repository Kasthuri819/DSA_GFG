//{ Driver Code Starts
// Initial template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[]=new String[2];
            s = read.readLine().split(" ");
            Solution ob = new Solution();

            System.out.println(ob.commonSubseq(s[0], s[1]));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function template for Java
class Solution {
    static int commonSubseq(String S1, String S2){
        
        int n1=S1.length(),n2=S2.length();
        
        int dp[][]=new int[n1+1][n2+1];
        
        for(int i=1;i<=n1;i++)
		{
			for(int j=1;j<=n2;j++)
			{
				if(S1.charAt(i-1)==S2.charAt(j-1))
				{
					dp[i][j]=1+dp[i][j-1]+dp[i-1][j];
				}
				else
				{
					dp[i][j]=dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1];
				}
			}
		}
		
		return dp[n1][n2]==0?0:1;
    }
}