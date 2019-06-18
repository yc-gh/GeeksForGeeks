    //Approach -- 
    //Create a clone of the given list with only the next references
    //For each node of given list, change next to it's corresponding node in clone list
    //Change arb reference of each clone node to it's corresponding node in given list
    //Again change arb reference of each clone to clone->arb->arb->next
    //Revert next references of original node
    
    //Hashing approach used here
    //Map each original node to it's corresponding clone node
    //For each original node, set next of it's clone to mapping of original's next node
    //For each original node, set arb of it's clone to next of original's arb node
    //Return head of clone list
    Node copyList(Node head) {
        Node orignode = head;
        Node clonenode = null;
        Map<Node,Node> map = new HashMap<>();
        
        //Create new clone nodes and map original nodes to new clone nodes
        while(orignode!=null)
        {
            clonenode = new Node(orignode.data);
            map.put(orignode,clonenode);
            orignode = orignode.next;
        }
        
        //Now link the new clone nodes using the mapping 
        orignode = head;
        
        //Get head of new list
        Node newhead = map.get(orignode);
        
        //For each original node
        //Get it's clone node, set next of clone to mapping of next original
        //Set clone's arb to original->arb->next
        while(orignode!=null)
        {
            clonenode = map.get(orignode);
            clonenode.next = map.get(orignode.next);
            clonenode.arb = map.get(orignode.arb);
            orignode = orignode.next;
        }
        return newhead;
    }