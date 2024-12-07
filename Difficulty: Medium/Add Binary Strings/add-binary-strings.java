//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        int i=s1.length()-1;
        int j=s2.length()-1;
        int carry=0;
        StringBuilder str=new StringBuilder();
        while(i>=0 ||j>=0 ||carry!=0)
        {
            int d1=(i>=0)?s1.charAt(i)-'0':0;
            int d2=(j>=0)?s2.charAt(j)-'0':0;
            int sum=d1+d2+carry;
            carry=sum/2;
            str.append(sum%2);
            i--;
            j--;
        }
        String rev=str.reverse().toString();
        int index=0;
        while(index<rev.length() && rev.charAt(index)=='0') index++;
        
        return index==rev.length()?"0":rev.substring(index);
    }
}