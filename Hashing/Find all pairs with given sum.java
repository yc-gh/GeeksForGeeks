class GFG
 {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-->0)
	    {
	        StringBuilder output = new StringBuilder();
	        
	        String[] input = br.readLine().trim().split("\\s+");
	        int n = Integer.parseInt(input[0]);
	        int m = Integer.parseInt(input[1]);
	        int x = Integer.parseInt(input[2]);
	        
	        Set<Integer> set = new HashSet<>();
	        
	        input = br.readLine().trim().split("\\s+");
	        int[] a = new int[n];
	        for(int i=0; i<n; i++)
	        {
	            a[i] = Integer.parseInt(input[i]);
	        }
	        
	        //Hash all elements of b
	        input = br.readLine().trim().split("\\s+");
	        int[] b = new int[m];
	        for(int i=0; i<m; i++)
	        {
	            b[i] = Integer.parseInt(input[i]);
	            set.add(b[i]);
	        }
	        
	        //Sort the first array to get pairs in desired order
	        Arrays.sort(a);
	        
	        //Find all pairs 
	        for(int i=0; i<n; i++)
	        {
	            if(set.contains(x-a[i]))
	            {
	                output.append(a[i] + " " + (x-a[i]) + ", ");
	            }
	        }
	        
	        if(output.length()==0)
	        {
	            System.out.println(-1);
	        }
	        
	        //Else remove the extra comma from the end and print
	        else
	        {
    	        output.delete(output.length()-2, output.length());
    	        System.out.println(output);
	        }
	    }
	}
}