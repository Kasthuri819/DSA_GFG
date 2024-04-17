//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        
        ArrayList<String> result=new ArrayList<>();
        char c[]=S.toCharArray();
        
        recurPermute(0,c,result);
        
        Collections.sort(result);
        
        return result;
    }
    
    public static void recurPermute(int index,char[] chars,ArrayList<String> result)
    {
        int n=chars.length;
        if(index==n)
        {
            String concat = new String(chars);
            result.add(concat);
            return;
        }
        
        Set<Character> swapped = new HashSet<>();
        for(int i=index;i<n;i++)
        {
            if (swapped.add(chars[i])) {
            swap(i,index,chars);
            recurPermute(index+1,chars,result);
            swap(i,index,chars);
            }
        }
    }
    
    public static void swap(int x,int y,char[] chars)
    {
        char temp=chars[x];
        chars[x]=chars[y];
        chars[y]=temp;
    }
}