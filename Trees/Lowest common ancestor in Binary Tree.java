    //Test cases donot cover cases when n1||n2 may not be present in tree
    //If traversal reaches leaf nodes' children, null is returned
    //---
    //When a node equals n1||n2 this node is returned. No further checking is required
    //The parent of this node is checked. If the parent has both left and right subtrees not null, parent is LCA
    //Else parent returns this node as LCA
    //No further checking will be done as this is the least node which can be LCA
	Node LCA(Node root, int n1,int n2)
	{
	    //If null of leaf nodes is reached, return null as neither key was found in this traversal
        if(root==null) return null;
        
        //If current node data equals either key. Return this node
        if(root.data==n1 || root.data==n2)
        {
            return root;
        }
        
        //Check left subtree of current node
        Node leftLCA = LCA(root.left,n1,n2);
        
        //Check right subtree  of current node
        Node rightLCA = LCA(root.right,n1,n2);
        
        //If left and right subtrees of current node are not null
        //i.e one key in each subtree -> current node is LCA
        if(leftLCA!=null && rightLCA!=null) return root;
        
        //Else if either left or right subtree returned null --> that subtree doesnt contain key
        //Therefore current node cannot be LCA. The subtree which returned not null will contain LCA(the returned node)
	    return (leftLCA!=null ? leftLCA : rightLCA);
	}