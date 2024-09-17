//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]),
                                  Integer.parseInt(inputLine[k++]));
            }
            System.out.println(
                String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item items[], int n) {
        
        Arrays.sort(items,new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {

				double r1=(double)o1.value/o1.weight;
				double r2=(double)o2.value/o2.weight;

				if(r1<r2) return 1;
				if(r1>r2) return -1;
				return 0;
			}
		});
		
		double totalValue=0.0;
		
		for(int i=0;i<n;i++)
		{
			if(items[i].weight<=w)
			{
				totalValue+=items[i].value;
				w-=items[i].weight;
			}
			else
			{
				totalValue+=items[i].value*((double)w/items[i].weight);
				break;
			}
		}

		return totalValue;
    }
}