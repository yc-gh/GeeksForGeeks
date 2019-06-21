//Recursive solution

static int count( int S[], int m, int n ) 
{ 
	// If n is 0 then there is 1 solution  
	// (do not include any coin) 
	if (n == 0) 
		return 1; 
		
	// If n is less than 0 then no  
	// solution exists 
	if (n < 0) 
		return 0; 
	
	// If there are no coins and n  
	// is greater than 0, then no 
	// solution exist 
	if (m <=0 && n >= 1) 
		return 0; 
	
	// count is sum of solutions (i)  
	// including S[m-1] (ii) excluding S[m-1] 
	return count( S, m - 1, n ) + 
			count( S, m, n-S[m-1] ); 
} 

public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int m = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        int n = Integer.parseInt(br.readLine().trim());
	        
	        //Input coin array
	        int[] a = new int[m];
	        for(int i=0;i<m;i++)
	        {
	            a[i] = Integer.parseInt(input[i]);
	        }
	        
	        //Array for tabulation
	        int[] s = new int[n+1];
	        
	        //Base case for getting first value 
	        s[0] = 1;
	        
	        //The recursive formula is S[N] = SIGMA(I){S[N-I]} for each I(coin value) in a[]
	        for(int i=0;i<m;i++)
	        {
    	        for(int j=a[i];j<=n;j++)
    	        {
    	            s[j] += s[j-a[i]];
    	        }
	        }
	        System.out.println(s[n]);
	    }
	 }