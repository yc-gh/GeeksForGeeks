// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/

/* 
ALGORITHM

1. Given the adjacency list and number of vertices
2. Perform dfs traversal and check if a non parent visited node is reached (cycle detected) 

*/

class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
       boolean[] vis = new boolean[V];
       for(int i=0; i<V; i++)
       {
           if(!vis[i])
           {
               if(dfs(list, vis, i, -1))
               {
                   return true;
               }
           }
       }
       return false;
    }
    
    static boolean dfs(ArrayList<ArrayList<Integer>> list, boolean[] vis, int curr, int parent)
    {
        vis[curr] = true;
        for(int adjNode : list.get(curr))
        {
            if(vis[adjNode] && adjNode!=parent)
            {
                return true;
            }
            else if(!vis[adjNode])
            {
                if(dfs(list, vis, adjNode, curr)) return true;
            }
        }
        return false;
    }
}