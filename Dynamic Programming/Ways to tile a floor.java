class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int w = Integer.parseInt(br.readLine().trim());
	        
	        long[] dp = new long[w+1];
	        
	        dp[0] = 0;
	        dp[1] = 1;
	        dp[2] = 2;
	        
	        for(int i=3; i<=w; i++)
	        {
	            dp[i] += dp[i-1] + dp[i-2];
	        }
	        
	        System.out.println(dp[w]);
	    }
	 }
}