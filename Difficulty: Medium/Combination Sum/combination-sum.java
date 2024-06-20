//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<ArrayList<Integer>> resultList=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>(A);
        A.clear();
        A.addAll(set);
        Collections.sort(A);
        solver(A,0,B,resultList,list);
        
        return resultList;
    }
    
    private static void solver(ArrayList<Integer> A,int index,int target,
    ArrayList<ArrayList<Integer>> resultList,ArrayList<Integer> list)
    {
        if(index==A.size())
        {
            if(target==0)
            {
               resultList.add(new ArrayList<>(list)); 
            }
            
            return;
        }
        
        if(A.get(index)<=target)
        {
            list.add(A.get(index));
            solver(A,index,target-A.get(index),resultList,list);
            list.remove(list.size()-1);
        }
        
        solver(A,index+1,target,resultList,list);
    }
}