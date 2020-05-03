// https://practice.geeksforgeeks.org/problems/nth-fibonacci-number/0

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        System.out.println(fibo(n, new int[n+1]));
	    }
	 }
	 
	 private static int fibo(int n, int[] dp)
	 {
	     if(n==0) return 0;
	     if(n==1) return 1;
	     if(dp[n]>0) return dp[n];
	     return dp[n] = (fibo(n-1, dp) + fibo(n-2, dp))%1000000007;
	 }
}