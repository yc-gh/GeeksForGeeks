public boolean isIsomorphic(Node root1,Node root2)
    {
        //If both have reached null or trees are empty
        if(root1==null&&root2==null) return true;
        //If only one is null
        if(root1==null||root2==null) return false;
        //If both are not null
        //Check if data is equal
        if(root1.data!=root2.data) return false;
        //Check persistent or inverted combinations betweeen left and right subtrees of each
        boolean persist = isIsomorphic(root1.left,root2.left)&&isIsomorphic(root1.right,root2.right);
	    boolean invert = isIsomorphic(root1.left,root2.right)&&isIsomorphic(root1.right,root2.left);
        //Return true if either combination yields true(Isomorphic)
        return persist||invert;
    }