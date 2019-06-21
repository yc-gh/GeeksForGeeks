/*
    if a,b,c are string lengths of a,b,c
    
    F(a,b,c) = true if a=0,b=0,c=0
    i.e F(0,0,0) = true
    
    The recurrence relation is 
    F(a,b,c) = (If a[0]==c[0]) F(a+1,b,c+1) || (If b[0]==c[0]) F(a,b+1,c+1)
    
    Explanation --
    
    If char of a == char of c then F(a,b,c) = F(a+1,b,c+1)
    i.e F(a,b,c) = F(a-1,b,c-1)
    
    If char of b == char of c then F(a,b,c) = F(a,b+1,c+1)
    i.e F(a,b,c) = F(a,b-1,c-1)
    
    If chars of both a and b match then F(a,b,c) = any of F(a+1,b,c+1),F(a,b+1,c+1)
    i.e F(a,b,c) = F(a-1,b,c-1) || F(a,b-1,c-1)
    
    These relations can be used to fill the DP table
*/

static boolean ILRecursion(String a,String b,String c)
{
    if(a.length()==0 && b.length()==0 && c.length()==0)
    {
        return true;
    }
    
    if(c.length()!=0)
    {
        return false;
    }
    
    return (a.charAt(0)==c.charAt(0) && ILRecursion(a.substring(1),b,c.substring(1)))
            || (b.charAt(0)==c.charAt(0) && ILRecursion(a,b.substring(1),c.substring(1)));
}

public boolean isInterLeave(String aStr,String bStr,String cStr)
{
    int n = aStr.length();
    int m = bStr.length();
    
    //If length of c != length of a + b
    //Then c can't be interleaved string
    if(cStr.length() != m+n) return false;
    
    //Convert to char arrays for convenience
    char[] a = aStr.toCharArray();
    char[] b = bStr.toCharArray();
    char[] c = cStr.toCharArray();
    
    //Rows represent string A's chars, cols represent B's chars
    //Strings start from index 1 of row/col 
    //In order to check their chars, index-1 will be checked
    boolean[][] dp = new boolean[n+1][m+1];
    
    for(int i=0;i<=n;i++)
    {
        for(int j=0;j<=m;j++)
        {
            
            if(i==0 && j==0)
            {
                dp[i][j] = true;
            }
            
            //Else if one string is empty (for understanding -> if we consider only one string)
            //If A is empty
            //Check the characters of B and C (index-1 since index 0 denotes empty string)
            //If they match, then state is same as previous state (strings match till current index)
            else if(i==0 && b[j-1]==c[j-1])
            {
                dp[i][j] = dp[i][j-1];    
            }
            
            //If B is empty
            else if(j==0 && a[i-1]==c[i-1])
            {
                dp[i][j] = dp[i-1][j];
            }
            
            //When characters of both exist, the index of C will be i+j-1 (Number of read characters in C)
            //If current character of A matches character of C, but B doesn't match
            //Copy previous state of A
            else if(i>0 && j>0 && a[i-1]==c[i+j-1] && b[j-1]!=c[i+j-1])
            {
                dp[i][j] = dp[i-1][j];
            }
            
            //Else if only B matches 
            else if(i>0 && j>0 && a[i-1]!=c[i+j-1] && b[j-1]==c[i+j-1])
            {
                dp[i][j] = dp[i][j-1];
            }
            
            //Else when both match
            else if(i>0 && j>0 && a[i-1]==c[i+j-1] && b[j-1]==c[i+j-1])
            {
                dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
    }
    return dp[n][m];
}