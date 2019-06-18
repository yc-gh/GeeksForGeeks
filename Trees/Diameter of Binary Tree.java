    int height(Node node)
    {
        if(node==null) return 0;
        
        //Height of left subtree
        int leftheight = height(node.left);
        
        //Height of right subtree
        int rightheight = height(node.right);
        
        //Return max of left/right subtree added to height of current node (+1)
        return (1+Math.max(leftheight,rightheight));
    }
    
    int diameter(Node node)
    {
        if(node==null) return 0;
        //Height of left subtree
        int leftheight = height(node.left);
        
        //Height of right subtree
        int rightheight = height(node.right);
        
        //Diameter from current node (Added 1 to include current node)
        int currdiameter = leftheight+rightheight+1;
        
        //Diameter of left subtree (Calculated recursively for each left subtree)
        int leftdiameter = diameter(node.left);
        
        //Diameter of right subtree 
        int rightdiameter = diameter(node.right);
        return Math.max(currdiameter,Math.max(leftdiameter,rightdiameter));
    }