    //Calculate sum of elements and subtract from expected sum
    //Or use XOR method
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        int sum = 0;
	        for(int i=0;i<n-1;i++)
	        {
	            sum+=Integer.parseInt(input[i]);
	        }
	        System.out.println(n*(n+1)/2-sum);
	    }
    }
    
    //XOR method
    static int getMissingNo (int a[], int n) 
    { 
        int x1 = a[0];  
        int x2 = 1;  
          
        /* For xor of all the elements  
           in array */
        for (int i = 1; i < n; i++) 
            x1 = x1 ^ a[i]; 
                  
        /* For xor of all the elements  
           from 1 to n+1 */         
        for (int i = 2; i <= n+1; i++) 
            x2 = x2 ^ i;          
          
        return (x1 ^ x2); 
    }