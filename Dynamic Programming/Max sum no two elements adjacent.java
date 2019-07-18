class GFG
 {
    //For each house, can choose a house or choose next one
    //Used memoization
    
    static int findMaxMoney(int[] arr, int[] memo, int n, int i)
    {
        if(i >= n)
        {
            return 0;
        }
        
        if(memo[i] > 0)
        {
            return memo[i];
        }
        
        int chosen = 0;
        int notchosen = 0;
        
        chosen = arr[i] + findMaxMoney(arr, memo, n, i+2);
        
        notchosen = 0 + findMaxMoney(arr, memo, n, i+1);
        
        return memo[i] = Integer.max(chosen, notchosen);
    }
     
    static int maxMoney(int[] arr, int n)
    {
        int[] memo = new int[n];
        
        return findMaxMoney(arr, memo, n, 0);
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
	        System.out.println(maxMoney(arr, n));
	    }
	 }
}