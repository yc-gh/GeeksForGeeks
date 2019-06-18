        public static void insert(Node head,int value,int n)
         {
            //If linked list is empty, create a single node 
            //Or (avoid) print it
            if(head==null)
            {
                System.out.print(value);
                return;
            }
            Node curr = head;
            
            //Traverse the list till a node with data greater than value is encountered
            //Or if list reaches last node 
            //Insert new element at the end
            while(curr.next.data < value && curr.next != head)
            {
                curr=curr.next;
            }
            
            //Insertion at beginning
            //If value is less than head data, insert new node at head and make it new head
            //Also last node in list should point to this node
            if(curr==head && curr.data > value)
            {
                while(curr.next != head) curr=curr.next;
                Node newnode = new Node(value);
                newnode.next = curr.next;
                curr.next = newnode;
                head = newnode;
            }
            //Else
            //Insertion in middle or end of list
            else
            {
                Node newnode = new Node(value);
                newnode.next = curr.next;
                curr.next = newnode;
            }
            
            //Print list
            curr = head;
            
            StringBuilder output = new StringBuilder();
            
            //Till current doesnt reach head (Circular linked list)
            do
            {
                output.append(curr.data+" ");
                curr=curr.next;
            }while(curr != head);
            System.out.print(output);
         }