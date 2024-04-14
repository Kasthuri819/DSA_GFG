//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().immediateSmaller(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void immediateSmaller(int arr[], int n) {
        
        int nse[]=new int[n];
        
        Stack<Integer> stack=new Stack<>();
        
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && arr[i]<=stack.peek())
            {
                stack.pop();
            }
            
            if(i<n)
            {
                if(!stack.isEmpty())
                {
                    nse[i]=stack.pop();
                }
                else
                {
                    nse[i]=-1;
                }
            }
            
            stack.push(arr[i]);
        }
        
        int index=0;
        for(int i=0;i<n;i++)
        {
            arr[index++]=nse[i];
        }
    }
}