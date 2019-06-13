    // Returns value of Binomial Coefficient C(n, k)  
    static long binomialCoeff(int n, int k) { 
        long res = 1; 
  
        // Since C(n, k) = C(n, n-k)  
        if (k > n - k) { 
            k = n - k; 
        } 
  
        // Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]  
        for (int i = 0; i < k; ++i) { 
            res *= (n - i); 
            res /= (i + 1); 
        } 
  
        return res; 
    } 
  
    // A Binomial coefficient based function to find nth catalan  
    // number in O(n) time  
    static long catalan(int n) { 
        // Calculate value of 2nCn  
        long c = binomialCoeff(2 * n, n); 
  
        // return 2nCn/(n+1)  
        return c / (n + 1); 
    }
    
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        //Calculate Catalan number -> (2n(C)n)/(n+1)
	        System.out.println(catalan(n));
	    }
	 }