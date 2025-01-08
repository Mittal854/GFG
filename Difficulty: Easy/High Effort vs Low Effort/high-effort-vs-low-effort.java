//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                   
                    int n = sc.nextInt();
                    int hi[] = new int[n];
                    int li[] = new int[n];
                    for(int i = 0;i<n;i++)
                        hi[i] = sc.nextInt();
                    for(int i = 0;i<n;i++)
                        li[i] = sc.nextInt();    
                    Solution ob = new Solution();
                    System.out.println(ob.maxAmt(n,hi,li));
                
System.out.println("~");
}
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maxAmt(int n , int hi[] , int li[]) 
    { 
        //code here.
        int[]dp=new int[n+1];
        dp[0]=0;
        dp[1]=hi[0];
        for(int i=2;i<=n;i++)
        {
            int a=li[i-1]+dp[i-1];
            int b=hi[i-1]+dp[i-2];
            dp[i]=Math.max(a,b);
        }
        return dp[n];
    } 
}