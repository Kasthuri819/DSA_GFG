//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        ArrayList<String> result=new ArrayList<>();
        char charArray[]=S.toCharArray();
        ArrayList<Character> ds=new ArrayList<>();
        boolean frequency[]=new boolean[S.length()];
        
        recurPermutation(charArray,ds,frequency,result);
        Collections.sort(result);
        
        return result;
    }
    
    static void recurPermutation(char charArray[],ArrayList<Character> ds,boolean[] frequency,ArrayList<String> result)
    {
        if(ds.size()==charArray.length)
        {
            StringBuilder sb=new StringBuilder();
            for(char ch:ds)
            {
                sb.append(ch);
            }
           result.add(sb.toString());
           return;
        }
        
        for(int i=0;i<charArray.length;i++)
        {
            if(!frequency[i])
            {
                frequency[i]=true;
                ds.add(charArray[i]);
                recurPermutation(charArray,ds,frequency,result);
                ds.remove(ds.size()-1);
                frequency[i]=false;
            }
        }
    }
}
