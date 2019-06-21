//The idea is to keep track of substring length at each index of each string
//If characters don't match, substring length is 0
//If they do match, substring length is 1 + previous characters' substring length

static int lcs(int i, int j, int count) { 
  
    if (i == 0 || j == 0) { 
        return count; 
    } 

    if (X.charAt(i - 1) == Y.charAt(j - 1)) { 
        count = lcs(i - 1, j - 1, count + 1); 
    } 
    count = Math.max(count, Math.max(lcs(i, j - 1, 0), 
                        lcs(i - 1, j, 0))); 
    return count; 
} 


public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String[] input = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            char[] x = br.readLine().trim().toCharArray();
            char[] y = br.readLine().trim().toCharArray();
            
            //Tabulation array
            int[][] sublength = new int[n+1][m+1];
            
            //Variable to store length of largest substring
            int maxlength = 0;
            
            for(int i=0;i<=n;i++)
            {
                for(int j=0;j<=m;j++)
                {
                    //First row and first col set to 0 for calculation purposes
                    if(i==0 || j==0)
                    {
                        sublength[i][j] = 0;
                    }
                    
                    //If characters match, set length = 1 + length till previous characters
                    else if(x[i-1]==y[j-1])
                    {
                        sublength[i][j] = 1 + sublength[i-1][j-1];
                        
                        //If substring length till here is larger than previous largest
                        maxlength = Math.max(maxlength,sublength[i][j]);
                    }
                    
                    //Else if characters don't match
                    else
                    {
                        sublength[i][j] = 0;
                    }
                }
            }
            System.out.println(maxlength);
        }
    }