//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
    static int longestSubsequence(int n, int a[]) {
        
        List<Integer> temp=new ArrayList<Integer>();
        temp.add(a[0]);
        
        int len=1;
        
        for(int i=1;i<n;i++)
        {
            if(a[i]>temp.get(temp.size()-1))
            {
                temp.add(a[i]);
                len++;
            }
            else
            {
                int index=Collections.binarySearch(temp,a[i]);
                
                if(index<0)
                {
                    index=-index-1;
                }
                
                temp.set(index,a[i]);
            }
        }
        
        return len;
    }
}