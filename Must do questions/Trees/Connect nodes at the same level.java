// https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1

/* ALGORITHM

1. Use level order traversal
2. Keep a prev reference to each node 
3. Connect next node to previous node using prev reference

*/

class Level
{
    static void levelorder(Node root)
    {
        StringBuilder sb = new StringBuilder();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            sb.append(curr.data+" ");
            if(curr.left!=null) queue.offer(curr.left);
            if(curr.right!=null) queue.offer(curr.right);
        }
        
        System.out.println(sb);
    }
    
    static void inorder(Node root, StringBuilder inorderOutput)
    {
        if(root!=null)
        {
            inorder(root.left, inorderOutput);
            inorderOutput.append(root.data+" ");
            inorder(root.right, inorderOutput);
        }
    }
    
    static void connect(Node root)
    {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        Node prev = null;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-->0)
            {
                Node curr = queue.poll();
                if(prev!=null) prev.nextRight = curr;
                prev = curr;
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            prev.nextRight = null;
            prev = null;
        }
        
        // levelorder(root);
        // StringBuilder inorderOutput = new StringBuilder();
        // inorder(root, inorderOutput);
        // System.out.println(inorderOutput);
    }
}