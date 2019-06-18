//Number of islands = number of distinct components of the graph consisting of 1's
//The idea is to repeatedly traverse all 1's that are next to (in 8 directions) to another 1 using DFS
//And mark them as visited (therefore, all 1's connected to starting vertex are visited in one traversal)
//Repeat for all other cells which have 1 and are not visited
//Whenever such a component is found, it is an island

static boolean isSafe(ArrayList<ArrayList<Integer>> list,int row,int col,boolean[][] visited)
{
    //Check if cell is within bounds, has a 1 and has not been visited
    //Only then the cell will be traversed
    return (row>=0) && (row<list.size()) && (col>=0) && (col<list.get(0).size()) && (list.get(row).get(col)==1) && (!visited[row][col]);
}

static void DFS(ArrayList<ArrayList<Integer>> list,int row,int col,boolean[][] visited)
{
    //Set current cell as visited
    visited[row][col] = true;
    
    //Each neighbour of current cell is traversed using these arrays
    int[] rowNums = {-1,-1,-1,0,0,1,1,1};
    int[] colNums = {-1,0,1,-1,1,-1,0,1};
    
    //Traverse all it's neighbours
    for(int k=0;k<8;k++)
    {
        //Check if the neighbour cell should be checked 
        if(isSafe(list,row+rowNums[k],col+colNums[k],visited))
        {
            //Recursively traverse adjacent cells
            DFS(list,row+rowNums[k],col+colNums[k],visited);
        }
    }
}
static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M)
{
    boolean[][] visited = new boolean[N][M];
    int count = 0;
    
    //For each cell in the matrix that is 1 and is not visited, perform DFS 
    //Whenever an unvisited 1 is found, it is an island
    //The DFS traversal will visit all it's adjacent 1's recursively
    //Therefore creating a component (subgraph) of connects 1's
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<M;j++)
        {
            if(list.get(i).get(j)!=0 && !visited[i][j])
            {
                count++;
                DFS(list,i,j,visited);
            }
        }
    }
    return count;
}