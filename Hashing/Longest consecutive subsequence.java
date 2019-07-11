class GFG
 {
    //Put each element in a set
    //Check whether each element can be the first element of a sequence and count it's consecutive elements
    static int lcs(int[] arr, int n)
    {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            set.add(arr[i]);
        }
        
        int maxlength = 0;
        
        //For each element in the array
        //Check if it is the start of a subsequence
        for(int i=0; i<n; i++)
        {
            
            //If element-1 doesn't exist
            //This element is start of subsequence
            if(!set.contains(arr[i]-1))
            {
                int j = arr[i];
                
                //Repeatedly check whether the next element is present
                while(set.contains(j))
                {
                    j++;
                }
                
                //At this point, we have a sequence of consecutive elements
                // j is final element + 1 (loop termination condition)
                //Compare length of this sequence to previously obtained length
                if((j-arr[i]) > maxlength)
                {
                    maxlength = j-arr[i];
                }
            }
        }
        
        return maxlength;
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        int[] arr = new int[n];
	        for(int i=0; i<n; i++)
	        {
	            arr[i] = Integer.parseInt(input[i]);
	        }
	        System.out.println(lcs(arr, n));
	    }
	 }
}