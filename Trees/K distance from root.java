void printKdistance(Node node, int k)
     {
         if(node==null) return ;
         //Use queue for level order 
         //In each iteration, elements of one level will be present in queue
         Deque<Node> queue = new ArrayDeque<>();
         queue.offer(node);
         int dist = 0;
         while(!queue.isEmpty())
         {
             //Increment distance for each level traversed
             //Break loop when required level is reached
             if(dist++==k) break;
             //Calculate number of elements at current in each iteration
             //So that only those elements are polled 
             int size = queue.size();
             //Poll all elements of current level and offer their children  
             while(size-->0)
             {
                 Node curr = queue.poll();
                 if(curr.left!=null) queue.offer(curr.left);
                 if(curr.right!=null) queue.offer(curr.right);
             }
         }
         //If entire tree was traversed but k is still greater than max level of tree
         //Then return nothing
         if(k>dist) return;
         StringBuilder output = new StringBuilder();
         //Print elements of current level (loop was stopped at required level)
         while(!queue.isEmpty())
         {
             Node curr = queue.poll();
             output.append(curr.data+" ");
         }
         System.out.print(output);
     }