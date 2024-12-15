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
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int help1(int[] arr, int l,int mid,int h)
    {
        int[] left=Arrays.copyOfRange(arr,l,mid+1);
        int[] right=Arrays.copyOfRange(arr,mid+1,h+1);
        int i=0;
        int j=0;
        int k=l;
        int swap=0;
        while(i<left.length && j<right.length)
        {
            if(left[i]<=right[j])
            {
                arr[k++]=left[i++];
            }
            else
            {
                arr[k++]=right[j++];
                swap+=(mid+1)-(l+i);
            }
        }
        while(i<left.length)
        {
            arr[k++]=left[i++];
        }
        while(j<right.length)
        {
            arr[k++]=right[j++];
        }
        return swap;
    }
    
    static int help(int[] arr, int l,int h)
    {
        int count=0;
        if(l<h)
        {
            int mid=l+(h-l)/2;
            count+=help(arr,l,mid);
            count+=help(arr,mid+1,h);
            count+=help1(arr,l,mid,h);
        }
        return count;
    }
    
    static int inversionCount(int arr[]) {
        // Your Code Here
        return help(arr,0,arr.length-1);
    }
}