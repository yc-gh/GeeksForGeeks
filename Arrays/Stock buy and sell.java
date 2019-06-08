    //Starting from second day, compare to previous day
    //If smaller, this is the new buying day and previous is selling day
    //If buying and selling day are the same, they can't be considered
    //If last day is bigger than previous day, it is the last selling day
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        int[] a = new int[n];
	        for(int i=0;i<n;i++)
	        {
	            a[i] = Integer.parseInt(input[i]);
	        }
	        List<Integer> list = new ArrayList<>();
	        int buyday = 0;
	        int sellday = 0;
	        for(int i=1;i<n;i++)
	        {
	            int curr = i;
	            int prev = i-1;
	            if(a[curr]<a[prev])
	            {
	                sellday = prev;
	                if(buyday!=sellday)
	                {
	                    list.add(buyday);
	                    list.add(sellday);
	                }
	                buyday = curr;
	            }
	        }
	        if(a[n-1]>a[n-2])
	        {
	            list.add(buyday);
	            list.add(n-1);
	        }
	        if(list.isEmpty()) System.out.println("No Profit");
	        else
	        {
	            StringBuilder output = new StringBuilder();
	            int size = list.size();
	            for(int i=0;i<size;i+=2)
	            {
	                output.append("("+list.get(i)+" "+list.get(i+1)+") ");
	            }
	            System.out.println(output);
	        }
	    }
	 }