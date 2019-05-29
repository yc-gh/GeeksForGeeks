void levelOrder(Node node) 
    {
        Deque<Node> queue = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();
        queue.offer(node);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            //Traverse and print all nodes at current level
            while(size-->0)
            {
                Node curr = queue.poll();
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
                output.append(curr.data+" ");
            }
            output.append("$ ");
        }
        System.out.print(output);
    }