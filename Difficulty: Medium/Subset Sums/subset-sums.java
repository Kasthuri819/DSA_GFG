//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        
        ArrayList<Integer> subsetSum=new ArrayList<>();
        
        solver(0,0,arr,subsetSum);
        
        Collections.sort(subsetSum);
        
        return subsetSum;
    }
    
    private static void solver(int sum,int index,ArrayList<Integer> arr,ArrayList<Integer> subsetSum)
    {
        if(index==arr.size())
        {
            subsetSum.add(sum);
            return;
        }
        
        solver(sum+arr.get(index),index+1,arr,subsetSum);
        
        solver(sum,index+1,arr,subsetSum);
    }
}