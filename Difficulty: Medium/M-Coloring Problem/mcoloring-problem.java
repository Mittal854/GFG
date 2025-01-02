//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    boolean safe(int node,ArrayList<ArrayList<Integer>>adj,int[]colors,int c)
    {
        for(int i:adj.get(node))
        {
            if(colors[i]==c)return false;
        }
        return true;
    }
    boolean solve(int node,ArrayList<ArrayList<Integer>>adj,int[] colors,int v,int m)
    {
        if(node==v) return true;
        for(int i=1;i<=m;i++)
        {
            if(safe(node,adj,colors,i)){
                colors[node]=i;
               if( solve(node+1,adj,colors,v,m))return true;
               colors[node]=0;
            }
        }
        return false;
    }
    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges)
        {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        int[] colors=new int[v];
        if(solve(0,adj,colors,v,m)) return true;
        return false;
    }
}