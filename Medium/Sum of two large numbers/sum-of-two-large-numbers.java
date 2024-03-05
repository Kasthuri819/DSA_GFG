//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String x = read.readLine();
            String y = read.readLine();
            Solution ob = new Solution();
            String result = ob.findSum(x, y);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String findSum(String X, String Y) {
        
         StringBuilder str=new StringBuilder();
        int carry=0;
        int i=X.length()-1,j=Y.length()-1;
        while(i>=0 || j>=0 || carry>0){
            int dig1=i>=0 ? X.charAt(i--)-'0':0;
            int dig2=j>=0 ? Y.charAt(j--)-'0':0;
            int sum=dig1+dig2+carry;
            carry=sum/10;
            str.insert(0,sum%10);
        }
          while (str.length() > 1 && str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }
        return str.toString();
    }
}