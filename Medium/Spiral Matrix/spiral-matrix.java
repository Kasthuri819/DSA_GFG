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
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int a[][], int n, int m, int k)
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