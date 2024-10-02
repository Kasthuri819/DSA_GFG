//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String S;
            S = br.readLine();

            int target;
            target = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<String> res = obj.addOperators(S, target);
            Collections.sort(res);
            for (String s : res) System.out.print(s + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<String> addOperators(String s, int target) {
        
        ArrayList<String> result=new ArrayList<>();
		
		if(s==null || s.length()==0) return result;
		
		backTrack(s,target,result,"",0,0,0);
		
		return result;
    }
    
    private static void backTrack(String s, int target, ArrayList<String> result, String path, int index, long eval, long prev) {

		if(index==s.length())
		{
			if(eval==target)
			{
				result.add(path);
			}
			return;
		}
		
		for(int i=index;i<s.length();i++)
		{
			if(index!=i && s.charAt(index)=='0') break;
			String currStr=s.substring(index,i+1);
			long curr=Long.parseLong(currStr);
			
			if(index==0)
			{
				backTrack(s, target, result, path+currStr, i+1,curr,curr);
			}
			else
			{
				backTrack(s, target, result, path+"+"+currStr, i+1,eval+curr, curr);
				backTrack(s,target,result,path+"-"+currStr,i+1,eval-curr,-curr);
				backTrack(s, target, result, path+"*"+currStr, i+1, eval-prev+prev*curr,prev*curr);
			}
		}
		
	}
}
