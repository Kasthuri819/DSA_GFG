//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        
        Stack<String> stack=new Stack<>();
        
        for(char c:exp.toCharArray())
        {
            if(Character.isLetterOrDigit(c))
            {
                stack.push(String.valueOf(c));
            }
            else
            {
                String operand2=stack.pop();
                String operand1=stack.pop();
                String result="("+operand1+c+operand2+")";
                stack.push(result);
            }
        }
        
        return stack.pop();
    }
}
