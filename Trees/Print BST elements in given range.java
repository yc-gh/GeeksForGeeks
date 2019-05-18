void printNearNodes(Node node, int k1, int k2)
    {
        //Similar to inorder traversal 
        if(node==null) return;
        //If current node is greater than k1, move to left subtree
        //As long as k1 is less than current node, move left
        //Once current becomes less than k1, start searching larger elements 
        //And print 
        if(node.key>k1) printNearNodes(node.left,k1,k2);
        //If current node is within range
        if(node.key>=k1&&node.key<=k2) System.out.print(node.key+" ");
        //If current node is still less than k2, move to right subtree
        if(node.key<k2) printNearNodes(node.right,k1,k2);
    }