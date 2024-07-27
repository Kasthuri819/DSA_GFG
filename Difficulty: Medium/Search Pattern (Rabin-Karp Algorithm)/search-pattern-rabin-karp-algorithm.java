//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private static final int d=256;
    private static final int q=101;
    
    ArrayList<Integer> search(String pattern, String text)
    {
        int n=text.length(),m=pattern.length(),p=0,t=0,h=1;
        
        ArrayList<Integer> result=new ArrayList<Integer>();
        
        for(int i=0;i<m-1;i++)
        {
            h=(h*d)%q;
        }
        
        for(int i=0;i<m;i++)
        {
            p=(p*d+pattern.charAt(i))%q;
            t=(t*d+text.charAt(i))%q;
        }
        
        for(int i=0;i<=n-m;i++)
        {
            if(p==t)
            {
                int j;
                for(j=0;j<m;j++)
                {
                    if(text.charAt(i+j)!=pattern.charAt(j))
                        break;
                }
                
                if(j==m)
                {
                    result.add(i+1);
                }
            }
            
            if(i<n-m)
            {
                t=(d*(t-text.charAt(i)*h)+text.charAt(i+m))%q;
                
                if(t<0)
                {
                    t=t+q;
                }
            }
        }
        
        return result;
    }
}