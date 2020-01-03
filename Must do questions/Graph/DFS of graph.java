// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

/* 
ALGORITHM

1. Given the adjacency list, start node and a boolean list to keep track of visited nodes
2. If current node is visited, stop
3. Mark current node as visited
4. Perform dfs traversal for each adjacent node 
*/

class Traversal
{
    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {
       if(vis[src]) return;
       vis[src] = true;
       System.out.print(src+" ");
       for(Integer adjNode : list.get(src))
       {
           dfs(adjNode, list, vis);
       }
    }
}