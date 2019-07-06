//Memoized solution
static int formPalin(char[] str, int[][]memo, int l, int h) 
{
    if(memo[l][h] > 0)
    {
        return memo[l][h];
    }
    
    //If string length is 1
    if(l == h) 
    {
        return 0;
    }
    
    //If string length is 2
    //Check if characters are equal or not
    if(l+1 == h)
    {
        return (str[l] == str[h] ? 0 : 1);
    }
    
    //Else when string length is > 2
    //3 cases need to be checked
    
    //If outermost characters match
    //Then count = 0 + count of substring(l+1,h-1)
    
    if(str[l] == str[h])
    {
        return memo[l][h] = formPalin(str, memo, l+1, h-1);
    }
    
    
    //Else find min counts from substring(l+1,h) and (l,h-1)
    
    else
    {
        return memo[l][h] = 1 + Math.min(formPalin(str, memo, l+1, h), formPalin(str, memo, l, h-1));
    }
    
}
    
    
//DP Solution
static int DPformPalin(char[] str)
{
    int n = str.length;
    int[][] dp = new int[n][n];
    
    //l and h are rows and columns of dp table denoting the respective indices
    //In order to find the count for string of length n first we need to have count for string of length n-1
    int l, h, length;    
    
    //Calculate counts for smaller lengths first ie. 1 --> n-1 (for string length n --> 0..n-1) 
    //l always starts with 0 and h starts from length
    for(length = 1; length < n; length++)
    {
        for(l=0, h=length ; h < n ; l++, h++)
        {
            if(str[l] == str[h])
            {
                dp[l][h] = dp[l+1][h-1];
            }
            else
            {
                dp[l][h] = 1 + Math.min(dp[l+1][h] , dp[l][h-1]);
            }
        }
    }
    
    //Return the count for 0..n-1 length string as required in question
    return dp[0][n-1];
}

public static void main (String[] args) throws IOException
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while(t-->0)
    {
        char[] s = br.readLine().trim().toCharArray();
        int[][] memo = new int[s.length][s.length];
        // System.out.println(formPalin(s, memo, 0, s.length-1));
        System.out.println(DPformPalin(s));
        
    }
}