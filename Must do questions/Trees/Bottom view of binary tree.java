// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

/* 

ALGORITHM

Given a binary tree, print the bottom view from left to right.

1. Keep track of horizontal distance of each node from center (0 for root node)
2. Use level order traversal to keep track of distances of children
3. Subtract horizontal distance by 1 for left child and add 1 for right child
4. Keep a mapping of horizontal distances to nodes and overwrite existing mappings 

*/

class Tree
{
    void bottomViewUtil(Node root, Map<Integer, Node> map)
    {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            if(curr.left!=null) 
            {
                curr.left.hd = curr.hd-1;
                map.put(curr.left.hd, curr.left);
                queue.offer(curr.left);
            }
            if(curr.right!=null) 
            {
                curr.right.hd = curr.hd+1;
                map.put(curr.right.hd, curr.right);
                queue.offer(curr.right);
            }
        }
        
        for(Map.Entry<Integer, Node> entry : map.entrySet())
        {
            System.out.print(entry.getValue().data+" ");
        }
    }
    
    // Should print bottom view of tree with given root
    public void bottomView(Node root)
    {
        Map<Integer, Node> map = new TreeMap<>();
        root.hd = 0;
        map.put(root.hd, root);
        bottomViewUtil(root, map);
    }
}