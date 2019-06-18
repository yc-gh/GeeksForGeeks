//Using queue for level order traversal
//Connect all nodes at each level
void connect(Node root)
{
    Deque<Node> queue = new ArrayDeque<>();
    queue.offer(root);
    while(!queue.isEmpty())
    {
        //Calculate size of queue -> no. of elements at current level
        int size = queue.size();
        
        //Reference for setting nextRight
        Node levelnode = null;
        
        //Poll all elements of current level
        //Set the nextRight reference
        //And offer their children to queue
        while(size-->0)
        {
            Node temp = queue.poll();
            if(levelnode==null) 
            {
                levelnode = temp;
            }
            else
            {
                levelnode.nextRight = temp;
                levelnode = temp;
            }
            if(temp.left!=null) queue.offer(temp.left);
            if(temp.right!=null) queue.offer(temp.right);
        }
    }
}