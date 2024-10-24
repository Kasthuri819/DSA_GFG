//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        Map<Integer,Integer> inMap=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			inMap.put(inorder[i],i);
		}
		
		return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
    }
    
    private static Node buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> inMap) {

		if(preStart>preEnd || inStart>inEnd) return null;
		
		Node root=new Node(preorder[preStart]);
		int inRoot=inMap.get(root.data);
		int numsLeft=inRoot-inStart;
		
		root.left=buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
		root.right=buildTree(preorder, preStart+numsLeft+1, preEnd, inorder,inRoot+1,inEnd,inMap);
		
		return root;
	}
}
