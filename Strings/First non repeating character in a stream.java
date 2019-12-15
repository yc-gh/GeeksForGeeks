	//First non repeated character in a set of strings? 
	
	//Keep adding non repeated characters to a list
    //And keep track of repeated characters using a boolean array
    //Remove element from list if it is repeated
    //Print first element from list
	class Gfg
	{
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
	}
	

	//First non repeated character in a stream of characters 
	// https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/

	public class NonReapeatingC { 
		final static int MAX_CHAR = 256; 
	  
		static void findFirstNonRepeating() 
		{ 
			//ArrayList is a DLL
			// inDLL[x] contains pointer to a DLL node if x is present 
			// in DLL. If x is not present, then inDLL[x] is NULL 
			List<Character> inDLL = new ArrayList<Character>(); 
	  
			// repeated[x] is true if x is repeated two or more times. 
			// If x is not seen so far or x is seen only once. then 
			// repeated[x] is false 
			boolean[] repeated = new boolean[MAX_CHAR]; 
	  
			// Let us consider following stream and see the process 
			String stream = "geeksforgeeksandgeeksquizfor"; 
			for (int i = 0; i < stream.length(); i++) { 
				char x = stream.charAt(i); 
				System.out.println("Reading " + x + " from stream n"); 
	  
				// We process this character only if it has not occurred 
				// or occurred only once. repeated[x] is true if x is 
				// repeated twice or more.s 
				if (!repeated[x]) { 
					// If the character is not in DLL, then add this at 
					// the end of DLL. 
					if (!(inDLL.contains(x))) { 
						inDLL.add(x); 
					} 
					else // Otherwise remove this character from DLL 
					{ 
						inDLL.remove((Character)x); 
						repeated[x] = true; // Also mark it as repeated 
					} 
				} 
	  
				// Print the current first non-repeating character from 
				// stream 
				if (inDLL.size() != 0) { 
					System.out.print("First non-repeating character so far is "); 
					System.out.println(inDLL.get(0)); 
				} 
			} 
		} 
	  
		/* Driver program to test above function */
		public static void main(String[] args) 
		{ 
			findFirstNonRepeating(); 
		} 
	} 