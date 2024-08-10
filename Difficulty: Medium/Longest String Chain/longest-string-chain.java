//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    static FastReader sc=new FastReader(System.in);
    public static void main(String args[]) throws IOException{
       
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            String []arr=new String[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.next();
            }
            Solution obj=new Solution();
            int res=obj.longestChain(N, arr);
            System.out.println(res);
        }
    }
   static class FastReader{
 
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is) {
            in = is;
        }
 
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
   
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int longestChain(int n, String words[]){
     
     int dp[]=new int[n],max=1;

		Arrays.fill(dp,1);

		Arrays.sort(words,(s1,s2)-> s1.length()-s2.length());

		for(int index=0;index<n;index++)
		{
			for(int prevIndex=0;prevIndex<index;prevIndex++)
			{
				if(checkPossible(words[index],words[prevIndex]) && 1+dp[prevIndex]>dp[index])
				{
					dp[index]=1+dp[prevIndex];
				}
			}

			if (dp[index] > max) {

				max = dp[index];

			}
		}

		return max;
    }
    
    private static boolean checkPossible(String string1, String string2) {

		if(string1.length()!=string2.length()+1) return false;

		int first=0,second=0;

		while(first<string1.length())
		{
			if(second < string2.length() && string1.charAt(first)==string2.charAt(second))
			{
				first++;
				second++;
			}
			else
			{
				first++;
			}
		}
		return first==string1.length() && second==string2.length();
	}
}