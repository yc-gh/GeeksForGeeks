//This approach is n^3
//A n^2logn approach is available. Didn't work due to some issue with iteration order of map
//A n^2 approach is possible by hashing sum of all pairs along with their indices
//Search the hashmap for each possible sum such that all indices are unique

//Loop through the array and check for sum == k
public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String[] input = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            input = br.readLine().trim().split("\\s+");
            int[] a = new int[n];
            for(int i=0;i<n;i++)
            {
                a[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(a);
            Set<String> set = new LinkedHashSet<>();
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n-3;i++)
            {
                for(int j=i+1;j<n-2;j++)
                {
                    int l=j+1;
                    int r=n-1;
                    while(l<r)
                    {
                        if(a[i]+a[j]+a[l]+a[r] == k)
                        {
                            String temp = a[i]+" "+a[j]+" "+a[l]+" "+a[r]+" "+"$";
                            set.add(temp);
                            l++;
                            r--;
                        }
                        else if(a[i]+a[j]+a[l]+a[r] < k) l++;
                        else r--;
                    }
                }
            }
            if(set.size()==0) output.append(-1);
            else
            {
                for(String str : set)
                {
                    output.append(str);
                }
            }
            System.out.println(output);
        }
    }