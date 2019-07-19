class GFG
 {
    static int countStrUtil(int[][][] memo, int n, int bCount, int cCount)
    {
        //Base case
        //If all b's or c's were previously used
        //No strings can be formed
        if(bCount<0 || cCount<0)
        {
            return 0;
        }
        
        //If n reaches 0 (all characters used) without voialting constraints
        if(n == 0)
        {
            return 1;
        }
        
        //If all b's and c's are used, string can be formed using a's as all remaining chars
        if(bCount==0 && cCount==0)
        {
            return 1;
        }
        
        if(memo[n][bCount][cCount] != -1)
        {
            return memo[n][bCount][cCount];
        }
        
        //Count number of strings if a is selected as current character
        int res = countStrUtil(memo, n-1, bCount, cCount);
        
        //Count number of strings if b is selected as current character
        res += countStrUtil(memo, n-1, bCount-1, cCount);
        
        //Count number of strings if c is selected  as current character
        res += countStrUtil(memo, n-1, bCount, cCount-1);
        
        return (memo[n][bCount][cCount] = res);
    }
     
    static int countStr(int n, int bCount, int cCount)
    {
        int[][][] memo = new int[n+1][2][3];
        
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<2; j++)
            {
                for(int k=0; k<3; k++)
                {
                    memo[i][j][k] = -1;
                }
            }
        }
        
        return countStrUtil(memo, n, bCount, cCount);
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        int bCount = 1;
	        int cCount = 2;
	        System.out.println(countStr(n, bCount, cCount));
	    }
	 }
}