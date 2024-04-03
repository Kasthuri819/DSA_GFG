//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int wildCard(String pattern, String str)
    {
        return wildCardMatching(pattern,str)==1?1:0;
    }
    
    static int wildCardMatching(String pattern,String str)
    {
        int m=pattern.length(),n=str.length();
        
        int dp[][]=new int[m][n];
        
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        
        return wildCardMatchingUtils(pattern,str,m-1,n-1,dp);
    }
    
    static int wildCardMatchingUtils(String pattern,String str,int i,int j,int dp[][])
    {
        if (i < 0 && j < 0) {
        return 1;
    }
    if (i < 0) {
        return 0;
    }
    if (j < 0) {
        return isAllStars(pattern, i) ? 1 : 0;
    }

    if (dp[i][j] != -1) {
        return dp[i][j];
    }

    if (pattern.charAt(i) == str.charAt(j) || pattern.charAt(i) == '?') {
        return dp[i][j] = wildCardMatchingUtils(pattern, str, i - 1, j - 1, dp);
    } else if (pattern.charAt(i) == '*') {
        return dp[i][j] = (wildCardMatchingUtils(pattern, str, i - 1, j, dp) == 1 ||
                wildCardMatchingUtils(pattern, str, i, j - 1, dp) == 1) ? 1 : 0;
    } else {
        return 0;
    }
    }
    
    static boolean isAllStars(String pattern,int i)
    {
        for (int it = i; it >= 0; it--) {
            
            if (pattern.charAt(it) != '*') 
            {
                return false;
                
            }
        }
         return true;
    }
}
