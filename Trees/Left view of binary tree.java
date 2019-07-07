//Print first element in each level of level order traversal
void leftView(Node root)
{
    Deque<Node> queue = new ArrayDeque<>();
    StringBuilder output = new StringBuilder();
    
    queue.offer(root);
    output.append(root.data+" ");
    
    while(!queue.isEmpty())
    {
        int size = queue.size();
        while(size --> 0)
        {
            Node curr = queue.poll();
            if(curr.left != null)
            {
                queue.offer(curr.left);
            }
            if(curr.right != null)
            {
                queue.offer(curr.right);
            }
        }
        if(!queue.isEmpty())
        {
            output.append(queue.peek().data+" ");
        }
    }
    
    System.out.print(output);
}