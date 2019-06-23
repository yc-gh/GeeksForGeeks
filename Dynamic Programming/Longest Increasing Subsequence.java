//Recursive solution
static int lis(int[] a,int[][] memo,int previndex,int currindex)
{
    //If current index has reached end of array
    if(currindex==a.length)
    {
        return 0;
    }
    
    //Fetch cached solution if available
    if(memo[previndex+1][currindex]>=0)
    {
        return memo[previndex+1][currindex];
    }
    
    int taken = 0;
    
    //Calculate lis with current element excluded
    int nottaken = lis(a,memo,previndex,currindex+1);
    
    //If current index is first index of array
    //Or if current element is greater than previous
    //Calculate lis with current element included
    if(previndex<0 || a[currindex]>a[previndex])
    {
        taken = 1 + lis(a,memo,currindex,currindex+1);
    }
    
    //lis from current index is max of taken,nottaken
    //Cache the result for future use
    memo[previndex+1][currindex] = Math.max(taken,nottaken);
    
    return memo[previndex+1][currindex];
}

public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim()); 
            String[] input = br.readLine().trim().split("\\s+");
            int[] a = new int[n];
            
            //Input array
            for(int i=0;i<n;i++)
            {
                a[i] = Integer.parseInt(input[i]);
            }
            
            //Array to cache method results
            int[][] memo = new int[a.length+1][a.length];
            
            //Initialize memoization array with -1
            for(int[] i : memo)
            {
                Arrays.fill(i,-1);
            }
            
            System.out.println(lis(a,memo,-1,0));
        }
    }