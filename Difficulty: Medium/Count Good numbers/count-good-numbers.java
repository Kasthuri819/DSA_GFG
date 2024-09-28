//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            long N;
            N = Long.parseLong(br.readLine().trim());

            Solution obj = new Solution();
            int res = obj.countGoodNumbers(N);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    private static final int MOD=(int)1e9+7;
    
    public static int countGoodNumbers(long n) {
        
        long evenPosition=(n+1)/2, oddPosition=n/2;
        
        long evenDistribution=power(5,evenPosition); 
        long oddDistribution=power(4,oddPosition);
        
        return (int)((evenDistribution*oddDistribution)%MOD);
         
    }
    
    private static long power(long base,long exp)
    {
        long result=1;
        
        while(exp>0)
        {
            if((exp%2)==1)
            {
                result=(result*base)%MOD;
            }
            
            exp=exp>>1;
            base=(base*base)%MOD;
        }
        
        return result;
    }
}
