//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            String S1 = input_line[0];
            String S2 = input_line[1];
            Solution ob = new Solution();
            System.out.println(ob.merge(S1,S2));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String merge(String S1, String S2)
    { 
        int left=0,right=0,s1Length=S1.length(),s2Length=S2.length();
        String str="";
        
        while(left < s1Length && right < s2Length)
        {
            str+=S1.charAt(left);
            str+=S2.charAt(right);
            left++;
            right++;
        }
        
        while(left < s1Length)
        {
            str+=S1.charAt(left);
            left++;
        }
        
        while(right < s2Length)
        {
            str+=S2.charAt(right);
            right++;
        }
        
        return str;
    }
} 
