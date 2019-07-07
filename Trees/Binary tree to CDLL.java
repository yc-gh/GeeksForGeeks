//Inorder approach -- collections not allowed in this solution
//A new node is inserted into linked list when the inorder root is reached for each subtree
//Although the circular reference from last to head is 
Node head, last;

Node bTreeToClist(Node root)
{
    if(root == null)
    {
        return root;
    }

    bTreeToClist(root.left);
    
    //After traversing the left subtree
    //Create and insert node into linked list
    if(head == null)
    {
        Node newnode = new Node(root.data);
        head = newnode;
        last = head;
    }
    else
    {
        Node newnode = new Node(root.data);
        last.right = newnode;
        newnode.left = last;
        last = newnode;
    }
    
    //Traverse right subtree
    bTreeToClist(root.right);
    
    //Set circular reference from last to head
    last.right = head;
    head.left = last;
    
    return head;
}