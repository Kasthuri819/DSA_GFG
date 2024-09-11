//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class Node
{
	Node prev,next;
	int key,value;
	public Node(int _key,int _value)
	{
		key=_key;
		value=_value;
	}
}

class LRUCache {
   
    int capacity;
    Node head=new Node(0,0);
	Node tail=new Node(0,0);
	Map<Integer,Node> map=new HashMap<Integer, Node>();
   
    LRUCache(int cap) {
        
        capacity=cap;
        head.next=tail;
        tail.prev=head;
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        
        if(map.containsKey(key))
		{
			Node node=map.get(key);
			removeNode(node);
			insertNode(node);
			return node.value;
		}

		return -1;	
    }

    // Function for storing key-value pair.
    public void set(int key, int value) {
        
        if(map.containsKey(key))
		{
			removeNode(map.get(key));
		}

		if(map.size()==capacity)
		{
			removeNode(tail.prev);
		}

		insertNode(new Node(key,value));
    }
    
	private void insertNode(Node node) {
		
		map.put(node.key,node);
		node.next=head.next;
		node.next.prev=node;
		head.next=node;
		node.prev=head;
	}
	
	private void removeNode(Node node) {
		
		map.remove(node.key);
		node.prev.next=node.next;
		node.next.prev=node.prev;
		
	}
}
