    //Use stack to store chars. Pop when a . or end of string is encountered
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String str = br.readLine().trim();
	        int length = str.length();
	        int i = 0;
	        Deque<Character> stack = new ArrayDeque<>();
	        StringBuilder newstr = new StringBuilder();
	        while(i < length)
	        {
	            char curr = str.charAt(i);
	            if(curr=='.')
	            {
	                while(!stack.isEmpty())
	                {
	                    newstr.append(stack.pop());
	                }
	                newstr.append('.');
	            }
	            else
	            {
	                stack.push(curr);
	            }
	            i++;
	        }
	        while(!stack.isEmpty())
	        {
	            newstr.append(stack.pop());
	        }
	        System.out.println(newstr);
	    }
	 }