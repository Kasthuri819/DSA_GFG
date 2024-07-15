//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Integer> s;
    
    GfG()
	{
        s=new Stack<>();
        minEle=Integer.MAX_VALUE;
	}
	
    /*returns min element from stack*/
    int getMin()
    {
        if(s.isEmpty())
            return -1;
            
        return minEle;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	    if(s.isEmpty())
	        return -1;
	        
	    int val=s.peek();
	    int poppedValue;
	    
	    if(val<minEle)
	    {
	        poppedValue=minEle;
	        minEle=2*minEle-val;
	        s.pop();
	    }
	    else
	    {
	        poppedValue=val;
	        s.pop();
	    }
	        
	    return poppedValue;
    }

    /*push element x into the stack*/
    void push(int x)
    {
	    if(s.isEmpty())
	    {
	        minEle=x;
	        s.push(x);
	    }
	    else
	    {
	        if(x<minEle)
	        {
	            s.push(2*x-minEle);
	            minEle=x;
	        }
	        else
	        {
	            s.push(x);
	        }
	    }
    }	
}

