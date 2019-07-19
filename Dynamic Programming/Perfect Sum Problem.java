class GFG
{
    //Memoization
    static int findSubsets(int[] arr, int[][] memo, int currindex, int sum)
    {
        if(currindex == arr.length)
        {
            return 0;
        }
        
        if(sum < 0)
        {
            return 0;
        }
        
        //Check if method result is cached
        if(memo[currindex][sum] >= 0)
        {
            return memo[currindex][sum];
        }
        
        int found = 0;
        
        //If remaining sum is reached 
        //count will be incremented
        if(sum == arr[currindex])
        {
            found = 1;
        }
        
        //If current number is included / not included
        int included = findSubsets(arr, memo, currindex+1, sum-arr[currindex]);
        int notincluded = findSubsets(arr, memo, currindex+1, sum);
        
        //Return total of all these
        return memo[currindex][sum] = found + included + notincluded;
    }
        
    //Util method for memoized solution
    static int Subsets(int[] arr, int sum)
    {
        int currindex = 0;
        int[][] memo = new int[arr.length][sum+1];
        for(int[] row : memo)
        {
            Arrays.fill(row, -1);
        }
        return findSubsets(arr, memo, currindex, sum);
    }

    //Eg. if {1,2,3} and sum = n
    //If the current element under consideration is <= current sum
    // then total number of ways in which current sum can be obtained is 
    // total number of ways this sum can be obtained without current number + (--) with current number
    //(Think in terms of coin problem)
    //If an amt of 4 is required and coins of 1,2 are available, 
    // No. of ways 4 can be obtained from 2 is (getting 4 without 2 + getting (4-2) with 2)
    static int DPfindSubsets(int[] arr, int n, int sum)
    {
        int[][] dp = new int[n+1][sum+1];
        
        for(int i=0;i<=n;i++)
        {
            dp[i][0] = 1;
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                dp[i][j] = dp[i-1][j];
                if(arr[i-1] <= j)
                {
                    dp[i][j] += dp[i-1][j-arr[i-1]];
                }
            }
        }
        
        return dp[n][sum];
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
                for(int i=0;i<n;i++)
                {
                    arr[i] = Integer.parseInt(input[i]);
                }
                int sum = Integer.parseInt(br.readLine().trim());
                // System.out.println(Subsets(arr,sum));
                System.out.println(DPfindSubsets(arr,n,sum));
            }
        }
}