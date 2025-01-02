//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        ArrayList<String> res=new ArrayList<>();
        String path="";
        int n=mat.size();
        int m=mat.get(0).size();
        boolean[][] visited=new boolean[n][m];
        solve(0,0,path,visited,res,mat);
        return res;
    }
    public void solve(int row,int col,String path,boolean[][] visited,ArrayList<String> res,ArrayList<ArrayList<Integer>> mat)
    {
        if(row==visited.length-1 && col==visited[0].length-1)
        {
            res.add(new String(path));
            return;
        }
        visited[row][col]=true;
        if(safe(row+1,col,visited,mat))
        {
            solve(row+1,col,path+'D',visited,res,mat);
        }
        if(safe(row,col-1,visited,mat))
        {
            solve(row,col-1,path+'L',visited,res,mat);
        }
        if(safe(row,col+1,visited,mat))
        {
            solve(row,col+1,path+'R',visited,res,mat);
        }
        if(safe(row-1,col,visited,mat))
        {
            solve(row-1,col,path+'U',visited,res,mat);
        }
        visited[row][col]=false;
        
        
    }
    public boolean safe(int row,int col,boolean[][] visited,ArrayList<ArrayList<Integer>>mat)
    {
        if(row<0 ||row>=mat.size() || col<0 || col>=mat.get(0).size()) return false;
        if(visited[row][col]==true || mat.get(row).get(col)==0) return false;
        return true;
    }
}