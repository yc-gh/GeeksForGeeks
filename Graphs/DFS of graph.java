//In BFS all vertices connected to current vertex are traversed first before their connections 
//In DFS connections are traversed first
static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
{
    vis[src] = true;
    System.out.print(src+" ");
    for(int j=0;j<list.get(src).size();j++)
    {
        if(vis[list.get(src).get(j)]!=true)
        {
            dfs(list.get(src).get(j),list,vis);
        }
    }
}