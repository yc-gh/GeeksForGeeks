    //Subtract longest common subsequence from sum of lengths of both strings
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String[] input = br.readLine().trim().split("\\s+");
	        char[] str1 = input[0].toCharArray();
	        char[] str2 = input[1].toCharArray();
	        int a = str1.length;
	        int b = str2.length;
	        int[][] lcs = new int[a+1][b+1];
	        for(int i=0;i<=a;i++)
	        {
	            for(int j=0;j<=b;j++)
	            {
	                //First row and first column all 0s for calculation of other rows/cols
	                if(i==0 || j==0)
	                {
	                    lcs[i][j] = 0;
	                }
	                //If characters of both strings match
	                //Check the length of subsequence till previous characters of both strings
	                else if(str1[i-1] == str2[j-1])
	                {
	                    lcs[i][j] = lcs[i-1][j-1] + 1;
	                }
	                //If characters donot match, check lcs till previous character of string 1
	                //And lcs till previous character of string 2
	                //Set current length equal to that max since length has not changed 
	                else
	                {
	                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
	                }
	            }
	        }
            System.out.println(a + b - lcs[a][b]);
	    }
	 }