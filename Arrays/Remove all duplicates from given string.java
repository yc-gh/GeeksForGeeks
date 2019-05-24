public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
		    String input = br.readLine().trim();
		    //HashSet does not maintain order of elements during insertion
		    //LinkedHashSet maintains the order, useful for output in the same order
		    Set<Character> set = new LinkedHashSet<>();
		    for(Character c : input.toCharArray())
		    {
		        set.add(c);
		    }
		    StringBuilder output = new StringBuilder();
		    for(char c : set)
		    {
		        output.append(c);
		    }
		    System.out.println(output);
		}
	}