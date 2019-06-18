    public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        Deque<Integer> stack = new ArrayDeque<>();
			
			//Push all array elements to stack in reverse order
	        for(int i=n-1;i>=0;i--)
	        {
	            stack.push(Integer.parseInt(input[i]));
	        }
			
			StringBuilder output = new StringBuilder();
			
			//While stack has elements, pop one element and compare it with top element
	        while(!stack.isEmpty())
	        {
	            int a = stack.pop();
	            //If stack becomes empty before another element can be popped
	            //Meaning last element reached
	            //Append -1
	            if(stack.isEmpty()) output.append("-1");
	            //Else peek the stack and compare it to popped element
	            else
	            {
    	            int b = stack.peek();
    	            if(b<a) output.append(b+" ");
    	            else output.append("-1 ");
	            }
	        }
	        System.out.println(output);
	    }