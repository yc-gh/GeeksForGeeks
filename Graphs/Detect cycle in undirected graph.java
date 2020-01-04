class Gfg {
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
        // add your code here
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive helper function to detect cycle in
        // different DFS trees (disconnected graph)
        for (int u = 0; u < V; u++)
            if (!visited[u]) // Don't recur for u if already visited
                if (isCyclicUtil(u, visited, list, -1))
                    return true;

        return false;
    }

    static Boolean isCyclicUtil(int v, Boolean visited[], ArrayList<ArrayList<Integer>> list, int parent) {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = list.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();

            // If an adjacent is not visited, then recur for that
            // adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, list, v))
                    return true;
            }

            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }
}