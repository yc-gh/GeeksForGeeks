public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
		    String[] input = br.readLine().trim().split("\\s+");
		    int m = Integer.parseInt(input[0]);
		    int n = Integer.parseInt(input[1]);
		    input = br.readLine().trim().split("\\s+");
		    int[][] a = new int[m][n];
		    int k = 0;
		    int count = 0;
		    //Keep track of each side edge using these
		    //Elements are read till each side edge is reached
		    int upperedge = 0;
		    int rightedge = n-1;
		    int bottomedge = m-1;
		    int leftedge = 0;
		    for(int i=0;i<m;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            a[i][j] = Integer.parseInt(input[k++]);
		        }
		    }
		    StringBuilder output = new StringBuilder();
		    //Keep repeating till all elements have been read
		    while(count<(m*n))
		    {
		        //Read upper edge elements
		        for(int i=leftedge;i<=rightedge;i++)
		        {
		            output.append(a[upperedge][i]+" ");
		            count++;
		        }
		        //Upper edge moves down
		        upperedge++;
		        //If matrix is not square, it's a possible that edges may not have met
		        //This prevents further iterations if all elements have been read already
		        if(count>=m*n) break;
		        //Read right edge elements
		        for(int i=upperedge;i<=bottomedge;i++)
		        {
		            output.append(a[i][rightedge]+" ");
		            count++;
		        }
		        //Right edge moves left
		        rightedge--;
		        if(count>=m*n) break;
		        //Read bottom edge elements
		        for(int i=rightedge;i>=leftedge;i--)
		        {
		            output.append(a[bottomedge][i]+" ");
		            count++;
		        }
		        //Bottom edge moves up
		        bottomedge--;
		        if(count>=m*n) break;
		        //Read left edge elements
		        for(int i=bottomedge;i>=upperedge;i--)
		        {
		            output.append(a[i][leftedge]+" ");
		            count++;
		        }
		        //Left edge moves right
		        leftedge++;
		    }
		    System.out.println(output);
		}
	}