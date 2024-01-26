//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int target = sc.nextInt();
        	int[] array = new int[n];
        	for(int i=0; i<n; i++)
        		array[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.threeSumClosest(array,target));
            t--;
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int threeSumClosest(int[] Arr, int X)  
	{ 
	    int N=Arr.length;
        Arrays.sort(Arr);

        int closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1, right = N - 1;

            while (left < right) {
                int currentSum = Arr[i] + Arr[left] + Arr[right];

                if (Math.abs(X - currentSum) < Math.abs(X - closestSum) || (Math.abs(X - currentSum) == Math.abs(X - closestSum) && currentSum > closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum < X) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
	} 
} 
