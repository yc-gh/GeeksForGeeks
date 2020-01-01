// https://practice.geeksforgeeks.org/problems/missing-number-in-array/0

/*

ALGORITHM

Given an array C of size N-1 and given that there are numbers 
from 1 to N with one element missing, the missing number is to be found.

1. Read input arr[] 
2. Calculate sum of all numbers
3. Subtract it from (n*n+1)/2 to get missing number 

*/

class GFG
 {
    static Integer missingNum(Integer[] arr, int n)
    {
        Integer expectedSum = (n*(n+1))/2;
        Integer actualSum = 0;
        for(Integer i : arr)
        {
            actualSum += i;
        }
        
        return expectedSum - actualSum;
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        Integer[] arr = new Integer[n-1];
	        for(int i=0; i<n-1; i++)
	        {
                arr[i] = Integer.parseInt(input[i]);
	        }
	        System.out.println(missingNum(arr, n));
	    }
	 }
}