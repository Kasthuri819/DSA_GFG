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
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[] a = new int[n], b = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = new Solution().findSum(a, b);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    ArrayList<Integer> findSum(int a[], int b[]) {
        
        int n=a.length,m=b.length,carry=0;
        int i=n-1,j=m-1;
        
        ArrayList<Integer> al=new ArrayList<>();
        
        while(i>=0 || j>=0)
        {
            int A=0,B=0;
            if(i>=0)
                A=a[i--];
            if(j>=0)
                B=b[j--];
                
            int sum=A+B+carry;
            al.add(sum%10);
            carry=sum/10;
        }
        
        if(carry>0)
            al.add(carry);
            
        Collections.reverse(al);
        return al;
    }
}