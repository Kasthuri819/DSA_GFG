//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][], int N) {
       
       return maxPoints(N,arr);
    }
    
     public static int maxPoints(int n,int[][] points) {
         
        int[] prevDay = new int[4];

        prevDay[0] = Math.max(points[0][1], points[0][2]);
        prevDay[1] = Math.max(points[0][0], points[0][2]);
        prevDay[2] = Math.max(points[0][0], points[0][1]);
        prevDay[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day <= n - 1; day++) {
            int[] currDay = new int[4];
            for (int lastActivity = 0; lastActivity < 4; lastActivity++) {
                currDay[lastActivity] = 0;
                for (int activity = 0; activity < 3; activity++) {
                    if (activity != lastActivity) {
                        int pointsToday = points[day][activity] + prevDay[activity];
                        currDay[lastActivity] = Math.max(currDay[lastActivity], pointsToday);
                    }
                }
            }
            prevDay = currDay;
        }
        return prevDay[3];
    }
}