//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    static class Meeting
	{
		int start,end;
		
		Meeting(int start,int end)
		{
			this.start=start;
			this.end=end;
		}
	}
    public int maxMeetings(int n, int start[], int end[]) {
        
        List<Meeting> meetings=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			meetings.add(new Meeting(start[i],end[i]));
		}
		
		Collections.sort(meetings,(m1,m2)->m1.end-m2.end);
		
		int count=1;
		int lastEndTime=meetings.get(0).end;
		
		for(int i=1;i<n;i++)
		{
			if(meetings.get(i).start>lastEndTime)
			{
				count++;
				lastEndTime=meetings.get(i).end;
			}
		}
		
		return count;
    }
}
