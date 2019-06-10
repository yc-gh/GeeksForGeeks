    //Keep adding non repeated characters to a list
    //And keep track of repeated characters using a boolean array
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
            //ArrayList or LinkedList any will do
	        List<Character> list = new ArrayList<>();
	        //Keep boolean array for tracking whether any character has been repeated
	        //char = 1 byte = 8 bits = 256 possible characters
	        boolean[] repeated = new boolean[256];
	        StringBuilder output = new StringBuilder();
	        for(String str : input)
	        {
	            char curr = str.charAt(0);
	            //If character is not repeated
	            //If it is not in the list, add it
	            //Else remove it and set it's repeated true
	            //If character is repeated, nothing is done about it
                if(!repeated[curr])
                {
                    if(!list.contains(curr))
                    {
                        list.add(curr);
                    }
                    else
                    {
                        //Typecast to Character or else compiler will try to get the numeric value of char
                        list.remove((Character)curr);
                        repeated[curr]=true;
                    }
                }
                //If list is empty ie. no elements added or all removed because of repetition
                //Print -1
                if(list.isEmpty()) output.append("-1 ");
                //Else print the first non repeated character
                else output.append(list.get(0)+" ");
	        }
	        System.out.println(output);
	    }
	 }