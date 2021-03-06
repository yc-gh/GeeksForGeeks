class GFG
 {
    static class Activity implements Comparable<Activity>
    {
        int actNum;
        int start;
        int finish;
        
        Activity(int s, int f, int n)
        {
            actNum = n;
            start = s;
            finish = f;
        }
        
        //If finish times of two activities are equal, sort by their start times
        //Else by their finish times (in ascending order)
        public int compareTo(Activity a2)
        {
            if(this.finish == a2.finish)
            {
                return this.start - a2.start;
            }
            return this.finish - a2.finish;
        }
    }
    
    static String actSelect(String[] start, String[] finish, int n)
    {
        //Put all activites into a priority queue so that the activity with least finish time can be obtained after each selection
        PriorityQueue<Activity> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++)
        {
            pq.offer(new Activity(Integer.parseInt(start[i]), Integer.parseInt(finish[i]), i+1));
        }
        
        //Keep track of previous activity's finish time so that new activity chosen has start time >= prevFinish
        int prevFinish = 0;
        
        //Track order of activites (for answer)
        String res = "";
        
        while(!pq.isEmpty())
        {
            //Pick activity with least finish time from PriorityQueue
            Activity curr = pq.poll();
            
            //If this activity's start time is >= previous activity's finish time, we can select it
            if(curr.start >= prevFinish)
            {
                prevFinish = curr.finish;
                res += curr.actNum + " ";
            }
        }
        
        return res;
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] start = br.readLine().trim().split("\\s+");
	        String[] finish = br.readLine().trim().split("\\s+");
	        System.out.println(actSelect(start, finish, n));
	    }
	 }
}