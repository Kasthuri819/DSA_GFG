//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    private static final String[] KEYPAD= {
			"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
	};
	
    static ArrayList <String> possibleWords(int a[], int N)
    {
        return phoneDigits(N,a);  
    }
    
    private static ArrayList <String> phoneDigits(int n, int[] a) {
		
		ArrayList <String> result=new ArrayList<>();
		
		if(n==0)
		{
			return result;
		}
		
		backTrack(n,a,0,new StringBuilder(),result);
		
		return result;		
	}

	private static void backTrack(int n, int[] a, int index, StringBuilder current, ArrayList <String> result) {

		if(index==n)
		{
			result.add(current.toString());
			return;
		}
		
		String letters=KEYPAD[a[index]];
		
		for(char letter:letters.toCharArray())
		{
			current.append(letter);
			backTrack(n, a, index+1, current, result);
			current.deleteCharAt(current.length()-1);
		}
	}
}


