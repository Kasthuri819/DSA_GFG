//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
         StringBuilder builder = new StringBuilder();
          if(s1.charAt(0)=='-'&& s2.charAt(0)=='-'){
              s1 = s1.substring(1);
              s2 = s2.substring(1);
          }
          if(s1.charAt(0)=='-'&& s2.charAt(0)!='-'){
              s1 = s1.substring(1);
              builder.append('-');
              
          }
          if(s1.charAt(0)!='-'&& s2.charAt(0)=='-'){
              s2 = s2.substring(1);
              builder.append('-');
          }
          
           int n = s1.length();
          int m = s2.length();
          int prod[] = new int[n+m];
          
          for(int i = n-1;i>=0;i--)
          {
              for(int j = m-1;j>=0;j--)
              {
                  int digit1 = s1.charAt(i) - '0';
                  int digit2 = s2.charAt(j) - '0';
                  prod[i+j+1] += digit1*digit2;
              }
          }
          
          int carry =0;
          for(int i = prod.length-1;i>=0;i--)
          {
              int temp = (prod[i]+carry)%10;
              carry = (prod[i]+carry)/10;
              prod[i] = temp;
          }
      
           int i = 0;
           while(i < prod.length && prod[i] == 0) i++;
           if(i >= prod.length) return "0";
           
           for(int j = i; j < prod.length; j++) 
           {
               builder.append(prod[j]);
           }
           
           return builder.toString();
    }
}