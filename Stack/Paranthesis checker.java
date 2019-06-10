    //If stack is empty, push character
    //If stack is not empty, check if paranthesis matches it's equivalent on the top of stack
    //If yes, pop from stack
    //Else push paranthesis to stack
    //Finally, if stack is empty, string is balanced
    //Else not balanced
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        char[] input = br.readLine().trim().toCharArray();
	        int length = input.length;
	        Deque<Character> stack = new ArrayDeque<>();
	        for(int i=0;i<length;i++)
	        {
	            char c = input[i];
	            if(stack.isEmpty())
	            {
	                stack.push(c);
	            }
	            else
	            {
    	            if(c=='(' || c=='{' || c=='[')
    	            {
    	                stack.push(c);
    	            }
    	            else
    	            {
    	                char stacktop = stack.peek();
    	                switch(c)
    	                {
    	                    case ')' : 
    	                    {
    	                        if(stacktop=='(') stack.pop();
    	                        else stack.push(c);
    	                        break;
    	                    }
    	                    case '}' : 
    	                    {
    	                        if(stacktop=='{') stack.pop();
    	                        else stack.push(c);
    	                        break;
    	                    }
    	                    case ']' : 
    	                    {
    	                        if(stacktop=='[') stack.pop();
    	                        else stack.push(c);
    	                        break;
    	                    }
    	                }
    	            }
	            }
	        }
	        if(stack.isEmpty()) System.out.println("balanced");
	        else System.out.println("not balanced");
	    }
	 }