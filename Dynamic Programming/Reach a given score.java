class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        int[] dp = new int[n+1];
	        
	        //Number of ways to have 0 
	        dp[0] = 1;
	        
	        //Number of ways to get 3
	        for(int i=3; i<=n; i++)
	        {
	            dp[i] += dp[i-3];
	        }
	        
	        //Number of ways to get 5
	        for(int i=5; i<=n; i++)
	        {
	            dp[i] += dp[i-5];
	        }
	        
	        //Number of ways to get 10
	        for(int i=10; i<=n; i++)
	        {
	            dp[i] += dp[i-10];
	        }
	        
	        
	        System.out.println(dp[n]);
	    }
	 }
}