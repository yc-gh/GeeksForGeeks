//Inorder approach -- collections not allowed in this solution
//Same as binary tree to DLL, just set references from last node to head
Node head, prev;

Node bTreeToClist(Node root)
{
    if(root == null)
    {
        return root;
    }

    //Recursively convert left subtree
    bTreeToClist(root.left);
    
    //Create references from current node to/from previous 
    if(prev == null)
    {
        head = root;
    }
    else
    {
        prev.right = root;
        root.left = prev;
    }
    
    //Set prev to current node
    prev = root;
    
    //Recursively convert right subtree
    bTreeToClist(root.right);
    
    //Set circular reference from last to head
    prev.right = head;
    head.left = prev;
    
    return head;
}