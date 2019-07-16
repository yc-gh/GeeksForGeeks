class Gfg
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
			int n = Integer.parseInt(br.readLine().trim());
			
			//Keep two arrays
	        //One for numbers ending with 0
	        //Other for numbers ending with 1
	        //At length 1, there is only 1 number in each array ie. 0 and 1
	        //For each subsequent length, a number ending with 0 can be obtained by appending 0 to sum of 0 and 1 ending numbers
	        //And each number ending with 1 is the obtained by appending 1 to previous 0 ending numbers 
	        int[] a = new int[n];
	        int[] b = new int[n];
	        a[0] = b[0] = 1;
	        for(int i=1;i<n;i++)
	        {
				//To prevent overflow
	            a[i] = (a[i-1] + b[i-1])%1000000007;
	            b[i] = a[i-1];
	        }
	        System.out.println((a[n-1]+b[n-1])%1000000007);
	    }
	}
}