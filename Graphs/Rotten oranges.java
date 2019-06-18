//Approach --
//Using a modified BFS 
//Keep track of oranges that have rotten and will become rotten
//Update the time when each set of oranges gets rotten
//Finally, check if there's any fresh orange left

//Check if target cell is within bounds, has a fresh orange and hasn't rotted 
//It can be fresh but might have rotten true since the matrix isn't actually updated, only rotten keeps track
static boolean canRot(int[][] a,int row,int col,boolean[][] rotten)
    {
        return (row>=0) && (row<a.length) && (col>=0) && (col<a[0].length) && (a[row][col]==1) && (rotten[row][col]==false);     
    }

public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String[] input = br.readLine().trim().split("\\s+");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int k = 0;
            
            //Variable to keep track of time
            int time = -1;
            
            //Variable to keep track of fresh 
            int fresh = 0;
            
            //Row and col numbers for 4 directions of a cell
            //Clockwise order
            int[] rowNums = {0,-1,0,1};
            int[] colNums = {-1,0,1,0};
            
            //Array to keep track of rotten oranges
            boolean[][] rotten = new boolean[r][c];
            
            //Queue
            Deque<Integer[]> queue = new ArrayDeque<>();
            
            //Given matrix
            int[][] a = new int[r][c];
            input = br.readLine().trim().split("\\s+");
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    a[i][j] = Integer.parseInt(input[k++]);
                    
                    //While parsing input, if a rotten orange is found
                    //Set rotten to true
                    //Store the location as a temp array and enqueue
                    if(a[i][j]==2)
                    {
                        rotten[i][j] = true;
                        queue.offer(new Integer[]{i,j});
                    }
                    //If fresh, increment count of fresh oranges
                    else if(a[i][j]==1)
                    {
                        fresh++;    
                    }
                }
            }

            //Enqueue delimiter to indicate time
            queue.offer(new Integer[]{-1,++time});
            while(!queue.isEmpty())
            {
                while((queue.peek())[0]!=-1)
                {
                    Integer[] curr = queue.poll();
                    int row = curr[0];
                    int col = curr[1];
                    
                    //For each rotten orange, check it's four sides for any fresh orange
                    for(int i=0;i<4;i++)
                    {
                        //If fresh, it can rot
                        //Set rotten and enqueue
                        if(canRot(a,row+rowNums[i],col+colNums[i],rotten))
                        {
                            rotten[row+rowNums[i]][col+colNums[i]] = true;
                            queue.offer(new Integer[]{row+rowNums[i],col+colNums[i]});
                            fresh--;
                        }
                    }
                }
                
                //Dequeue the time delimiter
                Integer[] timedelim = queue.poll();
                
                //Get the time
                time = timedelim[1];
                
                //If there are rotten oranges left
                if(!queue.isEmpty())
                {
                    queue.offer(new Integer[]{-1,++time});
                }
            }
            
            //If any fresh oranges are left
            if(fresh>0)
            {
                time = -1;
            }
            System.out.println(time);
        }
    }