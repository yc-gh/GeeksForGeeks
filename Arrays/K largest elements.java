    //Using counting array ~ 1.21 sec
    //Using priority queue ~1.65 sec
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String[] input = br.readLine().trim().split("\\s+");
	        int n = Integer.parseInt(input[0]);
	        int k = Integer.parseInt(input[1]);
	        input = br.readLine().trim().split("\\s+");
	        PriorityQueue pq = new PriorityQueue(n,Collections.reverseOrder());
	        for(String i : input)
	        {
	            pq.add(Integer.parseInt(i));
	        }
	        while(k-->0)
	        {
	            System.out.print(pq.poll()+" ");
	        }
	        System.out.println();
	    }
	}