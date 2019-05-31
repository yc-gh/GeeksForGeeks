    //Approach -- 
    //Can pick each element and search all remaining elements for required element using array/map
    //Map -- insert all elements in map along with number of occurrences. Subtract occurrence for each read element 
    //Set -- Read each element, if required element not in set, insert current element into set
    //Set approach searches previously read elements for the required element 
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
		    String[] input = br.readLine().trim().split("\\s+");
		    int n = Integer.parseInt(input[0]);
		    int x = Integer.parseInt(input[1]);
		    input = br.readLine().trim().split("\\s+");
		    int[] a = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i] = Integer.parseInt(input[i]);
		    }
		    Set<Integer> set = new HashSet<>();
		    boolean flag=false;
		    for(int i=0;i<n;i++)
		    {
		        int curr = a[i];
		        int req_ele = x - curr;
                if(set.contains(req_ele))
		        {
		            flag=true;
		            break;
		        }
		        else
		        {
		            set.add(a[i]);
		        }
		    }
		    System.out.println(flag ? "Yes" : "No");
		}
	}