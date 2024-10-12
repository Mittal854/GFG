//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
     public int lB(int[] nums,int t)
    {
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==t)
            {
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]>t)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
                
            }
        }
        return ans;
    }
     public int uB(int[] nums,int t)
    {
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==t)
            {
                ans=mid;
                low=mid+1;
            }
            else if(nums[mid]>t)
            {
                high=mid-1;
                
            }
            else
            {
                low=mid+1;
                ans=mid;
            }
        }
        return ans;
    }
    
    int count(int[] arr, int n, int x) {
        // code here
        int lb=lB(arr,x);
        if(lb==-1) return 0;
        return (uB(arr,x)-lb+1);
    }
}