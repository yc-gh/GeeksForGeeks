import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
    //Each cell of matrix is stored as a cell with distance from source
    static class Cell
    {
        int row;
        int col;
        
        Cell(int r, int c)
        {
            row = r;
            col = c;
        }
    }
    
    //Check if matrix cell is within bounds, is 1 and hasn't been visited
    static boolean isValid(int x, int y, int[][] grid, boolean[][] visited)
    {
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]!=0 && !visited[x][y])
        {
            return true;
        }
        
        return false;
    }
     
    static int shortestPath(int[][] grid, int destX, int destY, Cell source)
    {
        //If source itself is 0, can't make a path from source
        if(grid[source.row][source.col] == 0)
        {
            return 0;
        }
        
        //If the destination is at source
        if(destX==source.row && destY==source.col)
        {
            return 1;
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
                        return 1;
                    }
                    
                    //Set visited for this adjacent cell and add it to queue
                    visited[newX][newY] = true;
                    queue.offer(new Cell(newX, newY));    
                }
            }
        }
        
        //If destination can't be reached
        return 0;
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String[] input = br.readLine().trim().split("\\s+");
	        int n = Integer.parseInt(input[0]);
	        input = br.readLine().trim().split("\\s+");
	        int[][] grid = new int[n][n];
	        int sourceX=0, sourceY=0, destX=0, destY=0;
	        for(int i=0; i<n; i++)
	        {
	            for(int j=0; j<n; j++)
	            {
	                grid[i][j] = Integer.parseInt(input[i*n+j]);
	                if(grid[i][j] == 1)
	                {
	                    sourceX = i;
	                    sourceY = j;
	                }
	                else if(grid[i][j] == 2)
	                {
	                    destX = i;
	                    destY = j;
	                }
	            }
	        }
	        
	        Cell source = new Cell(sourceX, sourceY);
	        
	        System.out.println(shortestPath(grid, destX, destY, source));
	    }
	 }
}