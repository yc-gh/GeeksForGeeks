    //Akin to a hilly area -- 
    //if the height is X at a point and after some ups and downs, the height is back to X, then the hills in b/w might as well not exist
    //Keep track of this height using 'sum' 
    //If the sum reaches zero, increment count by 1 (1 subarray found)
    //If sum reaches a previously obtained sum, increment count by number of times the sum has been obtained
    //Increment count of sum each time it is obtained
    /*
    X  _         _ X                        X _       _     _ X
        \       /                              \     / \   /
         \     /     =  one subarray found      \   /   \_/      = 2(in b/w) + 1(the overall) subarrays found
          \   /                                  \_/
           \_/
    */
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        int[] a = new int[n];
	        for(int i=0;i<n;i++)
	        {
	            a[i] = Integer.parseInt(input[i]);
	        }
	        int sum = 0;
	        int count = 0;
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i=0;i<n;i++)
	        {
	            //Keep adding sum
	            sum += a[i];
	            //If sum reaches 0
	            if(sum == 0)
	            {
	                count++;
	            }
	            //If sum is not 0, check if it has been previously obtained 
	            if(map.containsKey(sum))
	            {
	                count += map.get(sum);
	            }
	            //Increment the count of sum or set 1 if not previously obtained
	            if(map.containsKey(sum))
	            {
	                map.put(sum,map.get(sum)+1);
	            }
	            else
	            {
	                map.put(sum,1);
	            }
	        }
	        System.out.println(count);
	    }
	 }