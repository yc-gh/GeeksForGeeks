Node head, prev;

//Using inorder traversal
//Prev pointer keeps track of inorder nodes
//Using prev, inorder nodes are linked to predecessors 
Node bToDLL(Node root)
{
    if(root==null)
    {
        return root;
    }
    
    //Recursively convert left subtree
    bToDLL(root.left);
    
    //Set references to/from previous node
    if(prev == null)
    {
        head = root;
    }
    else
    {
        prev.right = root;
        root.left = prev;
    }
    
    //Set prev to this node
    prev = root;
    
    //Recursively convert right subtree
    bToDLL(root.right);
    
    return head;
}