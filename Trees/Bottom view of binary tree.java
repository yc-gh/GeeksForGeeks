//Each node contains a horizontal distance field for tracking it's hd from root
//Use level order traversal to set horizontal distance of each node
//And keep a sorted mapping of each horizontal distance to corresponding node
//The mapping is overwritten by any new nodes at the same horizontal distance,
// this way nodes at a lower level are considered for the bottom view
//If two nodes at same level have same horizontal distance, latter one is considered (handled by level order traversal)
//Print the mappings for bottom view

public void bottomView(Node root)
{
    Map<Integer,Integer> map = new TreeMap<>();
    Deque<Node> queue = new ArrayDeque<>();
    
    //Set horizontal distance 0 of root node
    root.hd = 0;
    
    //Offer to queue and map 0 horizontal distance to root node's data
    queue.offer(root);
    map.put(root.hd, root.data);
    
    //Level order traversal
    while(!queue.isEmpty())
    {
        int size = queue.size();
        
        while(size --> 0)
        {
            Node curr = queue.poll();
            
            //Set horizontal distance of left child if exits
            //And set mapping for that horizontal distance
            if(curr.left != null)
            {
                curr.left.hd = curr.hd - 1;
                queue.offer(curr.left);
                map.put(curr.left.hd, curr.left.data);
            }
            
            //Set horizontal distance and mapping of right child if exists 
            if(curr.right != null)
            {
                curr.right.hd = curr.hd + 1;
                queue.offer(curr.right);
                map.put(curr.right.hd, curr.right.data);
            }
        }
    }
    
    StringBuilder output = new StringBuilder();
    
    for(Map.Entry<Integer,Integer> entry : map.entrySet())
    {
        output.append(entry.getValue()+" ");
    }
    
    System.out.print(output);
}