//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job jobs[], int n)
    {
        Arrays.sort(jobs,(a,b)->b.profit-a.profit);
		
		int maxDeadLine=0;
		
		for(Job job:jobs)
		{
			if(job.deadline>maxDeadLine)
			{
				maxDeadLine=job.deadline;
			}
		}
		
		int timeSlot[]=new int[maxDeadLine+1],jobCount=0,totalProfit=0;
		
		Arrays.fill(timeSlot,-1);
		
		for(Job job:jobs)
		{
			for(int i=job.deadline;i>0;i--)
			{
				if(timeSlot[i]==-1)
				{
					timeSlot[i]=job.id;
					totalProfit+=job.profit;
					jobCount++;
					break;
				}
			}
		}
		
		return new int[] {jobCount,totalProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/