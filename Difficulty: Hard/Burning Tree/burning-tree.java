//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
       if(root==null) return 0;
		
		Map<Node,Node> parentTrack=new HashMap<>();
		
		Node targetNode=mapParents(root,parentTrack,target);
		
		if(targetNode==null) return 0;
		
		return burnTree(targetNode,parentTrack);
    }
    
    private static int burnTree(Node targetNode, Map<Node, Node> parentTrack) {

		Map<Node,Boolean> visited=new HashMap<Node, Boolean>();
		
		Queue<Node> queue=new LinkedList<Node>();
		queue.offer(targetNode);
		
		visited.put(targetNode,true);
		
		int timeToBurn=0;
		
		while(!queue.isEmpty())
		{
			int size=queue.size();
			
			boolean anyFireSpread=false;
			
			for(int i=0;i<size;i++)
			{
				Node current=queue.poll();
				
				if(current.left!=null && visited.get(current.left)==null)
				{
					anyFireSpread=true;
					queue.offer(current.left);
					visited.put(current.left,true);
				}
				
				if(current.right!=null && visited.get(current.right)==null)
				{
					anyFireSpread=true;
					queue.offer(current.right);
					visited.put(current.right,true);
				}
				
				if(parentTrack.get(current)!=null && visited.get(parentTrack.get(current))==null)
				{
					anyFireSpread=true;
					queue.offer(parentTrack.get(current));
					visited.put(parentTrack.get(current),true);
				}
			}
			
			if(anyFireSpread)
			{
				timeToBurn++;
			}		
		}
		
		return timeToBurn;
	}

	private static Node mapParents(Node root, Map<Node, Node> parentTrack, int target) {

		Queue<Node> queue=new LinkedList<>();
		
		queue.offer(root);
		
		Node targetNode=null;
		
		while(!queue.isEmpty())
		{
			Node current=queue.poll();
			
			if(current.data==target)
			{
				targetNode=current;
			}
			
			if(current.left!=null)
			{
				parentTrack.put(current.left,current);
				queue.offer(current.left);
			}
			
			if(current.right!=null)
			{
				parentTrack.put(current.right,current);
				queue.offer(current.right);
			}
			
		}
		
		
		return targetNode;
	}
}