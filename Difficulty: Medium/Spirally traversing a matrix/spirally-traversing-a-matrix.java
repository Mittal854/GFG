//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int total=n*m;
        int count=0;
        ArrayList<Integer> spiral=new ArrayList<>();
        int sr=0;
        int sc=0;
        int er=n-1;
        int ec=m-1;
        while(count<total)
        {
            for(int j=sc;j<=ec && count<total;j++)
            {
                spiral.add(mat[sr][j]);
                count++;
            }
            sr++;
            for(int i=sr;i<=er  && count<total;i++)
            {
                spiral.add(mat[i][ec]);
                count++;
            }
            ec--;
            if(sc<=ec)
            {
                for(int j=ec;j>=sc  && count<total;j--)
                {
                    spiral.add(mat[er][j]);
                    count++;
                }
                er--;
            }
            if(sr<=er)
            {
                for(int i=er;i>=sr  && count<total;i--)
                {
                    spiral.add(mat[i][sc]);
                    count++;
                }
                sc++;
            }
            
        }
        return spiral;
    }
}
