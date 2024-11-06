//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u); // Added this line to make the graph undirected
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(adj);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n=adj.size();
        boolean visited []=new boolean[n];
        ArrayList<Integer> arr=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty())
        {
            Integer v=q.poll();
            arr.add(v);
            for(Integer a:adj.get(v))
            {
                if(!visited[a])
                {
                    visited[a]=true;
                    q.add(a);
                }
            }
            
        }
        return arr;
    }
}