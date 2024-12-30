//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }

            int x = sc.nextInt();

            if (new Solution().matSearch(mat, x))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static boolean find(int[] mat,int x)
    {
        int low=0;
        int high=mat.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(mat[mid]==x) return true;
            else if(mat[mid]<x) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        for(int[] arr:mat)
        {
            if(find(arr,x)) return true;
        }
        return false;
    }
}