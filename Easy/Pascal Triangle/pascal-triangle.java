//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        
        ArrayList<Long> ans=new ArrayList<>();
        
        for(int col=1;col<=n;col++)
        {
            ans.add(generateCoefficient(n-1,col-1));
        }
        
        return ans;
    }
    
    static long generateCoefficient(int n, int r) {
        final int MOD = 1000000007;

        if (r > n - r) {
            r = n - r;
        }

        long res = 1;

        for (int i = 0; i < r; i++) {
            res = (res * (n - i)) % MOD;
            res = (res * modInverse(i + 1, MOD)) % MOD;
        }

        return res;
    }
    
    static long modInverse(long a, long m) {
        long m0 = m;
        long y = 0, x = 1;

        while (a > 1) {
            long q = a / m;
            long t = m;

            m = a % m;
            a = t;
            t = y;

            y = x - q * y;
            x = t;
        }

        return (x < 0) ? (x + m0) : x;
    }
}