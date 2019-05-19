Node LCA(Node node, int n1, int n2) 
    {
        /* 3 cases 
        Nodes are on either side of current node --> current node is LCA
        Both nodes in left subtree of current --> LCA is first occurrence of either required node in left subtree 
        Both nodes in right subtree of current --> LCA is first occurrence of either required node in right subtree
        */
        if(node==null) return null;
        //Both are in left subtree
        if(node.data>n1&&node.data>n2) return LCA(node.left,n1,n2);
        //Both are in right subtree
        if(node.data<n1&&node.data<n2) return LCA(node.right,n1,n2);
        //Above conditions fail -- Nodes are on either side
        //Current node is LCA
        return node;
    }