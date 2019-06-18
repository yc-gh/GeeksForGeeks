//Combine both arrays, sort, find n largest elements
//Search and print second then first array elements matching those elements
public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            int[] b = new int[n];
            
            //Combine both arrays into a list
            List<Integer> list = new ArrayList<>();
            
            //Use set to store n largest elements
            Set<Integer> set = new HashSet<>();
            StringBuilder output = new StringBuilder();
            String[] input = br.readLine().trim().split("\\s+");
            for(int i=0;i<n;i++)
            {
                a[i] = Integer.parseInt(input[i]);
                list.add(a[i]);
            }
            input = br.readLine().trim().split("\\s+");
            for(int i=0;i<n;i++)
            {
                b[i] = Integer.parseInt(input[i]);
                list.add(b[i]);
            }
            //Sort list in reverse order
            Collections.sort(list,Collections.reverseOrder());
            //Add n largest elements 
            for(int i=0;i<2*n && set.size()<n;i++)
            {
                set.add(list.get(i));
            }
            //Print second array elements matching set elements
            for(int i=0;i<n && set.size()>0;i++)
            {
                if(set.contains(b[i]))
                {
                    output.append(b[i]+" ");
                    set.remove(b[i]);
                }
            }
            //Print first array elements matching set elements
            for(int i=0;i<n && set.size()>0;i++)
            {
                if(set.contains(a[i]))
                {
                    output.append(a[i]+" ");
                    set.remove(a[i]);
                }
            }
            System.out.println(output);
        }
    }