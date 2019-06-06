    //Theory --
    //If digits are sorted in descending order, no greater number exists
    //If digits are sorted in ascending order, swap last two digits
    //Any other case, find next greater number using - 
    //Traverse in reverse from right side till a smaller digit D is found
    //Swap D with minimum greater digit in the subarray to it's right
    //Sort the subarray to right of D 
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        int[] num = new int[n];
	        for(int i=0;i<n;i++)
	        {
	            num[i] = Integer.parseInt(input[i]);
	        }
	        boolean found = false;
	        //Search from right end till a smaller digit (from it's right digit) is found
	        for(int i=n-1;i>0;i--)
	        {
	            if(num[i]>num[i-1])
	            {
	                found = true;
	                //Search it's right subarray for a greater digit from right side
	                for(int j=n-1;j>=i;j--)
	                {
	                    //Swap 
	                    if(num[i-1]<num[j])
	                    {
    	                    int temp = num[i-1];
    	                    num[i-1] = num[j];
    	                    num[j] = temp;
    	                    break;
	                    }
	                }
	                //Sort the subarray to right of swapped digit
	                Arrays.sort(num,i,n);
	            }
	            if(found==true) break;
	        }
	        StringBuilder output = new StringBuilder();
	        if(found==true)
	        {
	            for(int i : num) output.append(i+" ");
	        }
	        else
	        {
	            Arrays.sort(num);
                for(int i : num) output.append(i+" ");
	        }
	        System.out.println(output);
	    }
	 }