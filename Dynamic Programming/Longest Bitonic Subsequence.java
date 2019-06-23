//Recursion with memoization
static int lbs(int[] a,int[][] memo,int previndex,int currindex,char direction)
{
    //Base case 
    //Reached end of array
    if(currindex == a.length)
    {
        return 0;
    }
    
    //If bitonic sequence is currently increasing phase
    //Fetch solution if cached
    if(direction=='i')
    {
        if(memo[previndex+1][currindex]>=0)
        {
            return memo[previndex+1][currindex];
        }
    }
    
    //If bitonic sequence is currently in decreasing phase
    //Fetch solution if cached
    else
    {
        if(memo[a.length+previndex+1][a.length+currindex]>=0)
        {
            return memo[a.length+previndex+1][a.length+currindex];
        }
    }
    
    //If solution is not cached
    //Current index element can be included in sequence or excluded
    
    //Length if element is taken
    int taken = 0;
    
    //Lbs if element is not taken
    //Calculate lbs with element excluded
    int nottaken = lbs(a,memo,previndex,currindex+1,direction);
    
    //Calculate lbs with element included
    //If sequence is increasing
    if(direction=='i')
    {
        //If this is first index of array 
        //i.e previous index = -1 
        //Then include this element without any checking
        //Or if current element is greater than previous, 
        //Calculate lbs of remaining sequence with this element included with same direction (increasing)
        if(previndex==-1 || a[currindex]>a[previndex])
        {
            taken = 1 + lbs(a,memo,currindex,currindex+1,direction);
        }
        
        //Else if current element matches previous element
        //This element cannot be included
        else if(a[currindex]==a[previndex])
        {
            taken = 0;
        }
        
        //Else (if current element is decreasing)
        //Calculate lbs with this element included 
        else
        {
            taken = 1 + lbs(a,memo,currindex,currindex+1,'d');
        }
        
        //Max of taken,nottaken indicate max length bs starting from this index 
        //Save this result for future recursive calls (WITH INCREASING)
        //Increasing and decreasing method results are stored at seperate indexes
        memo[previndex+1][currindex] = Math.max(taken,nottaken);
        
        //Return the max length bs from this index
        //Still increasing phase
        return memo[previndex+1][currindex];
    }
    
    //Else if sequence is decreasing
    else
    {
        //If current element is >= previous element
        //This element can't be included
        if(a[currindex]>=a[previndex])
        {
            taken = 0;
        }
        
        //Else if this element is < previous element
        //This element can be included
        else
        {
            taken = 1 + lbs(a,memo,currindex,currindex+1,direction);
        }
        
        //Save result for future recursive calls (WITH DECREASING)
        memo[a.length+previndex+1][a.length+currindex] = Math.max(taken,nottaken);
        
        //Return the max length bs from this index 
        //Decreasing phase
        return memo[a.length+previndex+1][a.length+currindex];
    } 
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
            //Two different method returns are possible for each method 
            //Create double size array to store them seperately
            int[][] memo = new int[a.length*2+1][a.length*2];
            
            //Initialize memoization array with -1
            for(int[] i : memo)
            {
                Arrays.fill(i,-1);
            }
            
            System.out.println(lbs(a,memo,-1,0,'i'));
        }
    }