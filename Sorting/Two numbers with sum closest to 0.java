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
			
			//Sort the array
	        Arrays.sort(a);
			
			//Keep two pointers starting at first and last index
	        int left=0;
	        int right=n-1;
			
			//Initialize minimum sum
	        int minsum = a[left]+a[right];
			
			//Till pointers haven't crossed (till all elements read)
	        while(left<right)
	        {
	            //Evaluate sum of elements at left and right indices
	            int sum = a[left] + a[right];
	            //Compare absolute sum with minsum
	            if(Math.abs(sum) < Math.abs(minsum)) minsum = sum;
	            //If the temp sum is negative, move left so that a smaller negative sum can be obtained
	            if(sum < 0) left++;
	            //Else if temp sum is positive, move right so that a smaller positive sum can be obtained 
	            else if(sum > 0) right--;
	            //Else if temp sum is 0, no further checking required
	            else break;
	        }
	        System.out.println(minsum);
	    }
	 }