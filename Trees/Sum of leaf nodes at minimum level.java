    //Level order traversal
    //Traverse till level containing leaf nodes is reached, calculate sum of leaf nodes
    public int minLeafSum(Node node){
        Deque<Node> queue = new ArrayDeque<>();
        boolean minlevelreached = false;
        int sum = 0;
        queue.offer(node);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-->0)
            {
                Node curr = queue.poll();
                //
                if(curr.left==null&&curr.right==null)
                {
                    minlevelreached=true;
                    sum+=curr.data;
                }
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            if(minlevelreached) break;
        }
        return sum;
    }