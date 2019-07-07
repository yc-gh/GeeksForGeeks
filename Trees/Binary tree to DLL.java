Node head;

//Using Depth First Traversal with stack
//Whenever a node is popped from stack, append it to the linked list and set references

Node bToDLL(Node root)
{
    Deque<Node> stack = new ArrayDeque<>();
    
    //Reference to keep track of last node in linked list
    Node last = null;
    
    //Reference to keep track of nodes in the tree
    Node curr = root;
    
    while(curr!=null || stack.size()>0)
    {
        while(curr != null)
        {
            stack.push(curr);
            curr = curr.left;
        }
        
        curr = stack.pop();
        
        //Create and insert node into linked list
        if(head == null)
        {
            Node newnode = new Node(curr.data);
            head = newnode;
            last = head;
        }
        else
        {
            Node newnode = new Node(curr.data);
            last.right = newnode;
            newnode.left = last;
            last = newnode;
        }
        
        curr = curr.right;
    }
    
    return head;
}