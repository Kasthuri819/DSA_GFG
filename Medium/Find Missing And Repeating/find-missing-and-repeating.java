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
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int N) {
        
        long n=N;
       long sn1 = (n * (n + 1)) / 2;
        long sn2 = (n * (n + 1) * (2 * n + 1)) / 6;
        long sn3 = 0, sn4 = 0;
        
        for (int i = 0; i < n; i++) {
            sn3 += arr[i];
            sn4 += (long) arr[i] * (long) arr[i];
        }
        
        long value1 = sn3 - sn1;
        long value2 = sn4 - sn2;
        
        value2 = value2 / value1;
        
        int x = (int) ((value1 + value2) / 2);
        int y = (int) (x - value1);
        
        return new int[]{x, y};
    }
}