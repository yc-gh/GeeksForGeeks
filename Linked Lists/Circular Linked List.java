boolean isCircular(Node head)
    {
	    if(head==null) return false;
	    Node curr = head.next;
	    while(curr!=head)
	    {
	        if(curr==null) return false;
	        curr=curr.next;
	    }
	    return true;
    }