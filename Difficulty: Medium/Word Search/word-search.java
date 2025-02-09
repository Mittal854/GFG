//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends






class Solution {
    static int n;
    static int m;
    static public boolean isWord(int row,int col,char[][] mat,boolean[][] visited,int index,String word)
    {
        if(index==word.length()) return true;
        if(row<0 ||row>=n || col<0 ||col>=m || visited[row][col]||mat[row][col]!=word.charAt(index)) return false;
        visited[row][col]=true;
        boolean ans=isWord(row,col+1,mat,visited,index+1,word)||isWord(row,col-1,mat,visited,index+1,word)||isWord(row+1,col,mat,visited,index+1,word)||isWord(row-1,col,mat,visited,index+1,word);
        visited[row][col]=false;
        return ans;
    }
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        n=mat.length;
        m=mat[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j])
                {
                    if(isWord(i,j,mat,visited,0,word)) return true;
                }
            }
        }
        return false;
        
    }
}