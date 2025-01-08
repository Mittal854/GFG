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
        ArrayList<String> paths=new ArrayList<>();
        String path="";
        int n=mat.size();
        int m=mat.get(0).size();
        boolean[][] visited=new boolean[n][m];
        solve(0,0,mat,visited,path,paths);
        return paths;
    }
    public void solve(int row,int col,ArrayList<ArrayList<Integer>>mat,boolean[][] visited,String path,ArrayList<String>paths)
    {
        if(row==mat.size()-1 &&col==mat.get(0).size()-1)
        {
            paths.add(path);
            return;
        }
        visited[row][col]=true;
        if(isValid(row+1,col,mat,visited))
        {
            solve(row+1,col,mat,visited,path+"D",paths);
        }
        if(isValid(row,col-1,mat,visited))
        {
            solve(row,col-1,mat,visited,path+"L",paths);
        }
        if(isValid(row,col+1,mat,visited))
        {
            solve(row,col+1,mat,visited,path+"R",paths);
        }
        if(isValid(row-1,col,mat,visited))
        {
            solve(row-1,col,mat,visited,path+"U",paths);
        }
        
        
        visited[row][col]=false;
    }
    public boolean isValid(int row,int col,ArrayList<ArrayList<Integer>>mat,boolean[][] visited)
    {
        int n=visited.length;
        if(row<0 || row>=n) return false;
        if(col<0 || col>=n) return false;
        if(mat.get(row).get(col)==0) return false;
        if(visited[row][col]) return false;
        
        return true;
    }
}