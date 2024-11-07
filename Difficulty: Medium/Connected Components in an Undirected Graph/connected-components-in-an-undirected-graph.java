//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(s[j]);
            }
        }

        return mat;
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (ArrayList<Integer> a : m) {
            for (int e : a) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int e = Integer.parseInt(br.readLine());
            int v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.connectedcomponents(v, edges);
            Collections.sort(res, (a, b) -> Integer.compare(a.get(0), b.get(0)));
            IntMatrix.print(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjl=adj(v,edges);
        boolean[] visit=new boolean[v];
        for(int i=0;i<v;i++)
        {
            TreeSet<Integer> abc=new TreeSet<>();
            if(!visit[i])
            {
                dfs(i,adjl,visit,abc);
                ans.add(new ArrayList<>(abc));
            }
        }
        return ans;
        
    }
    public ArrayList<ArrayList<Integer>> adj(int v,int[][] edges)
    {
        ArrayList<ArrayList<Integer>> adjl=new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            adjl.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            adjl.get(a).add(b);
            adjl.get(b).add(a);
        }
        return adjl;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adjl,boolean[] visit, TreeSet<Integer> abc)
    {
        visit[node]=true;
        abc.add(node);
        for(int i:adjl.get(node))
        {
            if(!visit[i])
            {
                dfs(i,adjl,visit,abc);
            }
        }
    
    }
}