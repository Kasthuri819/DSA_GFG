//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<S.length();i++)
        {
            if(isOperator(S.charAt(i)))
            {
                int operand2=stack.pop();
                int operand1=stack.pop();
                
                switch(S.charAt(i))
                {
                    case '+':
                        stack.push(operand1+operand2);
                        break;
                    case '-':
                        stack.push(operand1-operand2);
                        break;
                    case '*':
                        stack.push(operand1*operand2);
                        break;
                    case '/':
                        stack.push(operand1/operand2);
                        break;
                }
            }
            else
            {
                stack.push(S.charAt(i)-'0');
            }
        }
        
        return stack.pop();
    }
    
    private static boolean isOperator(char c)
    {
        return (c=='+'||c=='-'||c=='*'||c=='/');
    }
}