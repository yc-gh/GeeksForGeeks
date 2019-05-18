int getLevelDiff(Node root)
    {
        if(root==null) return 0;
        return root.data - getLevelDiff(root.left) - getLevelDiff(root.right);
    }