class GFG
 {
    static boolean isSafe(int[][] board, int n, int row, int col)
    {
        //Check all previous columns if any queen has been placed on the same row
        for(int j=0; j<col; j++)
        {
            if(board[row][j]==1)
            {
                return false;
            }
        }
        
        //Check right diagonal -> \
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--)
        {
            if(board[i][j]==1)
            {
                return false;
            }
        }
        
        //Check left diagonal -> /
        for(int i=row+1, j=col-1; i<n && j>=0; i++, j--)
        {
            if(board[i][j]==1)
            {
                return false;
            }
        }
        
        return true;
    }
     
    static void nQueens(int[][] board, int n, int col, String res, StringBuilder output)
    {
        //If queens were placed in all columns
        if(col >= n)
        {
            output.append(res+"] ");
            return;
        }
        
        
        //For each row in current column, check if a queen can be placed safely
        for(int row=0; row<n; row++)
        {
            if(isSafe(board, n, row, col))
            {
                //If queen can be placed in the current row, mark it on the board
                board[row][col] = 1;
                
                //Recursively check combinations with subsequent columns
                nQueens(board, n, col+1, res+(row+1)+" ", output);
                
                //Backtrack
                //Undo the mark on current row and try next
                board[row][col] = 0;
            }
        }
        
        return;
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        int[][] board = new int[n][n];
	        int[] queens = new int[n];
            
            //Use a string builder to store all possible combinations instead of messing around with return values
	        StringBuilder output = new StringBuilder();
	        
	        nQueens(board, n, 0, "[", output);
	        
	        //If no combinations found
	        if(output.length()==0)
	        {
	            System.out.println("-1");
	        }
	        else
	        {
	            System.out.println(output);
	        }
	    }
	 }
}