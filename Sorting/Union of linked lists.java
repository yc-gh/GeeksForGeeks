Node findUnion(Node head1,Node head2)
	{
        //Use TreeSet to keep nodes of both lists in sorted order without duplicates
	    Set<Integer> set = new TreeSet<>();
	    while(head1!=null)
	    {
	        set.add(head1.data);
	        head1=head1.next;
	    }
	    while(head2!=null)
	    {
	        set.add(head2.data);
	        head2=head2.next;
	    }
	    Node head3 = null;
	    Node last = null;
	    for(int i : set)
	    {
	        Node currnode = new Node(i);
	        if(head3==null)
	        {
	            head3=currnode;
	            last=currnode;
	        }
	        else
	        {
	            last.next=currnode;
	            last=currnode;
	        }
	    }
	    return head3;
	}