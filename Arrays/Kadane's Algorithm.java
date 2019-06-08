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
            int maxsum = a[0];
            int tempsum = a[0];
            //Add each element to sum
            //Compare current element with sum up to (including) current element
            //If previous section had a negative sum, this element is greater (dont include negative section)
            //Else sum will be greater
            //Compare to max sum
            for(int i=1;i<n;i++)
            {
                tempsum = Math.max(a[i],tempsum+a[i]);
                maxsum = Math.max(maxsum,tempsum);
            }
	        System.out.println(maxsum);
	    }
	 }