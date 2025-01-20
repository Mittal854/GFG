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
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int left=1;
        int right=arr.length-2;
        int water=0;
        int lMax=arr[left-1];
        int rMax=arr[right+1];
        while(left<=right)
        {
            if(rMax<=lMax)
            {
                water+=Math.max(0,rMax-arr[right]);
                rMax=Math.max(rMax,arr[right]);
                right--;
            }
            else
            {
                water+=Math.max(0,lMax-arr[left]);
                lMax=Math.max(lMax,arr[left]);
                left++;
            }
        }
        return water;
    }
}
