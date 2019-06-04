void getIntersection(Node head1, Node head2)
    {   
        //Using Hashing to store intersection of linked lists        
         Set<Integer> set1 = new LinkedHashSet<>();
         while(head1!=null)
         {
             set1.add(head1.data);
             head1 = head1.next;
         }
         Set<Integer> set2 = new LinkedHashSet<>();
         while(head2!=null)
         {
             set2.add(head2.data);
             head2 = head2.next;
         }
         set1.retainAll(set2);
         Node last = null;
         //Create new linked list from intersecting nodes
         for(int i : set1)
         {
             Node newnode = new Node(i);
             if(llist3.head==null)
             {
                llist3.head = newnode;
                last = newnode; 
             }
             else
             {
                 last.next = newnode;
                 last = newnode;
             }
         }
    }