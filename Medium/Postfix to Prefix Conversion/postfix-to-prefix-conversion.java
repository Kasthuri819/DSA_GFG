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
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        
        Stack<String> stack=new Stack<>();
		
		for(int i=0;i<post_exp.length();i++)
		{
			char c=post_exp.charAt(i);
			
			if(isOperator(c))
			{
				String operand2=stack.pop();
				String operand1=stack.pop();
				String prefix=c+operand1+operand2;
				stack.push(prefix);
			}
			else
			{
				stack.push(Character.toString(c));
			}
		}
		
		return stack.pop();
    }
    
    private static boolean isOperator(char c) {
		
		return (c=='+'||c=='-'||c=='*'||c=='/'||c=='^');
	}
}
