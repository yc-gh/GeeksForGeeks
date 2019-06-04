    //Create two new lists for odd and even numbers and print in required order
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine().trim());
		    String[] input = br.readLine().trim().split("\\s+");
		    List<Integer> odd = new ArrayList<>();
		    List<Integer> even = new ArrayList<>();
		    for(int i=0;i<n;i++)
		    {
		        int curr = Integer.parseInt(input[i]);
		        if(curr%2!=0)
		        {
		            odd.add(curr);
		        }
		        else
		        {
		            even.add(curr);
		        }
		    }
		    Collections.sort(odd);
		    Collections.sort(even);
		    Collections.reverse(odd);
            for(int i : odd) System.out.print(i+" ");
            for(int i : even) System.out.print(i+" ");
            System.out.println();
		}
		br.close();
	}