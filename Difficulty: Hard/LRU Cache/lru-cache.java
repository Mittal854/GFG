//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key,int value)
    {
        this.key=key;
        this.value=value;
        prev=null;
        next=null;
    }
}

class LRUCache {
    static HashMap<Integer,Node>map;
    static int capacity;
    static Node head;
    static Node tail;
    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        // code here
        this.capacity=cap;
        this.map=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        // your code here
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        deleteNode(node);
        insertNode(node);
        return node.value;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        // your code here
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            node.value=value;
            deleteNode(node);
            insertNode(node);
        }
        else{
        if(map.size()==capacity)
        {
            Node temp=tail.prev;
            map.remove(temp.key);
            deleteNode(temp);
        }
        Node newNode=new Node(key,value);
        map.put(key,newNode);
        insertNode(newNode);
        }
    }
    public static void deleteNode(Node node)
    {
        node.prev.next=node.next;
        node.next.prev=node.prev;
        
    }
    public static void insertNode(Node node)
    {
        node.next=head.next;
        node.next.prev=node;
        node.prev=head;
        head.next=node;
        
    }
}
