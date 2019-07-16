class GFG
 {
    static int minRemovals(int[] a, int n, int k)
    {
        //Sort the array
        Arrays.sort(a);
        
        int count = Integer.MAX_VALUE;
        int removedCount = 0;
        
        //If difference b/w first and last pile after sorting is <= k, nothing needs to be done
        if(a[n-1]-a[0] <= k)
        {
            return 0;
        }
        
        //Else
        //Starting from first pile, all remaining piles can be changed relative to current pile
        //Or current pile can be removed and remaining piles can be changed relative to next pile
        //Get the minimum counts from these
        else 
        {
            for(int i=0; i<n; i++)
            {
                //Count with current pile 
                //Includes count of previously removed piles
                int countWithCurrent = removedPiles;
                
                //If current pile is removed, add its count to removed piles
                removedPiles += a[i]; 
            
                //Modify all remaining piles relative to current pile
                for(int j=n-1; j>i; j--)
                {
                    if(a[j]-a[i] > k)
                    {
                        countWithCurrent += a[j] - a[i] - k;
                    }
                }
                
                //Compare count with current pile and without current pile for each pile
                count = Integer.min(count, tempcount);
            }
        }
        
        return count;
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String[] input = br.readLine().trim().split("\\s+");
	        int n = Integer.parseInt(input[0]);
	        int k = Integer.parseInt(input[1]);
	        input = br.readLine().trim().split("\\s+");
	        int[] a = new int[n];
	        for(int i=0; i<n; i++)
	        {
	            a[i] = Integer.parseInt(input[i]);    
	        }
	        System.out.println(minRemovals(a, n, k));
	    }
	 }
}