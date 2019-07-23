class GFG
 {
    static int eggDropUtil(int[][] memo, int n, int k)
    {
        //For one egg, the number of trials required will be k (worst case - check all floors)
        if(n==1)
        {
            return k;
        }
        
        //If there is only one or no floor, number of trials is 1/0
        if(k==0 || k==1)
        {
            return k;
        }
        
        if(memo[n][k] > 0)
        {
            return memo[n][k];
        }
        
        //Else
        //For each floor and egg, two cases are possible
        //It breaks from the selected floor or doesn't 
        //If it breaks, check all floors below that floor ie. x-1 floors
        //If it doesn't break, check all floors above that floor ie. k-x floors
        //Get max from these cases as the trials for that floor
        //And get min of all floor trials for answer
        
        int min = Integer.MAX_VALUE;
        int thisFloorTrials = 0;
        
        for(int x=1; x<=k; x++)
        {
            thisFloorTrials = Math.max(eggDropUtil(memo, n-1, x-1), eggDropUtil(memo, n, k-x));
            
            if(thisFloorTrials < min)
            {
                min = thisFloorTrials;
            }
        }
        
        //Include the 1 trial for current floor
        return memo[n][k] = min + 1;
    }
     
    static int eggDrop(int n, int k)
    {
        int[][] memo = new int[n+1][k+1];
        return eggDropUtil(memo, n, k);
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
	        System.out.println(eggDrop(n,k));
	    }
	 }
}