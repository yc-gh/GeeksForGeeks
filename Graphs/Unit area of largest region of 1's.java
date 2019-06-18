//Similar to finding islands problem
//For each cell, add count (area) of all 8 adjacent cells to it's count (1)
//Compare with area of all other components

static boolean isSafe(int[][] cells,int row,int col,boolean[][] visited)
{
    //Check if cell is within bounds, has a 1 and has not been visited
    //Only then the cell will be traversed
    return (row>=0) && (row<cells.length) && (col>=0) && (col<cells[0].length) && (cells[row][col]==1) && (!visited[row][col]);
}

static int DFS(int[][] cells,int row,int col,boolean[][] visited)
{
    //Set current cell as visited
    visited[row][col] = true;
    
    //Each neighbour of current cell is traversed using these arrays
    int[] rowNums = {-1,-1,-1,0,0,1,1,1};
    int[] colNums = {-1,0,1,-1,1,-1,0,1};
    int count = 1;
    
    //Traverse all it's neighbours
    for(int k=0;k<8;k++)
    {
        //Check if the neighbour cell should be checked 
        if(isSafe(cells,row+rowNums[k],col+colNums[k],visited))
        {
            //Recursively traverse adjacent cells
            //Add the count of adjacent cells to current count
            count += DFS(cells,row+rowNums[k],col+colNums[k],visited);
        }
    }
    return count;
}
static int findComponents(int[][] cells, int n, int m)
{
    boolean[][] visited = new boolean[n][m];
    int currcount = 0,maxcount = 0;
    
    //For each cell in the matrix that is 1 and is not visited, perform DFS 
    //Whenever an unvisited 1 is found, it is an island
    //The DFS traversal will visit all it's adjacent 1's recursively
    //Therefore creating a component (subgraph) of connects 1's
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(cells[i][j]!=0 && !visited[i][j])
            {
                currcount = DFS(cells,i,j,visited);
                if(currcount > maxcount) maxcount = currcount;
            }
        }
    }
    return maxcount;
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
        int[][] cells = new int[n][m];
        input = br.readLine().trim().split("\\s+");
        int k=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                cells[i][j] = Integer.parseInt(input[k++]);
            }
        }
        System.out.println(findComponents(cells,n,m));
    }
    }