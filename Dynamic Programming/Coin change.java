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