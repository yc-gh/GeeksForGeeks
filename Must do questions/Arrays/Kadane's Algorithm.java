// https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0

/*

ALGORITHM

Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

1. Read input array arr[]
2. Read each element from arr[] and add it to current sum
3. If current sum is greater than max sum, update
4. If current sum becomes less than 0, reset current sum

*/

class GFG
 {
    static int kadane(Integer[] arr, int n)
    {
        int currsum = 0;
        int maxsum = arr[0];
        for(int i=0; i<n; i++)
        {
            currsum += arr[i];
            if(currsum > maxsum) maxsum = currsum;
            if(currsum < 0) currsum = 0;
        }
        
        return maxsum;
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        Integer[] arr = new Integer[n];
	        for(int i=0; i<n; i++)
	        {
	            arr[i] = Integer.parseInt(input[i]);
	        }
	        
	        System.out.println(kadane(arr, n));
	    }
	 }
}