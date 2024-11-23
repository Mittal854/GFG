//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    int dis;
    Pair(int row,int col,int dis)
    {
        this.row=row;
        this.col=col;
        this.dis=dis;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] ans=new int[n][m];
        boolean[][] visit=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    visit[i][j]=true;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int[] delRow = {-1,0,1,0};
        int[] delCol={0,-1,0,1};
        while(!q.isEmpty())
        {
            Pair a=q.poll();
            int row=a.row;
            int col=a.col;
            int dis=a.dis;
            ans[row][col]=dis;
            for(int i=0;i<4;i++)
            {
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&!visit[nrow][ncol])
                {
                    visit[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol,dis+1));
                }
            }
        }
        return ans;
    }
}