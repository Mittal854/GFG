//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.solve(a);
      System.out.println(ans);
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int solve(int bt[] ) {
    // code here
    Arrays.sort(bt);
    int comp=0;
    int wt=0;
    for(int i:bt)
    {
        wt+=comp;
        comp+=i;
    }
    return (int)wt/bt.length;

  }
}
     