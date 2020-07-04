//https://practice.geeksforgeeks.org/problems/factors-sum/0

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
	        System.out.println(sumDivisors(n));
	    }
	 }
	 
	 private static int sumDivisors(int n)
	 {
        int[] spf = new int[n+1];
	        
        sieve(n, spf);
        
        int curr = spf[n];
        int exp = 1;
        int sumDiv = 1;
        int temp = 1;
        // for sum of exponents
       // int sumExp = 0; 
       
        while(n>1)
        {
            n /= spf[n];
            
            temp += (int)Math.pow(curr,exp);
            
            if(curr==spf[n])
            {
                exp++;
                continue;
            }
            
            sumDiv *= temp;
            
           // sumExp += exp;
           
            curr = spf[n];
            exp = 1;
            temp = 1;
        }
        
        return sumDiv;
	 }
	 
	 private static void sieve(int n, int[] spf)
	 {
	     spf[1] = 1;
	     
	     for(int i=2; i<=n; i++) spf[i] = i;
	     
	     for(int i=4; i<=n; i+=2) spf[i] = 2;
	     
	     for(int i=3; i<=n/i; i++)
	     {
	         if(spf[i]==i)
	         {
	             for(int j=i*i; j<=n; j+=i)
	             {
	                 if(spf[j]==j) spf[j] = i;
	             }
	         }
	     }
	 }
}
