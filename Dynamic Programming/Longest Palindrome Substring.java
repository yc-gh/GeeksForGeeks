//A string of length 1 is a palindrome
//A string of length 2 is a palindrome of both chars are equal
//Any string of length > 2 can be checked by choosing each index as start and taking substrings of length > 3
//Since checking of a k length substring starting from i index involves checking palindrome of k-2 length from i+1  

//An O(1) space solution involves checking odd,even length palindromes 
//By choosing a single index as middle and checking elements on either side for even length palindrome
//Or by choosing two indices (chars are equal) as middle elements of odd length palindrome

//Iteration solution involves 2 loops
// i for start index, checking k length substrings (k --> length)
// however in this approach, each time the inner substrings will need to be checked
// the dp solution saves the inner iterations in a table
// the dp table has row nums = i, col nums = j (ending index)
static String DPfindPalind(String str)
{
    int len = str.length();
    boolean[][] dp = new boolean[len][len];
    
    //Any string of length 1 is a palindrome
    for(int i=0;i<len;i++)
    {
        dp[i][i] = true;
    }
    
    //To print the palindrome, save the starting index and max length
    int start = 0;
    int firststart = 0;
    
    //Solution requires least index substring if conflict occurs
    //Store first index and length
    //Check if any other substrings have a greater length, if one exists, print that instead
    int maxlength = 1;
    int firstlen = 1;
    
    //Any string of length 2 is palindrome if both chars are equal
    for(int i=0;i<len-1;i++)
    {
        if(str.charAt(i)==str.charAt(i+1))
        {
            dp[i][i+1] = true;
            start = i;
            maxlength = 2;
            if(firststart == 0)
            {
                firststart = i;
                firstlen = 2;
            }
        }
    }
    
    //Check strings of length > 2 
    // k length strings 
    for(int k=3;k<=len;k++)
    {
        // starting index i
        for(int i=0;i<=len-k;i++)
        {
            //Set ending index j
            int j = i + k - 1;
            
            //Check inner substring
            // if it's a palindrome then current two characters are checked for equality
            // starting from the next index till current ending-1 index as end index
            if(dp[i+1][j-1] && str.charAt(i)==str.charAt(j))
            {
                dp[i][j] = true;
                
                //If current condition is true
                //Then set new starting index and new maxlength
                if(k > maxlength)
                {
                    start = i;
                    maxlength = k;
                    if(firststart == 0)
                    {
                        firststart = i;
                        firstlen = k;
                    }
                }
            }
        }
    }

    //If a greater length substring is found, print that instead
    if(maxlength > firstlen)
    {
        firststart = start;
        firstlen = maxlength;
    }
    return str.substring(firststart,firststart+firstlen);
}

public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine().trim();
            System.out.println(DPfindPalind(str));
        }
    }