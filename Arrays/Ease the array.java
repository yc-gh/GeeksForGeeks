//Approach -- copy only required elements with modifications to a new array
//Read each element of input
//If element is 0, skip 
//If element matches next element, copy double of this element and skip next element
//Any other (non zero) element is copied
public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while(t-->0)
    {
        int n = Integer.parseInt(br.readLine().trim());
        String[] input = br.readLine().trim().split("\\s+");
        //One extra element kept for ensuring comparisons to not cross bounds
        int[] a = new int[n+1];
        int[] res = new int[n];
        int i = 0;
        int k = 0;
        for(;i<n;i++)
        {
            a[i]=Integer.parseInt(input[i]);
        }
        for(i=0;i<n;i++)
        {
            //If element is 0, dont copy to result array
            if(a[i]==0) continue;
            //If element matches next element, copy element*2 and skip next index
            //Since the input array is kept one size extra, i+1 stays within bounds
            if(a[i]==a[i+1]) 
            {
                res[k++] = a[i]*2;
                i++;
            }
            //Else copy the element
            else res[k++] = a[i];
        }
        StringBuilder output = new StringBuilder();
        for(int j : res)
        {
            output.append(j+" ");        
        }
        System.out.println(output);
    }
}