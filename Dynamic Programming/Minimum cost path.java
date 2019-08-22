//Use modified Dijikstra's algorithm 
//For each cell, set the minimum distance for it's adjacent 4 cells comparing with previously set distance
class GFG
 {
    //Comparable interface has been used here instead of Comparator 
     
    //Store each cell in PriorityQueue as its coordinates and distance
    static class Cell implements Comparable<Cell>
    {
        int x;
        int y;
        int dist;
        
        Cell(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Cell c2)
        {
            // If distances are equal, compare x and y
            if(this.dist == c2.dist)
            {
                if(this.x != c2.x) 
                {
                    return this.x < c2.x ? -1 : 1;
                }
                else
                {
                    return this.y < c2.y ? -1 : 1;
                }
            }
            else
            {
                return this.dist < c2.dist ? -1 : 1;
            }
        }
    }
     
    static int minCost(int[][] grid, int n)
    {
        //Cached values for adjacent cells
        int[] adjRow = new int[]{0,-1,1,0};
        int[] adjCol = new int[]{-1,0,0,1};
        
        //Create a NxN matrix for storing distances from source
        int[][] dist = new int[n][n];
        
        //Set infinite distance for all other cells
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        //Set distance of top left (source) cell
        dist[0][0] = grid[0][0];
        
        //A sorted set for storing cells that are included in the shortest path 
        
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        // PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>()
        // {
        //     @Override
        //     public int compare(Cell c1, Cell c2)
        //     {
        //         //If distances are equal, compare x and y
        //         if(c1.dist == c2.dist)
        //         {
        //             if(c1.x != c2.x) 
        //             {
        //                 return c1.x < c2.x ? -1 : 1;
        //             }
        //             else
        //             {
        //                 return c1.y < c2.y ? -1 : 1;
        //             }
        //         }
        //         else
        //         {
        //             return c1.dist < c2.dist ? -1 : 1;
        //         }
        //     }
        // });
        
        //Add source cell to set
        pq.offer(new Cell(0, 0, grid[0][0]));
        
        while(!pq.isEmpty())
        {
            //Get the cell with least distance
            //This must be removed from the pqueue so that it isn't picked up again
            //The distance check condition ensures that this vertex won't pe picked up again
            Cell curr = pq.poll();
            
            int currX = curr.x;
            int currY = curr.y;

            for(int i=0; i<4; i++)
            {
                int newX = curr.x + adjRow[i];
                int newY = curr.y + adjCol[i];
                
                if(newX>=0 && newX<n && newY>=0 && newY<n)
                {
                    //If the distance from current cell to next cell is less than it's distance
                    if(dist[currX][currY] + grid[newX][newY] < dist[newX][newY])
                    {
                        //Remove next cell's entry from pqueue if it exists
                        //ie. if its distance was updated previously
                        if(dist[newX][newY]!=Integer.MAX_VALUE)
                        {
                            pq.remove(new Cell(newX, newY, dist[newX][newY]));
                        }
                        
                        //Update the distance for next cell
                        //and add to queue
                        dist[newX][newY] = dist[currX][currY] + grid[newX][newY];
                        pq.offer(new Cell(newX, newY, dist[newX][newY]));
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        int[][] grid = new int[n][n];
	        for(int i=0; i<n; i++)
	        {
	            for(int j=0; j<n; j++)
	            {
	                grid[i][j] = Integer.parseInt(input[i*n+j]);
	            }
	        }
	        System.out.println(minCost(grid, n));
	    }
	 }
}