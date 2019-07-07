Node head, prev;

Node convertToDLL(Node root)
{
    if(root==null)
    {
        return root;
    }
    
    //If a leaf node is found, add it to linked list
    if(root.left==null && root.right==null)
    {
        //Set references to/from previous leaf node
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
        
        return prev;
    }
    
    //Recursively convert left subtree
    bToDLL(root.left);
    
    //Recursively convert right subtree
    bToDLL(root.right);
    
    return head;
}