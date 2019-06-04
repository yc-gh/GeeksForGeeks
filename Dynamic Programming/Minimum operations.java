    //Recursive method
    static int findOperations(int n)
    {
        if(n==0 || n==1) return n;
        if(n%2==0) return 1 + findOperations(n/2);
        return 1 + findOperations(n-1);
        
    }
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        int count = 0;
	        while(n>0)
	        {
	            if(n%2==0) 
	            {
	                n=n/2;
	            }
	            else
	            {
	                n--;
	            }
	            count++;
	        }
	        System.out.println(count);
	       //For recursive solution
	       // System.out.println(findOperations(n));
	    }
	 }