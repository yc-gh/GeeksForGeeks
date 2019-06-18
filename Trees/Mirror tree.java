void mirror(Node node)
    {
        if(node==null) return;
        //Swapping done only if node is not a leaf node
        if(!(node.left==null&&node.right==null))
         {
             //If left child is null, make right child as left child and set right as null
             if(node.left==null)
             {
                 node.left=node.right;
                 node.right=null;
             }
             
             //If right child is null, make left child as right child and set left as null
             else if(node.right==null)
             {
                 node.right=node.left;
                 node.left=null;
             }
             
             //Else swap the nodes(Not data)
             else
             {
                 Node temp = node.left;
                 node.left = node.right;
                 node.right = temp;
             }
         }
         //Repeat for left and right children recursively
         mirror(node.left);
         mirror(node.right);
    }