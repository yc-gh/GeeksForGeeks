void levelOrder(Node node) 
    {
        if(node==null) return ;
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
        }
    }