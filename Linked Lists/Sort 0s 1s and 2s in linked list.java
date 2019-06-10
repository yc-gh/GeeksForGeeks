    //Create three new lists from joining 0s 1s 2s
    //Maintain dummy (detached) heads of these lists to find out if list is empty
    //Join three lists and return head of first list
    static Node segregate(Node head)
    {
        if(head==null || head.next==null) 
        { 
            return head; 
        }
        Node zerohead = new Node(0);
        Node onehead = new Node(0);
        Node twohead = new Node(0);
        Node zerolast=zerohead;
        Node onelast=onehead;
        Node twolast=twohead;
        for(Node curr=head;curr!=null;curr=curr.next)
        {
            if(curr.data==0)
            {
                zerolast.next=curr;
                zerolast=curr;
            }
            else if(curr.data==1)
            {
                onelast.next=curr;
                onelast=curr;
            }
            else if(curr.data==2)
            {
                twolast.next=curr;
                twolast=curr;
            }
        }
        zerolast.next=(onehead.next!=null ? onehead.next : twohead.next);
        onelast.next=twohead.next;
        twolast.next=null;
        return zerohead.next;
    }


    /* ------ ALTERNATE APPROACH ------ */

    //Instead of creating seperate lists for each
    //Traverse the linkedlist and manipulate references in the existing list
    //3 in place lists are created for 0s 1s and 2s
    //Link each of these 
    static Node segregate(Node head)
    {
        if(head==null || head.next==null) 
        { 
            return head; 
        }
        Node curr=head;
        Node zerohead=null,zerolast=null;
        Node onehead=null,onelast=null;
        Node twohead=null,twolast=null;
        while(curr!=null)
        {
            if(curr.data==0)
            {
                if(zerohead==null)
                {
                    zerohead=curr;
                    zerolast=curr;
                }
                else
                {
                    zerolast.next=curr;
                    zerolast=curr;
                }
            }
            else if(curr.data==1)
            {
                if(onehead==null)
                {
                    onehead=curr;
                    onelast=curr;
                }
                else
                {
                    onelast.next=curr;
                    onelast=curr;
                }
            }
            else if(curr.data==2)
            {
                if(twohead==null)
                {
                    twohead=curr;
                    twolast=curr;
                }
                else
                {
                    twolast.next=curr;
                    twolast=curr;
                }
            }
            curr=curr.next;
        }
        //2s are at the end of the final list, mark null as next of 2s last node
        //But only if there were any 2s in the given list, else Null pointer exception
        if(twohead!=null) twolast.next=null;
        //A node that will be returned 
        Node newhead=null;
        //If no 0s in the list
        //No need to check for 2s -- If no 2s then the 2s head will be null
        if(zerohead==null)
        {
            //If no 0s or 1s in the list
            if(onehead==null) newhead=twohead;
            //1s but no 0s in list
            else
            {
                onelast.next=twohead;
                newhead=onehead;
            }
        }
        //0s in list
        else
        {
            //0s but no 1s in list
            if(onehead==null) zerolast.next=twohead;
            //0s and 1s (No need to check for 2s)
            else
            {
                zerolast.next=onehead;
                onelast.next=twohead;
            }
            newhead=zerohead;
        }
        return newhead;
    }