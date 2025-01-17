//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    
    public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visit,boolean[] pathV)
    {
        visit[node]=true;
        pathV[node]=true;
        for(int i:adj.get(node))
        {
            if(!visit[i])
            {
                if(dfs(i,adj,visit,pathV)) return true;
            }
            else if(pathV[i]) return true;
        }
        pathV[node]=false;
        return false;
    }    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visit=new boolean[V];
        boolean[] pathV=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visit[i])
            {
                if(dfs(i,adj,visit,pathV)) return true;
            }
        }
        return false;
    }
}