public static int isSumProperty(Node node)
    {
        if(node==null) return 1;
        //Check if node is leaf node
        if(node.left==null && node.right==null) return 1;
        int sumvalid = 0;
        //Else check if parent == sum of children 
        if(node.left==null) 
        {
            sumvalid = (node.data==node.right.data) ? 1 : 0;
        }
        else if(node.right==null)
        {
            sumvalid = (node.data==node.left.data) ? 1 : 0;
        }
        else 
        {
            sumvalid = (node.data==(node.left.data+node.right.data)) ? 1 : 0;
        }
        //If check fails
        if(sumvalid!=1) return 0;
        //Check left and right subtrees
        int leftsum = isSumProperty(node.left);
        int rightsum = isSumProperty(node.right);
        //Check current subtree and left,right subtrees
        if(sumvalid==1 && leftsum==1 && rightsum==1) return 1;
        return 0;
    }