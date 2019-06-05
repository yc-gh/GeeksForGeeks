    /*
    If a problem cannot be solved using recursion, it cannot be solved using DP
    If a recursive solution exists, check for overlapping subproblems
    If overlapping subproblems exist, then check if optimal solution can be obtained by optimal sols of subproblems
    If yes, then optimal subtstructure exists and DP can be used
    
    Find the naive recursive solution to the problem
    Construct the recursion tree
    If solutions to subproblems in recursion are saved for reuse during recursion -- Memoization
    If solutions are calculated and saved for reuse bottom to top (in array) -- Tabulation
    
    Tabulation -- Calculating possible values for all possible subproblems (that can occur in recursion tree)
    The problem isn't actually solved bottom up, only the recursion tree's values are calculated in bottom up manner
    
    In this problem, a 2d array is made (Rows -> All item #, Cols -> All possible weights in knapsack (0 to W))
    First row -> analogous to knapsack exists but no items = value 0
    First col -> analogous to items exist but no knapsack = value 0
    
    In all other cases, for each item 
    
    If it's weight exceeds knapsack's (compare to all possible) weight
    Then current item cannot be included in the knapsack and thus the value of items in knapsack will remain same as value upto previous item (without current item)
    
    If weight does not exceed knapsack's weight
    Then check 2 values -> 
    (1) When current item is included in the knapsack -> value in knapsack = current item value + value in knapsack for previous item (item #) with weight =- current item weight
    (2) If current item is not included -> value in knapsack is same as value upto previous item
    Calculate max of these and set max as current value
    
    Bottom right element of matrix will give max possible value of knapsack
    */
    
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        int W = Integer.parseInt(br.readLine().trim());
	        int[] val = new int[n];
	        int[] wt = new int[n];
	        String[] input = br.readLine().trim().split("\\s+");
	        for(int i=0;i<n;i++)
	        {
	            val[i] = Integer.parseInt(input[i]);
	        }
	        input = br.readLine().trim().split("\\s+");
	        for(int i=0;i<n;i++)
	        {
	            wt[i] = Integer.parseInt(input[i]);
	        }
	        //One extra row and column for 0s in first row, col
	        int[][] k = new int[n+1][W+1];
	        for(int i=0;i<=n;i++)
	        {
	            for(int w=0;w<=W;w++)
	            {
	                if(i==0 || w==0)
	                {
	                    k[i][w]=0;
	                }
	                //If current item's weight is <= weight of current column (each column not max weight)
	                else if(wt[i-1] <= w)
	                {
	                    //Value obtained by including it
	                    //It's value + previous item's value with new availabe capacity
	                    int included = val[i-1] + k[i-1][w-wt[i-1]];
	                    //If not included
	                    int not_included = k[i-1][w];
	                    //Whichever value is greater
	                    k[i][w] = Math.max(included,not_included);
	                }
	                //Else when weight is greater than current col weight (Not included)
	                else
	                {
	                    k[i][w] = k[i-1][w];
	                }
	            }
	        }
	        System.out.println(k[n][W]);
	    }