//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        
        if(in==null || post==null || in.length!=post.length) return null;
        
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<in.length;i++)
        {
            map.put(in[i],i);
        }
        
        return buildTreePostIn(in,0,in.length-1,post,0,post.length-1,map);
    }
    
    private Node buildTreePostIn(int in[],int is,int ie,int post[],int ps,int pe,Map<Integer,Integer> map)
    {
        if(is>ie || ps>pe) return null;
        
        int inRoot=map.get(post[pe]);
        int numsLeft=inRoot-is;
        
        Node root=new Node(post[pe]);
        root.left=buildTreePostIn(in,is,inRoot-1,post,ps,ps+numsLeft-1,map);
        root.right=buildTreePostIn(in,inRoot+1,ie,post,ps+numsLeft,pe-1,map);
        
        return root;
    }
}
