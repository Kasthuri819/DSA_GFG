//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        int N=(int)n;
        long max=0;
        
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<=N;i++)
        {
            while(!stack.isEmpty() && (i==N||hist[stack.peek()]>=hist[i]))
            {
                long height=hist[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty())
                {
                    width=i;
                }
                else
                {
                    width=i-stack.peek()-1;
                }
                max=Math.max(max,width*height);
            }
            stack.push(i);
        }
        
        return max;
        
    }
}



