//Level order traversal, but right child first and push all to a stack
	void reversePrint(Node node) 
        {
            Deque<Node> queue = new ArrayDeque<>();
            Deque<Node> stack = new ArrayDeque<>();
            queue.offer(node);
            while(!queue.isEmpty())
            {
                Node curr = queue.poll();
                if(curr.left!=null) queue.offer(curr.right);
                if(curr.right!=null) queue.offer(curr.left);
                stack.push(curr);
            }
            StringBuilder output = new StringBuilder();
            while(!stack.isEmpty())
            {
                output.append(stack.pop().data+" ");
            }
            System.out.print(output);
        }