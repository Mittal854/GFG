//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        LinkedHashMap<Character,Integer> mpp=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char a=s.charAt(i);
            mpp.put(a,mpp.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Character,Integer> hm:mpp.entrySet())
        {
            if(hm.getValue()==1) return hm.getKey();
        }
        return '$';
    }
}
