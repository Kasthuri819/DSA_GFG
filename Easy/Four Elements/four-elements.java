//{ Driver Code Starts
import java.util.Arrays;
import java.util.Scanner;
class FindFourElements
{
	
    public static void main(String[] args) 
    {
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
			FindFourElements findfour = new FindFourElements();
			int n=sc.nextInt();
			int[] A=new int[n];
			for(int i=0;i<n;i++)
				A[i]=sc.nextInt();
			int X =sc.nextInt();
			
			Compute ob = new Compute();
		    System.out.println(ob.find4Numbers(A, n, X)?1:0);
		}
    }
}


// } Driver Code Ends


class Compute
{
    boolean find4Numbers(int nums[], int n, int target) 
    {
		Arrays.sort(nums);
		for(int i=0;i<n;i++)
		{
			if(i!=0 && nums[i]==nums[i-1]) continue;
			for(int j=i+1;j<n;j++)
			{
				if(j!=i+1 && nums[j]==nums[j-1]) continue;
				int k=j+1,l=n-1;
				while(k<l)
				{
					long sum=nums[i]+nums[j];
					sum+=nums[k]+nums[l];
					
					if(sum<target)
					{
						k++;
					}
					else if(sum>target)
					{
						l--;
					}
					else
					{
					
						k++;
						l--;
						
						while(k<l && nums[k]==nums[k-1]) k++;
						while(k<l && nums[l]==nums[l+1]) l--;
						return true;
					}
				}
			}
		}
		
		return false;
		
    }
}