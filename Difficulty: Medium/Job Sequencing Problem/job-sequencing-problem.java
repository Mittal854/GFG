//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] jobIDStrings = sc.nextLine().split(" ");
            String[] deadlineStrings = sc.nextLine().split(" ");
            String[] profitStrings = sc.nextLine().split(" ");

            // Convert the input strings to integer arrays
            int[] jobIDs = new int[jobIDStrings.length];
            int[] deadlines = new int[deadlineStrings.length];
            int[] profits = new int[profitStrings.length];

            for (int i = 0; i < jobIDStrings.length; i++) {
                jobIDs[i] = Integer.parseInt(jobIDStrings[i]);
                deadlines[i] = Integer.parseInt(deadlineStrings[i]);
                profits[i] = Integer.parseInt(profitStrings[i]);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.JobSequencing(jobIDs, deadlines, profits);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Pair{
    int profit;
    int deadline;
    Pair(int profit,int deadline)
    {
        this.profit=profit;
        this.deadline=deadline;
    }
}

class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // code here..
        int n=id.length;
        Pair[] pairs=new Pair[n];
        for(int i=0;i<n;i++)
        {
            pairs[i]=new Pair(profit[i],deadline[i]);
        }
        Arrays.sort(pairs,(a,b)->Integer.compare(b.profit,a.profit));
        int maxD=0;
        for(int i:deadline)
        {
            maxD=Math.max(i,maxD);
        }
        int[] dead=new int[maxD+1];
        Arrays.fill(dead,-1);
        int total=0;
        int count=0;
        for(Pair i:pairs)
        {
            for(int j=i.deadline;j>0;j--)
            {
                if(dead[j]==-1)
                {
                    dead[j]=i.profit;
                    total+=i.profit;
                    count++;
                    break;
                }
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(count);
        ans.add(total);
        return ans;
    }
}
