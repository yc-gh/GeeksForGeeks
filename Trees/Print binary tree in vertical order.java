//Similar to bottom view question
//Set horizontal distance for each node using level order traversal
//Map each horizontal distance to a list of nodes in order of their appearance as per level order traversal
//Print each list in sorted order of horizontal distance
static void verticalOrder(Node root)
{
    Deque<Node> queue = new ArrayDeque<>();
    
    //Map hd to a list of nodes (node data)
    Map<Integer,List<Integer>> map = new TreeMap<>();
    
    //Set hd of root
    root.hd = 0;
    queue.offer(root);
    
    //Arrays.asList returns a unmutable fixed size list 
    //So create a new mutable list backed by the list returned from Arrays.asList
    map.put(root.hd, new ArrayList(Arrays.asList(root.data)));
    
    while(!queue.isEmpty())
    {
        int size = queue.size();
        while(size --> 0)
        {
            Node curr = queue.poll();
            
            //If left child exists, offer to queue and put/update in map
            if(curr.left != null)
            {
                curr.left.hd = curr.hd - 1;
                queue.offer(curr.left);
                if(!map.containsKey(curr.left.hd))
                {
                    map.put(curr.left.hd, new ArrayList(Arrays.asList(curr.left.data)));
                }
                else
                {
                    map.get(curr.left.hd).add(curr.left.data);
                }
            }
            
            //Same for right child
            if(curr.right != null)
            {
                curr.right.hd = curr.hd + 1;
                queue.offer(curr.right);
                if(!map.containsKey(curr.right.hd))
                {
                    map.put(curr.right.hd, new ArrayList(Arrays.asList(curr.right.data)));
                }
                else
                {
                    map.get(curr.right.hd).add(curr.right.data);
                }
            }
        }
    }
    
    StringBuilder output = new StringBuilder();
    
    //For each hd in map, print the list 
    for(Map.Entry<Integer,List<Integer>> entry : map.entrySet())
    {
        for(int i : entry.getValue())
        {
            output.append(i+" ");
        }
    }
    
    System.out.print(output);
}