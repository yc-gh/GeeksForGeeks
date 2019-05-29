    //Approach --
    //If current node is key, return it's left 
    //---
    //If the key lies in right subtree of current, then current is < key node and doesn't need to be deleted
    //Traverse the right subtree till key node is found. Attach it's left to current's right
    //---
    //If key lies in left subtree of current, traverse till key node and return left of key 
    public Node deleteNode(Node root,int x)
    {
        //If tree is empty or if null is reached 
        if(root==null) return null;
        //If current node is the key
        if(root.data==x)
        {
            return root.left;
        }
        //If key is in right subtree
        if(x>root.data)
        {
            root.right = deleteNode(root.right,x);
            return root;
        }
        //Key in left subtree
        else
        {
            return deleteNode(root.left,x);
        }
    }