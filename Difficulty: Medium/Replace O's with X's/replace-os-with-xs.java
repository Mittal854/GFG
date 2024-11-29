//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public static void dfs(int row,int col,char[][] a,boolean[][] visit)
    {
        visit[row][col]=true;
        int[] delRow={1,0,-1,0};
        int[] delCol={0,1,0,-1};
        int n=a.length;
        int m=a[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 &&nrow<n&&ncol>=0 && ncol<m && a[nrow][ncol]=='O' &&!visit[nrow][ncol])
            {
                dfs(nrow,ncol,a,visit);
            }
        }
        
    }
    
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        boolean[][] visit=new boolean[n][m];
        for(int j=0;j<m;j++)
        {
            if(a[0][j]=='O')
            {
                dfs(0,j,a,visit);
            }
            if(a[n-1][j]=='O')
            {
                dfs(n-1,j,a,visit);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(a[i][0]=='O')
            {
                dfs(i,0,a,visit);
            }
            if(a[i][m-1]=='O')
            {
                dfs(i,m-1,a,visit);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]=='O' && !visit[i][j])
                {
                    a[i][j]='X';
                }
            }
        }
        return a;
    }
}