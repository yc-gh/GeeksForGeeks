public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split("\\s+");
	        int[][] a = new int[n][n];
	        int index = 0;
			
			//Read input into array
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
                {
                    a[i][j] = Integer.parseInt(input[index++]);
                }
	        }
			
			//Transpose of matrix
	        for(int i=0;i<n;i++)
	        {
	            for(int j=i;j<n;j++)
	            {
	                int temp = a[i][j];
	                a[i][j] = a[j][i];
	                a[j][i] = temp;
	            }
	        }
			
			//Reverse elements in each column
	        for(int j=0;j<n;j++)
            {
                for(int i=0,k=n-1;i<k;i++,k--)
                {
                    int temp = a[i][j];
                    a[i][j] = a[k][j];
                    a[k][j] = temp;
                }
            }
			
			//Print matrix
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    output.append(a[i][j]+" ");
                }
            }
            System.out.println(output);
	    }
	 }