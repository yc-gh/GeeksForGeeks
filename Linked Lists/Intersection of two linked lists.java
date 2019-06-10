    //Add nodes of both lists to TreeSets
    //Create new list from intersection of sets
    static Node findIntersection(Node head1, Node head2)
    {
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new TreeSet<>();
        for(Node curr=head1;curr!=null;curr=curr.next)
        {
            set1.add(curr.data);
        }
        for(Node curr=head2;curr!=null;curr=curr.next)
        {
            set2.add(curr.data);
        }
        set1.retainAll(set2);
        if(set1.isEmpty()) return null;
        Node head3 = null;
        Node last = null;
        for(int i : set1)
        {
            Node newnode = new Node(i);
            if(head3==null) 
            {
                head3 = newnode;
                last = newnode;
            }
            else
            {
                last.next = newnode;
                last = newnode;
            }
        }
        return head3;
    }