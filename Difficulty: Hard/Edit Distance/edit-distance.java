//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        
        int m=s.length(),n=t.length();
        
        int prev[]=new int[n+1];
        int curr[]=new int[n+1];
        
        for(int j=0;j<=n;j++)
        {
            prev[j]=j;
        }
        
        for(int i=1;i<=m;i++)
        {
            curr[0]=i;
            
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    curr[j]=prev[j-1];
                }
                else
                {
                    curr[j]=1+Math.min(prev[j],Math.min(curr[j-1],prev[j-1]));
                }
            }
            
            prev=curr.clone();
        }
        
        return prev[n];
    }
}