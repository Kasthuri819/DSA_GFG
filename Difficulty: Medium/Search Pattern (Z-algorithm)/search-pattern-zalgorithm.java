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
            
            if(res.size()==0)
                System.out.print("-1 ");
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        String concat=pattern+"$"+text;
		int size=concat.length();
		int Z[]=new int[size];
		
		ArrayList<Integer> result=new ArrayList<Integer>();
		
		getZArr(concat,Z);
		
		for(int i=0;i<size;i++)
		{
			if(Z[i]==pattern.length())
			{
				result.add(i-pattern.length());
			}
		}
		return result;
    }
    
    private static void getZArr(String concat, int[] z) {
		
		int left=0,right=0,n=concat.length();
		
		for(int k=1;k<n;k++)
		{
			if(k>right)
			{
				left=right=k;
				
				while(right<n && concat.charAt(right)==concat.charAt(right-left))
				{
					right++;
				}
				
				z[k]=right-left;
				right--;
			}
			else
			{				
				int k1=k-left;
				if(z[k1]<right-k+1)
				{
					z[k]=z[k1];
				}
				else
				{
					left=k;
					
					while(right<n && concat.charAt(right)==concat.charAt(right-left))
					{
						right++;
					}
					
					z[k]=right-left;
					right--;
				}
			}
		}
		
	}
}
