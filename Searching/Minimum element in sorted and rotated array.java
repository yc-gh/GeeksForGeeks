    //Find the element smaller than previous element
    //If no rotations are done, print 1st element
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        int i=0;
	        boolean found = false;
	        for(i=0;i<n-1;i++)
	        {
	            if(Integer.parseInt(input[i])>Integer.parseInt(input[i+1]))
	            {
	                found = true;
	                break;
	            }
	        }
	        if(found) System.out.println(input[i+1]);
            else System.out.println(input[0]);
	    }
	 }