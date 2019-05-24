public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine().trim());
		    String[] input = br.readLine().trim().split("\\s+");
		    int zeroes=0,ones=0,twos=0;
		    //Count number of 0s,1s,2s in input
		    for(int i=0;i<n;i++)
		    {
		        int curr = Integer.parseInt(input[i]);
		        if(curr==0) zeroes++;
		        else if(curr==1) ones++;
		        else twos++;
		    }
		    //Print them in required order or store in array
		    StringBuilder output = new StringBuilder();
		    while(zeroes-->0) output.append("0 ");
		    while(ones-->0) output.append("1 ");
		    while(twos-->0) output.append("2 ");
		    System.out.println(output);
		}
	}