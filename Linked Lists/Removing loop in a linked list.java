public static void removeTheLoop(Node head)
    {
        if(head==null || head.next==null) return;
        Node fast = head;
        Node slow = head;
        boolean loopexists = false;
        //Using slow and fast reference, detect loop
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
            {
                loopexists = true;
                break;
            }
        }
        //If loop exists, keep 2 references, 1 at start of linked list and other at previously found node (fast)
        //Move start forward repeatedly, and in each iteration, check if it can be reached from the loop
        //If it can be reached, then find the node which has this node as it's next and set it's next as null
        if(loopexists==true)
        {
            //Fast will be used as starting position for the loop
            //Loopnode will be used to loop through the loop
            Node loopnode = fast;
            //A start reference is kept which is used to check if a node can be reached from the loop
            Node start = head;
            //Indefinitely loop till start of loop is found
            while(1==1)
            {
                //Reset loopnode on each iteration
                loopnode = fast;
                //If next of loopnode is starting position of loop
                //Or next of loop is able to reach start
                while(loopnode.next!=fast && loopnode.next!=start)
                {
                    loopnode = loopnode.next;
                }
                //If loop ended with loopnode next as start
                if(loopnode.next==start)
                {
                    //Set next of loopnode as null ie. breaking the loop
                    loopnode.next = null;
                    break;
                }
                start = start.next;
            }
        } 
    }