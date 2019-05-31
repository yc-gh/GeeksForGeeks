    //Store all array elements in 3 sets
    //Print intersection of sets
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String[] input = br.readLine().trim().split("\\s+");
	        int n1 = Integer.parseInt(input[0]);
	        int n2 = Integer.parseInt(input[1]);
	        int n3 = Integer.parseInt(input[2]);
	        
	        Set<Integer> set1 = new LinkedHashSet<>();
	        Set<Integer> set2 = new LinkedHashSet<>();
	        Set<Integer> set3 = new LinkedHashSet<>();
	        
	        input = br.readLine().trim().split("\\s+");
	        for(int i=0;i<n1;i++)
	        {
	            set1.add(Integer.parseInt(input[i]));
	        }
	        
	        input = br.readLine().trim().split("\\s+");
	        for(int i=0;i<n2;i++)
	        {
	            set2.add(Integer.parseInt(input[i]));
	        }
	        
	        input = br.readLine().trim().split("\\s+");
	        for(int i=0;i<n3;i++)
	        {
	            set3.add(Integer.parseInt(input[i]));
	        }
	        
	        set2.retainAll(set3);
	        set1.retainAll(set2);
	        if(set1.isEmpty()) System.out.println(-1);
	        else
	        {
    	        StringBuilder output = new StringBuilder();
    	        for(int i : set1)
    	        {
    	            output.append(i+" ");
    	        }
    	        System.out.println(output);
	        }
	    }