    //Counting occurrence of each number using an array with size of max element
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine().trim());
		    String[] input = br.readLine().trim().split("\\s+");
		    int[] count = new int[(int)Math.pow(10,6)+1];
		    int size = count.length;
		    boolean flag = false;
		    for(int i=0;i<n;i++)
		    {
		        count[Integer.parseInt(input[i])]++;
		    }
		    for(int i=0;i<size;i++)
		    {
		        if(count[i]>n/2) 
		        {
		            System.out.println(i);
		            flag=true;
		            break;
		        }
		    }
		    if(flag!=true) System.out.println("-1");
		}
	}