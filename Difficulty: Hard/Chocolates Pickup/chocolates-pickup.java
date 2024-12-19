//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

   
// User function Template for Java

class Solution {
    public int solve(int n, int m, int grid[][]) {
        // Code here
        int[][][] dp=new int[n][m][m];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==j)
                {
                    dp[n-1][i][j]=grid[n-1][i];
                }
                else
                {
                    dp[n-1][i][j]=grid[n-1][i]+grid[n-1][j];
                }
            }
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<m;k++)
                {
                    int maxi=0;
                    for(int d1=-1;d1<=1;d1++)
                    {
                        for(int d2=-1;d2<=1;d2++)
                        {
                            int newC1=j+d1;
                            int newC2=k+d2;
                            if(newC1>=0 && newC2>=0 && newC1<m && newC2<m)
                            {
                                maxi=Math.max(maxi,dp[i+1][newC1][newC2]);
                            }
                        }
                    }
                    if(j==k)
                    {
                        dp[i][j][k]=grid[i][j]+maxi;
                    }
                    else
                    {
                        dp[i][j][k]=grid[i][j]+grid[i][k]+maxi;
                    }
                }
            }
        }
        return dp[0][0][m-1];
    }
}