//Selection sort can also be used -- O(n^2)

//Graph solution shown here -- O(nlogn)
class GfG
{
	public static int minSwaps(int[] a, int n)
	{
	    //Store all elements and initial indices in a list
	    List<Integer[]> initPos = new ArrayList<>();
	    
	    for(int i=0; i<n; i++)
	    {
	        initPos.add(new Integer[]{a[i],i});
	    }
	    
	    //Keep a boolean array to keep track of visited indices
	    boolean[] vis = new boolean[n];
	    
	    //Sort the list according to array values
	    initPos.sort(new Comparator<Integer[]>()
	    {
	        @Override
	        public int compare(Integer[] o1, Integer[] o2)
	        {
	            if(o1[0] < o2[0])
	            {
	                return -1;
	            }
	            else if(o1[0].equals(o2[0]))
	            {
	                return 0;
	            }
	            else
	            {
	                return 1;
	            }
	        }
	        
	    });
	    
	    //Store result
	    int swaps = 0;
	    
	    //For each element in sorted array, count number of cycles
	    for(int i=0; i<n; i++)
	    {
	        //If index has already been visited or if element at index was already at correct index
	        //Nothing to be changed
	        if(vis[i] || initPos.get(i)[1]==i)
	        {
	            continue;
	        }
	        
	        //Else get cycle size = number of elements in the cycle 
	        int j = i;
	        int cycleSize = 0;
	        
	        while(!vis[j])
	        {
	            //Set current index as visited
	            vis[j] = true;
	            
	            //Move to the next index
	            //Using the values in the sorted list, get it's previous index
	            //Find the sorted list value at that index and move to it's next.. so on
	            //Till a visited index is reached
	            j = initPos.get(j)[1];
	            
	            //Each time this happens, cycle size increases
	            cycleSize++;
	        }
	        
	        //Number of swaps is cycleSize - 1 for each cycle
	        //ie. (sigma)(1 --> k)(cycleSize - 1) for k cycles
	        if(cycleSize > 0)
	        {
	            swaps += (cycleSize-1);
	        }
	    }
	    
	    return swaps;
    }
}