//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] candidates = new int[n];
            for (int i = 0; i < n; i++) candidates[i] = sc.nextInt();

            Solution obj = new Solution();
            List<List<Integer>> ans = obj.combinationSum2(candidates, k);
            Collections.sort(ans, new Comparator<List<Integer>>() {
                @Override   public int compare(List<Integer> a, List<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            System.out.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.print("]");
            }
            System.out.println(" ]");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        
        List<List<Integer>> resultList=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        
        Arrays.sort(a);
        
        solver(a,0,s,resultList,list);
        
        return resultList;
    }
    
    private static void solver(int a[],int index,int target,List<List<Integer>> resultList,
    List<Integer> list)
    {
        if(target==0)
        {
            resultList.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=index;i<a.length;i++)
        {
            if(i>index && a[i]==a[i-1]) continue;
            if(a[i]>target) break;
            
            list.add(a[i]);
            solver(a,i+1,target-a[i],resultList,list);
            list.remove(list.size()-1);
        }
    }
}