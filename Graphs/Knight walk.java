//BFS traversal while keeping track of previously traversed cells will give shortest path
static class Cell
{
    int x,y;
    int steps;
    Cell(int x, int y, int steps)
    {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}

//Check if cell is within bounds of chessboard
static boolean isSafe(int r,int c,int n,int m,boolean[][] visited)
{
    return (r>=1) && (r<=n) && (c>=1) && (c<=m) && (visited[r][c]==false);    
}

static int findMoves(int n,int m,int[] src,int[] dest)
{
    //Indexing in the question starts from 1
    boolean[][] visited = new boolean[n+1][m+1];
    
    //Indexes for possible knight movements
    int[] rowNums = {-1,-2,-2,-1,1,2,2,1};
    int[] colNums = {-2,-1,1,2,-2,-1,1,2};
    
    Deque<Cell> queue = new ArrayDeque<>();
    
    //Offer first cell
    queue.offer(new Cell(src[0],src[1],0));
    
    visited[src[0]][src[1]]=true;
    
    while(!queue.isEmpty())
    {
        //Pop front
        Cell curr = queue.poll();
        int x = curr.x;
        int y = curr.y;
        int steps = curr.steps;
        
        //If the current position matches destination
        if(x==dest[0] && y==dest[1])
        {
            return steps;
        }
        
        //Offer all valid adjacent positions
        for(int i=0;i<8;i++)
        {
            int newX = x + rowNums[i];
            int newY = y + colNums[i];
            if(isSafe(newX,newY,n,m,visited))
            {
                visited[newX][newY]=true;
                queue.offer(new Cell(newX,newY,steps+1));
            } 
        }
    }
    
    //If destination cannot be reached 
    return -1;
}
public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String[] input = br.readLine().trim().split("\\s+");
            
            //Read bounds
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            input = br.readLine().trim().split("\\s+");
            
            int[] src = new int[2];
            int[] dest = new int[2];
            
            //Read source and destination
            src[0] = Integer.parseInt(input[0]);
            src[1] = Integer.parseInt(input[1]);
            dest[0] = Integer.parseInt(input[2]);
            dest[1] = Integer.parseInt(input[3]);
            System.out.println(findMoves(n,m,src,dest));
        }
    }