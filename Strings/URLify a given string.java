    public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String str = br.readLine().trim();
	        int n = Integer.parseInt(br.readLine().trim());
			
			//Using string replace
	        //str = str.replace(" ","%20");
	        //Manual conversion
	        StringBuilder newstr = new StringBuilder();
	        for(char curr : str.toCharArray())
	        {
	            if(curr!=' ')
	            {
	                newstr.append(curr);
	            }
	            else
	            {
	                newstr.append("%20");
	            }
	        }
	        System.out.println(newstr);
	    }
	 }