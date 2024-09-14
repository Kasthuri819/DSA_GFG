//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
        int capacity=sc.nextInt();
        LFUCache obj = new LFUCache(capacity);
        int runs=sc.nextInt();
        for(int i = 0;i<runs;i++){
            int s=sc.nextInt();
            if(s==1){
                int key=sc.nextInt();
                int param_1 = obj.get(key);
                System.out.println(param_1);
            }else{
                int key=sc.nextInt(),value=sc.nextInt();
                obj.put(key,value);
            }
        }
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class LFUCache {
    
    private class Node
	{
		int key,value,freq;
		Node next,prev;

		Node(int key,int value)
		{
			this.key=key;
			this.value=value;
			this.freq=1;
		}
	}
	
	private class DoublyLinkedList
	{
		Node head,tail;

		DoublyLinkedList()
		{
			head=new Node(0,0);
			tail=new Node(0,0);
			head.next=tail;
			tail.prev=head;
		}

		public void addNode(Node node)
		{
			node.next=head.next;
			node.prev=head;
			head.next.prev=node;
			head.next=node;
		}

		public void removeNode(Node node)
		{
			node.prev.next=node.next;
			node.next.prev=node.prev;
		}

		public Node removeLast(Node node)
		{
			if(tail.prev==head) return null;

			Node last=tail.prev;
			removeNode(last);

			return last;
		}

		public boolean isEmpty()
		{
			return head.next==tail;
		}

	}
    
    int capacity,size,minFreq;
	Map<Integer,Node> cache;
	Map<Integer,DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        
        this.capacity=capacity;
		this.size=0;
		this.minFreq=0;
		this.cache=new HashMap<Integer, LFUCache.Node>();
		this.freqMap=new HashMap<Integer, LFUCache.DoublyLinkedList>();
        
    }
    
    public int get(int key) {
        
        if(!cache.containsKey(key)) return -1;

		Node node=cache.get(key);
		updateFreq(node);
		return node.value;
        
    }
    
    public void put(int key, int value) {
        
        if(capacity==0) return;

		if(cache.containsKey(key))
		{
			Node node=cache.get(key);
			node.value=value;
			updateFreq(node);
		}
		else
		{
			if(size==capacity)
			{
				DoublyLinkedList doublyLinkedList = freqMap.get(minFreq);
				Node evictNode = doublyLinkedList.removeLast(new Node(key,value));
				cache.remove(evictNode.key);
				size--;
			}

			Node newNode=new Node(key,value);
			cache.put(key,newNode);
			minFreq=1;
			freqMap.computeIfAbsent(1,k -> new DoublyLinkedList()).addNode(newNode);
			size++;
		}
        
    }
    
    public void updateFreq(Node node)
	{
		int currFreq=node.freq;
		DoublyLinkedList list = freqMap.get(currFreq);
		list.removeNode(node);

		if(minFreq==currFreq && list.isEmpty())
		{
			minFreq++;
		}

		node.freq++;
		freqMap.computeIfAbsent(node.freq,k-> new DoublyLinkedList()).addNode(node);
	}
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */