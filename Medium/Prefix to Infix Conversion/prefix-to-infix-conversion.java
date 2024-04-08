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
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        
        Stack<String> stack=new Stack<>();
        
        for(int i=pre_exp.length()-1;i>=0;i--)
        {
            char c=pre_exp.charAt(i);
            
            if(isOperator(c))
            {
                String operand1=stack.pop();
                String operand2=stack.pop();
                String infix="("+operand1+c+operand2+")";
                stack.push(infix);
            }
            else
            {
                stack.push(c+"");
            }
        }
        
        return stack.pop();
    }
    
    static boolean isOperator(char c)
    {
        return (c=='+'||c=='-'||c=='*'||c=='/'||c=='^');
    }
}
