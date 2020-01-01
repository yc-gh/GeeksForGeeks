// https://practice.geeksforgeeks.org/problems/count-the-triplets/0

/* 
123456789
ALGORITHM

Count all triplets in array with sum S

1. Read the input 
2. Sort the array
3. Use three pointers i,j,k
4. For each i from index 0 to n-3
5. Initialize j=i+1 and k=n-1
6. While j<k, 
7. If arr[i] = arr[j] + arr[k], increment count
8. If sum is > arr[i], increment j; else decrement k

*/


class GFG
 {
    static void countTriplets(Integer[] arr, int n)
    {
        int count=0;
        boolean flag=false;
        Arrays.sort(arr, ((Integer x,Integer y)->y-x));
        for(int i=0; i<n-2; i++)
        {
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int currsum = arr[j]+arr[k];
                if(currsum==arr[i])
                {
                    flag=true;
                    count++;
                    j++;
                }
                else if(currsum>arr[i])
                {
                    j++;
                }
                else if(currsum<arr[i])
                {
                    k--;
                }
            }
        }
        String output = flag ? String.valueOf(count) : "-1";
        System.out.println(output);
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
	        countTriplets(arr, n);
	    }
	 }
}

