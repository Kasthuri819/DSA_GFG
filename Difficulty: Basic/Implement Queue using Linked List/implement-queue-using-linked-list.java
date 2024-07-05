//{ Driver Code Starts
import java.util.*;
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}

class GfG {
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
		 {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 }
	}
}





// } Driver Code Ends


/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

class MyQueue
{
    QueueNode front, rear;
    int size=0;
    
    //Function to push an element into the queue.
	void push(int a)
	{
	    QueueNode newNode=new QueueNode(a);
	    
	    if(rear==null)
	    {
	        this.front=this.rear=newNode;
	    }
	    else
	    {
	        this.rear.next=newNode;
	        this.rear=newNode;
	    }
	    this.size++;
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        if(isEmpty())
        {
            return -1;
        }
        
        int poppedData=this.front.data;
        this.front=this.front.next;
        
        if(this.front==null) this.rear=null;
        this.size--;
        return poppedData;
	}
	
	boolean isEmpty()
	{
	    return this.size==0;
	}
}




