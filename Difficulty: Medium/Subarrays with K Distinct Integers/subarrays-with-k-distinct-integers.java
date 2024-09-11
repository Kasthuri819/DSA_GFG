//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline character

        while (t-- > 0) {
            String[] arrInput = sc.nextLine().split(" ");
            int[] arr = new int[arrInput.length];
            for (int i = 0; i < arrInput.length; i++) {
                arr[i] = Integer.parseInt(arrInput[i]);
            }

            int k = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayCount(arr, k));
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int subarrayCount(int arr[], int k) {
       
       return subarraysWithAtMostKDistinctIntegers(arr,k)-subarraysWithAtMostKDistinctIntegers(arr,k-1);

    }
    
    private static int subarraysWithAtMostKDistinctIntegers(int arr[],int k)
    {
        int left=0,right=0,count=0,n=arr.length;
        
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        
        while(right<n)
        {
            hashMap.put(arr[right],hashMap.getOrDefault(arr[right],0)+1);
            right++;
            
            while(hashMap.size()>k)
            {
                hashMap.put(arr[left],hashMap.getOrDefault(arr[left],0)-1);
                
                if(hashMap.get(arr[left])==0)
                {
                    hashMap.remove(arr[left]);
                }
                left++;
            }
            
            count+=right-left;
        }
        
        return count;
    }
}
