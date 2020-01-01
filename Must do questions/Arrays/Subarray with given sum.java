// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

/*

**ALGORITHM**

Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

1. Read the input array as arr[]
2. Read required sum as S
3. Starting from index 0, get subarrays of size 1 to arr[] size
4. If sum of elements in subarray equal S, print start and end indexes and exit
5. If sum of elements exceeds S, check new subarray from next starting index
6. If no such subarray found, print -1

*/

/*

**PSEUDOCODE**

FUNCTION subarrSum(arr[], arr[] size, required sum)
    FOR index1 from 0 to (arr[] size-1) :
        initialize tempsum to 0
        FOR index2 from index1 to (arr[] size-1) :
            tempsum = tempsum + arr[index2]
            IF tempsum == required sum THEN
                PRINT index1 index2 
                RETURN
            ENDIF
            ELSE IF tempsum > required sum THEN
                BREAK
            ENDIF
        ENDLOOP
    ENDLOOP

    PRINT -1

*/

class GFG
 {
    static void subarrSum(int[] arr, int n, int s) 
    {
        for(int i=0; i<n; i++)
        {
            int tempsum = 0;
            for(int j=i; j<n; j++)
            {
                tempsum += arr[j];
                if(tempsum == s)
                {
                    System.out.println((i+1) + " " + (j+1));
                    return;
                }
                else if(tempsum > s)
                {
                    break;
                }
            }
        }
        
        System.out.println("-1");
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String[] input = br.readLine().trim().split("\\s+");
	        int n = Integer.parseInt(input[0]);
	        int s = Integer.parseInt(input[1]);
	        input = br.readLine().trim().split("\\s+");
	        int[] arr = new int[n];
	        for(int i=0; i<n; i++)
	        {
	            arr[i] = Integer.parseInt(input[i]);
	        }
	        
	        subarrSum(arr, n, s);
	    }
	 }
}