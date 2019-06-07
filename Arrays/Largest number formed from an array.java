    //Use a comparator to compare combinations of each pair of numbers
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        Arrays.sort(input,new Comparator<String>(){
	            @Override
	            public int compare(String left,String right)
	            {
	                String leftright = left + right;
	                String rightleft = right + left;
	                //If leftright is a bigger number, we left and right should retain ordering ie. return -1
	                //Else return 1 ie. invert ordering
	                return leftright.compareTo(rightleft) > 0 ? -1 : 1;
	            }
	        });
	       for(String i : input) System.out.print(i);
	       System.out.println();
	    }
	 }