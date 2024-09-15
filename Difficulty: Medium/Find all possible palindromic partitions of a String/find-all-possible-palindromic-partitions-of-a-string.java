//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        
        ArrayList<ArrayList<String>> result=new ArrayList<>();
		ArrayList<String> path=new ArrayList<>();
		
		allPossiblePalindromicPartitions(0,S,path,result);
		
		return result;
    }
    
    private static void allPossiblePalindromicPartitions(int index, String s, ArrayList<String> path,
			ArrayList<ArrayList<String>> result) {
		
		if(index==s.length())
		{
			result.add(new ArrayList<String>(path));
			return;
		}
		
		for(int i=index;i<s.length();i++)
		{
			if(isPalindrome(s,index,i))
			{
				path.add(s.substring(index,i+1));
				allPossiblePalindromicPartitions(i+1, s, path, result);
				path.remove(path.size()-1);
			}
		}
		
	}

	private static boolean isPalindrome(String s, int start, int end) {

		while(start<end)
		{
			if(s.charAt(start)!=s.charAt(end)) return false;
			start++;
			end--;
		}
		
		return true;
	}
};