//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countPartitions(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    
    
    int countPartitions(int[] arr, int d) {
        // code here
        int sum=0;
        int zero=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0) zero++;
            sum+=arr[i];
        }
        if((sum+d)%2!=0 ||d>sum) return 0;
        sum=(d+sum)/2;
        int[][] dp=new int[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0]=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1]==0) dp[i][j]=dp[i-1][j];
                else if(arr[i-1]>j) dp[i][j]=dp[i-1][j];
                else
                {
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum]*(1<<zero);
    }
}
