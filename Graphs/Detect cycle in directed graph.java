class Gfg {
    // DFS creates a tree for a connected graph, (multiple trees for disconnected
    // graph)
    // A cycle can only exist if a vertex is adjacent to itself or it's ancestor
    // Keep track of all vertices traversed in current subtree using recStack
    // Keep track of all visited vertices to avoid redundant checks (if a subtree of
    // DFS doesn't contain cycle then no point checking again)

    static boolean checkCycle(ArrayList<ArrayList<Integer>> list, int v, int curr, boolean[] recStack,
            boolean[] visited) {
        // Check if we've reached back to an ancestor vertex or current vertex
        if (recStack[curr] == true)
            return true;

        // If this vertex has already been checked, no need to recheck the subtree (it
        // doesn't contain cycle else method would've returned)
        if (visited[curr] == true)
            return false;

        // Set recStack and visited true for current vertex
        recStack[curr] = true;
        visited[curr] = true;

        List<Integer> adjacent = list.get(curr);

        for (int i : adjacent) {
            // If any of the adjacent vertices' subtree results in cycle
            // This also includes visited nodes that may be forming a cycle
            // Return true
            if (checkCycle(list, v, i, recStack, visited) == true)
                return true;
        }

        // If no cycles were found at current vertex or adjacent vertices, set recStack
        // to false
        // This is done so that if any other vertices in the graph connect to these, we
        // don't want false positive due to recStack staying true
        recStack[curr] = false;
        return false;
    }

    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
        // RecursionStack array to keep track of a all vertices in current subtree of
        // DFS traversal
        boolean[] recStack = new boolean[V];

        // Visited array to keep track of all vertices that have been checked
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkCycle(list, V, i, recStack, visited) == true)
                    return true;
            }
        }
        return false;
    }
}