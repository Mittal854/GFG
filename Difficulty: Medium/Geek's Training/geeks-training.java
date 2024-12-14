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
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][], int N) {
        // code here
        int dp[][]=new int[N][3];
        dp[0][0]=arr[0][0];
        dp[0][1]=arr[0][1];
        dp[0][2]=arr[0][2];
        for(int i=1;i<N;i++)
        {
            dp[i][0]=arr[i][0]+Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=arr[i][1]+Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=arr[i][2]+Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[N-1][0],Math.max(dp[N-1][1],dp[N-1][2]));
        
    }
}