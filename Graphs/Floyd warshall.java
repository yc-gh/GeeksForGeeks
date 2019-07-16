class GFG
 {
    static void printSolution(int[][] dist, int v)
    {
        StringBuilder output = new StringBuilder();
        
        for(int i=0; i<v; i++)
        {
            for(int j=0; j<v; j++)
            {
                if(dist[i][j] == 10000000)
                {
                    output.append("INF ");
                }
                else
                {
                    output.append(dist[i][j] + " ");
                }
            }
            output.append("\n");
        }
        
        System.out.print(output);
    }
     
    static void floydWarshall(int[][] graph, int v)
    {
        //Save all minimum distances for each vertex
        int[][] dist = new int[v][v];
        
        //Initially all vertices have paired distance as given in input graph
        for(int i=0; i<v; i++)
        {
            for(int j=0; j<v; j++)
            {
                dist[i][j] = graph[i][j];
            }
        }
        
        //Calculate distance between each pair of vertices through an intermediate vertex 
        for(int k=0; k<v; k++)
        {
            for(int i=0; i<v; i++)
            {
                for(int j=0; j<v; j++)
                {
                    //If distance from i to k + k to j is less than distance from i to j
                    //Then this is the new shortest path b/w i and j
                    if(dist[i][k] + dist[k][j] < dist[i][j])
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        printSolution(dist, v);
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int v = Integer.parseInt(br.readLine().trim());    
	        int[][] graph = new int[v][v];
	        //Read V lines of input for each vertex
	        for(int i=0; i<v; i++)
	        {
	            String[] input = br.readLine().trim().split("\\s+");
	            for(int j=0; j<v; j++)
	            {
	                graph[i][j] = Integer.parseInt(input[j]);
	            }
	        }
	        floydWarshall(graph, v);
	    }
	 }
}