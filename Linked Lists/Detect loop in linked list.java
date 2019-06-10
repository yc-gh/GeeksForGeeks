    //Two pointers, one moves at twice the rate of other
    //If faster one reaches null, no loop in linked list
    //Else it will reach the slower one and loop is detected
    int detectLoop(Node head) {
        if(head==null || head.next==null) return 0;
        Node hare = head;
        Node tortoise = head;
        while(hare!=null && hare.next!=null)
        {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if(hare==tortoise) return 1;
        }
        return 0;
    }