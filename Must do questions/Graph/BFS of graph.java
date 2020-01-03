// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class Traversal
{
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[], int nov)
    {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            if(!vis[curr])
            {
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int adjNode : list.get(curr))
                {
                    if(!vis[adjNode])
                    {
                        queue.offer(adjNode);
                    }
                }
            }
        }
    }
}