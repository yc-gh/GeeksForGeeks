class GfG{
    
    static boolean isValid(int[][] m, int n, int x, int y, boolean[][] vis)
    {
        if(x>=0 && x<n && y>=0 && y<n && m[x][y]==1 && !vis[x][y])
        {
            return true;
        }
        return false;
    }
    
    static void findPath(int[][] m, int n, int x, int y, boolean[][] vis, String path, ArrayList<String> res)
    {
        //If final square is reached
        if(x==n-1 && y==n-1)
        {
            res.add(path);
            return;
        }
        
        if(isValid(m, n, x, y, vis))
        {        
            //Set visited true so that this square isn't traversed again in the current path
            vis[x][y] = true;
            
            //Find paths from current square
            findPath(m, n, x+1, y, vis, path+"D", res);
            findPath(m, n, x, y+1, vis, path+"R", res);
            findPath(m, n, x-1, y, vis, path+"U", res);
            findPath(m, n, x, y-1, vis, path+"L", res);
            
            //Backtrack
            vis[x][y] = false;
        }
        
        return;
    }
    
    public static ArrayList<String> printPath(int[][] m, int n)
    {
        ArrayList<String> res = new ArrayList<>();
        
        boolean[][] vis = new boolean[n][n];
        
        findPath(m, n, 0, 0, vis, "", res);
        
        Collections.sort(res);
        
        return res;
    }
}