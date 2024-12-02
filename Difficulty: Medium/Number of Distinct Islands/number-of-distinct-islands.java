//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    void dfs(int row,int col,int[][] grid,boolean[][] visit ,ArrayList<String> arr,int row0,int col0)
    {
        visit[row][col]=true;
        arr.add(toString(row-row0,col-col0));
        int n=grid.length;
        int m=grid[0].length;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,-1,0,1};
        for(int i=0;i<4;i++)
        {
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && !visit[nrow][ncol])
            {
                dfs(nrow,ncol,grid,visit,arr,row0,col0);
            }
        }
    }
    String toString(int r,int c)
    {
        return Integer.toString(r)+" "+Integer.toString(c);
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<ArrayList<String>> set=new HashSet<>();
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visit=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && !visit[i][j])
                {
                    ArrayList<String> arr=new ArrayList<>();
                    dfs(i,j,grid,visit,arr,i,j);
                    set.add(arr);
                }
            }
        }
        return set.size();
    }
}


























