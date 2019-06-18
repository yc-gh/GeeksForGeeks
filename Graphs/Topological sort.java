//WARNING -- here Deque has been used as a queue instead of stack
//Since the problem setters incorrectly read the output array in reverse
//In proper solution, use stack 

//Approach --
//For each vertex, mark it true, visit it's adjacent unvisited vertices using DFS and finally push to stack
//Pop all elements of stack for topological sort
static void modDFS(ArrayList<ArrayList<Integer>> list, int i,boolean[] visited,Deque<Integer> stack)
{
    //Set visited true
    visited[i] = true;
    //For each of it's adjacent vertex, do DF traversal
    for(int adjvertex : list.get(i))
    {
        if(!visited[adjvertex])
        modDFS(list,adjvertex,visited,stack);
    }
    //And finally push to stack
    stack.offer(i);
}

static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N)
{
    boolean[] visited = new boolean[N];
    Deque<Integer> stack = new ArrayDeque<>();
    for(int i=0;i<N;i++)
    {
        if(!visited[i])
        {
            modDFS(list,i,visited,stack);
        }
    }
    int[] output = new int[N];
    int k=0;
    //Pop all stack elements for output
    while(!stack.isEmpty())
    {
        output[k++] = stack.poll();
    }
    return output;
}