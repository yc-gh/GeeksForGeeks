class Implementation
{
    //TODO
    //If an adjacency list is provided, a min heap can be used at the step for finding min distance
    
    //Print all distances
    static void printDistance(int[] dist)
    {
        StringBuilder output = new StringBuilder();
        for(int i : dist)
        {
            output.append(i+" ");    
        }
        System.out.print(output);
    }
    
    //Get the min distance vertex not in shortest path set
    static int minDistance(int[] dist, boolean[] spSet, int V)
    {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for(int i=0; i<V; i++)
        {
            if(!spSet[i] && dist[i]<=minDist)
            {
                minIndex = i;
                minDist = dist[i];
            }
        }
        return minIndex;
    }
    
    static void dijkstra(ArrayList<ArrayList<Integer>> list, int src, int V)
    {
        //An array to keep track of all vertices for whom shortest path has been found
        boolean[] spSet = new boolean[V];
        
        //An array to keep track of min distance of each vertex
        int[] dist = new int[V]; 
        
        //Set initial distance of all vertices as infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        //Set distance of source vertex as 0
        dist[src] = 0;
        
        //While shortest path set doesn't contain all vertices
        for(int count=0; count<V-1; count++)
        {
            int u = minDistance(dist, spSet, V);
            
            //Mark this vertex as processed
            spSet[u] = true;
            
            //For each vertex adjacent to this vertex, 
            // update current vertex distance if it's not in spSet
            // current vertex distance is not infinity
            // destination distance from current vertex is not 0 (no edge b/w)
            // if dist of current + weight of edge b/w current and dest is < dist of dest
            for(int v=0; v<V; v++)
            {
                if(!spSet[v] && list.get(u).get(v)!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+list.get(u).get(v)<dist[v])
                {
                    dist[v] = dist[u] + list.get(u).get(v);    
                }
            }
        }
        
        //Print all distances
        printDistance(dist);
    }
}