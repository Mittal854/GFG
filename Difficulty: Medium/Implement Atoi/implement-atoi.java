//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        // Your code here
        int sign=1;
        int index=0;
        int res=0;
        while(index<s.length() && s.charAt(index)==' ') index++;
        if(index<s.length() && s.charAt(index)=='+'||s.charAt(index)=='-')
        {
            if(s.charAt(index)=='-') sign=-1;
            index++;
        }
        while(index<s.length() && s.charAt(index)>='0' && s.charAt(index)<='9')
        {
            if(res>Integer.MAX_VALUE/10 || res==Integer.MAX_VALUE/10 && s.charAt(index)-'0'>7)
            {
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res=res*10+(s.charAt(index)-'0');
            index++;
        }
        return res*sign;
    }
}