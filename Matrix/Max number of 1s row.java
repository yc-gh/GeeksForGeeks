public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String[] input = br.readLine().trim().split("\\s+");
	        int rows = Integer.parseInt(input[0]);
	        int cols = Integer.parseInt(input[1]);
	        input = br.readLine().trim().split("\\s+");
	        int max1s = 0;
	        int rowindex = 0;
			
			//Count 1s from the input 
	        //OR input into array then calculate from the array
	        //Traversing a 1d array as 2d array -- index is [width*row + column]
	        for(int i=0;i<rows;i++)
	        {
                int temp1s = 0;
	            for(int j=0;j<cols;j++)
	            {
	                if(input[cols*i+j].equals("1")) temp1s++;
	            }
                if(temp1s>max1s)
                {
                    max1s = temp1s;
                    rowindex = i;
                }
	        }
	        System.out.println(rowindex);
	    }
	 }