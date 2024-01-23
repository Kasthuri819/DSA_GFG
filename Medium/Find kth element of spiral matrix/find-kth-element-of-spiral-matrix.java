//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int a[][], int n, int m, int k)
    {
        int left=0,right=m-1,top=0,bottom=n-1,count=0,ans=0;
	    
	    while(count!=k)
	    {
	        for(int i=left;i<=right && count!=k;i++)
	        {
	            ans=a[top][i];
	            count++;
	        }
	        
	        top++;
	        for(int i=top;i<=bottom && count!=k;i++)
	        {
	            ans=a[i][right];
	            count++;
	        }
	        
	        right--;
	        
	        if(top<=bottom)
	        {
    	        for(int i=right;i>=left && count!=k;i--)
    	        {
    	            ans=a[bottom][i];
    	            count++;
    	        }
    	        bottom--;
	        }
	        
	        if(left<=right)
	        {
    	        for(int i=bottom;i>=top && count!=k;i--)
    	        {
    	            ans=a[i][left];
    	            count++;
    	        }
    	        left++;
	        }
	        
	    }
	    
	    return ans;
    }
}