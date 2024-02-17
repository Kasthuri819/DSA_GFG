//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.countRevPairs(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countRevPairs(int N, int arr[]) {
        
        return mergeSort(arr,0,N-1);
    }
    
    public static int mergeSort(int[] arr,int low,int high)
    {
        int count=0;
        
        if(low>=high)
        {
            return 0;
        }
        int mid=(low+high)/2;
        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1,high);
        count+=countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return count;
    }
    
    public static int countPairs(int[] arr,int low,int mid,int high)
    {
        int right=mid+1,count=0;
        for(int i=low;i<=mid;i++)
        {
            while(right<=high && arr[i]> (2*(long)arr[right])) right++;
            count+=(right-(mid+1));
        }
        return count;
    }
    
    public static void merge(int[] arr,int low,int mid,int high)
    {
        int left=low,right=mid+1,index=0;
        int temp[]=new int[high-low+1];
        
        while(left <= mid && right<=high)
        {
            if(arr[left] <= arr[right])
            {
                temp[index++]=arr[left++];
            }
            else
            {
                temp[index++]=arr[right++];
            }
        }
        
        while(left <= mid)
        {
            temp[index++]=arr[left++];
        }
        
        while(right <= high)
        {
            temp[index++]=arr[right++];
        }
        
        for(int t = low; t <= high; t++)
        {
            arr[t] = temp[t-low];
        }
    }
}