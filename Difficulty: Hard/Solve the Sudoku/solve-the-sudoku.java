//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    
    
    static boolean isValid(int[][]mat,int row, int col,int n)
    {
        for(int i=0;i<9;i++)
        {
            if(mat[i][col]==n) return false;
            if(mat[row][i]==n) return false;
        }
        int nrow=(row/3)*3;
        int ncol=(col/3)*3;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++){
            if(mat[nrow+i][ncol+j]==n) return false;
            }
        }
        return true;
    }
    
    static boolean helper(int[][] mat, int row,int col)
    {
        if(row==8 && col==9) return true;
        if(col==9)
        {
            row++;
            col=0;
        }
        if(mat[row][col]!=0) return helper(mat,row,col+1);
        
        for(int i=1;i<=9;i++)
        {
            if(isValid(mat,row,col,i))
            {
                mat[row][col]=i;
                if(helper(mat,row,col+1)) return true;
                mat[row][col]=0;
            }
        }
        return false;
    }
    
    static void solveSudoku(int[][] mat) {
        // code here
        helper(mat,0,0);
    }
}