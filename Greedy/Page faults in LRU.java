class GFG
 {
    static int pageFaults(int[] pages, int n, int capacity)
    {
        Set<Integer> set = new HashSet<>();
    
        Map<Integer,Integer> map = new HashMap<>();
        
        int pagefaults = 0;
        
        for(int i=0; i<n; i++)
        {
            //If page capacity hasn't been reached
            if(set.size() < capacity)
            {
                //If page set doesn't contain the page
                //Add it and increment page fault
                if(!set.contains(pages[i]))
                {
                    set.add(pages[i]);
                    pagefaults++;
                }
                
                //Insert or update mapping
                map.put(pages[i], i);
            }
            
            //Else if page capacity has been reached
            else
            {
                //If set doesn't contain new page
                if(!set.contains(pages[i]))
                {
                    //Remove least recently used page
                    int index = Integer.MAX_VALUE;
                    int lruPage = Integer.MIN_VALUE; //or 0 - this isn't compared to anything
                    Iterator<Integer> iter = set.iterator();
                    
                    //Check min index page from all pages
                    while(iter.hasNext())
                    {
                        int tempPage = iter.next();
                        if(map.get(tempPage) < index)
                        {
                            index = map.get(tempPage);
                            lruPage = tempPage;
                        }
                    }
                    
                    //Remove the lru page
                    set.remove(lruPage);
                    
                    //Add new page
                    set.add(pages[i]);
                    
                    //Increment page faults
                    pagefaults++;
                }
                
                //Add or update mapping 
                map.put(pages[i], i);
            }
        }
        
        return pagefaults;
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        int[] pages = new int[n];
	        for(int i=0; i<n; i++)
	        {
	            pages[i] = Integer.parseInt(input[i]); 
	        }
	        int capacity = Integer.parseInt(br.readLine().trim());
	        
	        System.out.println(pageFaults(pages, n, capacity));
	    }
	 }
}