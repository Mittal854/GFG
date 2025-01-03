//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        head=reverse(head);
        Node temp=head;
        Node curr=new Node(-1);
        Node currS=curr;
        int carry=1;
        while(temp!=null)
        {
            int sum=temp.data+carry;
            carry=sum/10;
            sum=sum%10;
            curr.next=new Node(sum);
            curr=curr.next;
            temp=temp.next;

        }
        if(carry!=0)
        {
            curr.next=new Node(carry);
        }
        return reverse(currS.next);
        
    }
    public Node reverse(Node head)
    {
        Node prev=null;
        Node curr=head;
        Node next=head;
        while(next!=null)
        {
            curr=next;
            next=curr.next;
            curr.next=prev;
            prev=curr;
        }
        return curr;
    }
}
