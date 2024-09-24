//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int pages[]= new int[N];
            for(int i = 0; i < N; i++)
                pages[i] = Integer.parseInt(input_line[i]);
            int C = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.pageFaults(N, C, pages));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution{
    static int pageFaults(int N, int C, int pages[]){
        
        LinkedHashSet<Integer> memory=new LinkedHashSet<Integer>(C);
		
		int pageFaults=0;
		
		for(int i=0;i<N;i++)
		{
			int currentPage=pages[i];
			
			if(memory.contains(currentPage))
			{
				memory.remove(currentPage);
				memory.add(currentPage);
			}
			else
			{
				if(memory.size()==C)
				{
					Iterator<Integer> it=memory.iterator();
					it.next();
					it.remove();
				}
				
				memory.add(currentPage);
				pageFaults++;				
			}
		}
		
		return pageFaults;
    }
}