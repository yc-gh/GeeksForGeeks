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