// https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1

/* 

ALGORITHM

1. Keep track of horizontal distance of each node from center (0 for root node)
2. Use level order traversal to keep track of distances of children
3. Subtract horizontal distance by 1 for left child and add 1 for right child
4. Keep a mapping of horizontal distances to list of nodes and overwrite existing mappings 


*/

class BinaryTree
{
    static void verticalOrderUtil(Node root, Map<Integer, List<Integer>> map)
    {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            if(curr.left!=null)
            {
                curr.left.hd = curr.hd-1;
                queue.offer(curr.left);
                if(!map.containsKey(curr.left.hd))
                {
                    map.put(curr.left.hd, new ArrayList<Integer>(Arrays.asList(curr.left.data)));
                }
                else
                {
                    map.get(curr.left.hd).add(curr.left.data);
                }
            }
            if(curr.right!=null)
            {
                curr.right.hd = curr.hd+1;
                queue.offer(curr.right);
                if(!map.containsKey(curr.right.hd))
                {
                    map.put(curr.right.hd, new ArrayList<Integer>(Arrays.asList(curr.right.data)));
                }
                else
                {
                    map.get(curr.right.hd).add(curr.right.data);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            for(int i : entry.getValue())
            {
                sb.append(i+" ");
            }
        }
        
        System.out.print(sb);
    }
    
    static void verticalOrder(Node root)
    {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        root.hd = 0;
        map.put(root.hd, new ArrayList<Integer>(Arrays.asList(root.data)));
        verticalOrderUtil(root, map);
    }
}