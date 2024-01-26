//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest3Sum(int Arr[], int N, int X)
    {
        Arrays.sort(Arr);

        int closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1, right = N - 1;

            while (left < right) {
                int currentSum = Arr[i] + Arr[left] + Arr[right];

                if (Math.abs(X - currentSum) < Math.abs(X - closestSum) || (Math.abs(X - currentSum) == Math.abs(X - closestSum) && currentSum > closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum < X) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}