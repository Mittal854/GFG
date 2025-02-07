//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public boolean isValid(int row,int col,int n, char[][] board)
    {
        for(int j=0;j<col;j++)
        {
            if(board[row][j]=='Q') return false;
        }
        for(int i=row,j=col;i>=0 && j>=0 ;i--,j-- )
        {
            if(board[i][j]=='Q') return false;
        }
        for(int i=row,j=col;i<n&&j>=0;i++,j--)
        {
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    
    public void helper(int col,int n,char[][] board,ArrayList<ArrayList<Integer>>ans)
    {
        if(col==n)
        {
            ArrayList<Integer>b=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(board[i][j]=='Q')
                    {
                        b.add(j+1);
                    }
                }
            }
            ans.add(new ArrayList<>(b));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(isValid(i,col,n,board))
            {
                board[i][col]='Q';
                helper(col+1,n,board,ans);
                board[i][col]='.';
            }
        }
        return;
        
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i],'.');
        }
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        helper(0,n,board,ans);
        return ans;
        
    }
}