    //Approach -- Using level order traversal, keep track of size of each level
    int getMaxWidth(Node root)
    {
        if(root==null) return 0;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int width = 0;
        int maxwidth = 0;
        //While tree is not fully traversed
        while(!queue.isEmpty())
        {
            //Calculate number of elements at current level
            width = queue.size();
            if(width>maxwidth) maxwidth = width;
            //Remove all elements of current level from queue 
            //Add their children to queue
            while(width-->0)
            {
                Node curr = queue.poll();
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
        }
        return maxwidth;
    }