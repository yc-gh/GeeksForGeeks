class GFG
 {
    //A class for storing every cell's distance and vertex 
    static class Square
    {
        int vertex;
        int dist;
    }
     
    //Consider the board as a directed graph where each square can access it's next 6 squares
    //ie all 6 squares are adjacent to curr square
    //Find shortest path to last square using BFS
    //Any snake or ladder will change the adjacent square to it's jump destination

    static int minDiceThrows(int[] jumps, int n)
    {
        //Use BFS
        Deque<Square> queue = new ArrayDeque<>();
        
        //Keep track of visited squares so as to avoid modifying them again
        //Such as when a snake is encountered
        //Squares are numbered 1..n (n=30)
        boolean[] visited = new boolean[n+1];
        
        Square first = new Square();
        
        first.vertex = 1;
        first.dist = 0;
        
        
        visited[first.vertex] = true;
        
        //Keep this as a reference to last polled square
        Square last = new Square();
        
        queue.offer(first);
        
        while(!queue.isEmpty())
        {
            last = queue.poll();
            int v = last.vertex;
            
            if(v == n)
            {
                break;
            }
            
            for(int j=v+1; j<=v+6 && j<=n; j++)
            {
                
                if(visited[j] == false)
                {
                    Square nextSquare = new Square();
                    nextSquare.dist = last.dist + 1;
                    
                    visited[j] = true;
                    
                    if(jumps[j] != 0)
                    {
                        nextSquare.vertex = jumps[j];
                    }
                    else
                    {
                        nextSquare.vertex = j;
                    }
                    
                    queue.offer(nextSquare);
                }
            }
        }
        
        return last.dist;
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        //Squares are numbered 1..30
	        int[] jumps = new int[31];
	        
	        for(int i=0; i<2*n;i+=2)
	        {
	            jumps[Integer.parseInt(input[i])] = Integer.parseInt(input[i+1]);
	        }
	        System.out.println(minDiceThrows(jumps, 30));
	    }
	 }
}