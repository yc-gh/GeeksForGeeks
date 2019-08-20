class Gfg {
    // Similar to tree level order traversal
    // Add starting vertex to queue and set it's visited to true
    // Check it's neighbours and add unvisited to queue and repeat for all remaining
    // nodes in queue
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean visited[]) {
        Deque<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);
        StringBuilder output = new StringBuilder();
        while (!queue.isEmpty()) {
            int curr = queue.pop();
            output.append(curr + " ");
            Iterator<Integer> iter = list.get(curr).listIterator();
            while (iter.hasNext()) {
                int adjacent = iter.next();
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.offer(adjacent);
                }
            }
        }
        System.out.print(output);
    }
}