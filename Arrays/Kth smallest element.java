class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Read number of test cases
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    //Read number of elements
		    int n = Integer.parseInt(br.readLine());
		    //Create an array of size == max element(as per constraints)
		    int size = (int)Math.pow(10,5)+1;
		    int[] countarr = new int[size];
		    String line = br.readLine(); 
            String[] str = line.trim().split("\\s+");
            //Read each element from the string into a counting array at the numbers index
		    for(int i=0;i<n;i++)
		    {
		        int ele = Integer.parseInt(str[i]);
		        countarr[ele]++;
		    }
		    int j=0;
		    //Read k and print kth smallest element by iterating through the counting array
		    int k= Integer.parseInt(br.readLine());
		    for(;j<size;j++)
		    {
		        if(k==0) break;
		        if(countarr[j]>0) k--;
		    }
		    System.out.println(j-1);
		}
	}
}