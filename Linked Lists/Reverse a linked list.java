Node reverseList(Node head)
   {
        Node curr = head;
        Node start = null;
        //Create a new node with current node data iteratively and 
        //reference it's next to previously created node
        while(curr!=null)
        {
            Node newnode = new Node(curr.data);
            newnode.next = start;
            start = newnode;
            curr=curr.next;
        }
        return start;
   }