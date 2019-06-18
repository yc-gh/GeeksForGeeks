    //Approach -- Each node becomes sum of its children and returns 
    //the new sum + it's original data
    int newTree(Tree root){
        //If current root has reached null of leaf nodes
        if(root==null) return 0;
        
        //Change nodes and return sum recursively bottom to top of tree
        //Left subtree first
        int leftsum = newTree(root.left);
        
        //Right subtree
        int rightsum = newTree(root.right);
        
        //Total sum of left + right + root
        int total_sum = root.data + leftsum + rightsum;
        
        //New root data
        root.data = leftsum + rightsum;
        
        //Return the total sum of current root and left,right subtrees to parent
        return total_sum;
    }
    
    public void toSumTree(Tree root){
        if(root==null) return;
        newTree(root);
    }