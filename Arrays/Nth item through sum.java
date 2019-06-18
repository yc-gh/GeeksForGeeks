public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)    
		{
            String[] input = br.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            input = br.readLine().trim().split("\\s+");
            int[] a = new int[m];
            for(int i=0;i<m;i++)
            {
                a[i] = Integer.parseInt(input[i]);
            }
            int [] b = new int[n];
            input = br.readLine().trim().split("\\s+");
            for(int i=0;i<n;i++)
            {
                b[i] = Integer.parseInt(input[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            //Use tree set to store each added element in sorted order
            Set<Integer> set = new TreeSet<>();
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    set.add(a[i]+b[j]);
                }
            }
            boolean flag=false;
            
            //If set contains less than k(N) elements, Nth sum doesnt exist
            if(set.size()<k)
            {
                System.out.println(-1);
            }
            //Else iterate the set and print the Nth sum
            else
            {
                int count=0;
                Iterator iter = set.iterator();
                while(iter.hasNext())
                {
                    int ele = (int)iter.next();
                    if(++count==k)
                    {
                        System.out.println(ele);
                        break;
                    }
                }
            }
		}
	}