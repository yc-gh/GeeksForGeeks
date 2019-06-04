    //Construct a AxB table
    //1st column and 1st row will be 1 since there is only 1 path to these cells
    //All other cells can only be reached by the cell above them or to the left
    //Calculate paths to the cell above and to the left and add these to get total paths to current cell
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String[] input = br.readLine().trim().split("\\s+");
	        int a = Integer.parseInt(input[0]);
	        int b = Integer.parseInt(input[1]);
	        int[][] path = new int[a][b];
	        for(int i=0;i<a;i++)
	        {
	            for(int j=0;j<b;j++)
	            {
	                //If 1st row or 1st column, set 1
	                if(i==0||j==0)
	                {
	                    path[i][j] = 1;
	                }
	                //Else add upper and left cell values 
	                else 
	                {
	                    path[i][j] = path[i-1][j] + path[i][j-1];
	                }
	            }
	        }
	        //Print bottom right cell value
	        System.out.println(path[a-1][b-1]);
	    }
	 }