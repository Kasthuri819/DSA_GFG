//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    ArrayList<String> permutation(String S){
       
       String current="";
       int index=0;
       ArrayList<String> result=new ArrayList<>();
       HashSet<String> set = new HashSet<>();
       generatePermutations(S,current,index,result,set);
       
       Collections.sort(result);
       return result;
    }
    
    static void generatePermutations(String S,String current,int index,ArrayList<String> result,HashSet<String> set)
    {
        if(index==S.length())
        {
            String trimmed=current.trim();
            if(!set.contains(trimmed))
            {
                result.add(trimmed);
                set.add(trimmed);
            }
            return;
        }
        
        generatePermutations(S,current+S.charAt(index)+" ",index+1,result,set);
        generatePermutations(S,current+S.charAt(index),index+1,result,set);
    }
    
}