//Elements of the first array that match elements of second array need to be printed
//In the order that they appear in the second array
//Store all elements of first array along with their counts in a map
//Iterate through second array and print the elements that are present in second array
//If any elements remain in the first array (map) that did not match second array, print them in sorted order
public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String[] input = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            //First and second input arrays
            int[] a = new int[n];
            int[] b = new int[m];
            
            StringBuilder output = new StringBuilder();

            //Map
            Map<Integer,Integer> map = new HashMap<>();
            
            input = br.readLine().trim().split("\\s+");
            
            for(int i=0;i<n;i++)
            {
                a[i] = Integer.parseInt(input[i]);
            }
            input = br.readLine().trim().split("\\s+");
            for(int i=0;i<m;i++)
            {
                b[i] = Integer.parseInt(input[i]);
            }
            
            //Map each element of first array to it's count
            for(int i=0;i<n;i++)
            {
                if(!map.containsKey(a[i]))
                {
                    map.put(a[i],1);
                }
                else
                {
                    map.put(a[i],map.get(a[i])+1);
                }
            }
            
            //Iterate through second array whilst checking map 
            //If element exists in map, print it for each occurrence
            for(int i=0;i<m;i++)
            {
                if(map.containsKey(b[i]))
                {
                    int count = map.get(b[i]);
                    while(count-->0)
                    {
                        output.append(b[i]+" ");
                    }
                    map.remove(b[i]);
                }
            }
            
            //If any elements left in map (elements of first arr that didn't match second arr)
            //Print them in sorted order
            List<Integer> list = new ArrayList<>();
            if(map.size()>0)
            {
                for(Map.Entry<Integer,Integer> entry : map.entrySet())
                {
                    int count = entry.getValue();
                    while(count-->0) list.add(entry.getKey());
                }
                Collections.sort(list);
                for(int i : list)
                {
                    output.append(i+" ");
                }
            }
            System.out.println(output);
        }
    }