//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
        int gMax=arr[0];
        int gMin=arr[0];
        int total=0;
        int currMax=0;
        int currMin=0;
        for(int i=0;i<arr.length;i++)
        {
            currMax=Math.max(arr[i],currMax+arr[i]);
            currMin=Math.min(arr[i],currMin+arr[i]);
            total+=arr[i];
            gMax=Math.max(gMax,currMax);
            gMin=Math.min(gMin,currMin);
        }
        return gMax>0?Math.max(gMax,total-gMin):gMax;
    }
}
