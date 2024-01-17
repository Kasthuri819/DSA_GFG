//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        
         ArrayList<Integer> subarray = new ArrayList<Integer>();

        int sum = 0, maxSum = Integer.MIN_VALUE, start = 0, begin = -1, end = -1, currentLength = 0, maxLength = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] >= 0) {
                sum += a[i];
                currentLength++;
            } else {
                sum = 0;
                start = i + 1;
                currentLength = 0;
            }

            if (sum > maxSum || (sum == maxSum && (currentLength > maxLength || (currentLength == maxLength && start < begin)))) {
                maxSum = sum;
                begin = start;
                end = i;
                maxLength = currentLength;
            }
        }

        if (begin != -1 && end != -1) {
            for (int i = begin; i <= end; i++) {
                subarray.add(a[i]);
            }
        } else {
            subarray.add(-1);
        }

        return subarray;
    }
}