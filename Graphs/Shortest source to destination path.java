class GFG
 {
     
    //Each cell of matrix is stored as a cell with distance from source
    static class Cell
    {
        int row;
        int col;
        int dist;
        
        Cell(int r, int c, int d)
        {
            row = r;
            col = c;
            dist = d;
        }
    }
    
    //Check if matrix cell is within bounds, is 1 and hasn't been visited
    static boolean isValid(int x, int y, int[][] grid, boolean[][] visited)
    {
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1 && !visited[x][y])
        {
            return true;
        }
        
        return false;
    }
     
    static int shortestPath(int[][] grid, int destX, int destY, Cell source)
    {
        //If source itself is 0, can't make a path from source
        if(grid[0][0] == 0)
        {
            return -1;
        }
        
        //If the destination is at source
        if(destX==0 && destY==0)
        {
            return 0;
        }
        
        if(grid[destX][destY] == 0)
        {
            return -1;
        }
        
        //BFS
        Deque<Cell> queue = new ArrayDeque<>();
        
        //Visited array
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        //Cached values for adjacent cell indices
        int[] adjRow = {0,-1,1,0};
        int[] adjCol = {-1,0,0,1};
        
        //Set source as visited
        visited[source.row][source.col] = true;
        
        queue.offer(source);
        
        while(!queue.isEmpty())
        {
            Cell curr = queue.poll();
            
            for(int i=0; i<4; i++)
            {
                int newX = curr.row + adjRow[i];
                int newY = curr.col + adjCol[i];
                
                //Check if adjacent cell is valid before adding it to path
                if(isValid(newX, newY, grid, visited))
                {
                    //If destination cell is found, and it is valid
                    if(newX == destX && newY==destY)
                    {
                        return curr.dist + 1;
                    }
                    
                    //Set visited for this adjacent cell and add it to queue
                    visited[newX][newY] = true;
                    queue.offer(new Cell(newX, newY, curr.dist+1));    
                }
            }
        }
        
        //If destination can't be reached
        return -1;
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String[] input = br.readLine().trim().split("\\s+");
	        int n = Integer.parseInt(input[0]);
	        int m = Integer.parseInt(input[1]);
	        input = br.readLine().trim().split("\\s+");
	        int[][] grid = new int[n][m];
	        for(int i=0; i<n; i++)
	        {
	            for(int j=0; j<m; j++)
	            {
	                grid[i][j] = Integer.parseInt(input[i*m+j]);
	            }
	        }
	        input = br.readLine().trim().split("\\s+");
	        int x = Integer.parseInt(input[0]);
	        int y = Integer.parseInt(input[1]);
	        
	        Cell source = new Cell(0, 0, 0);
	        
	        System.out.println(shortestPath(grid, x, y, source));
	    }
	 }
}