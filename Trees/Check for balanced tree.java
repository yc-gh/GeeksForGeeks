//Check height of left and right subtrees of each node 
//If absolute difference is <= 1 then this subtree is balanced, return it's height
//Else return -1 as a flag for unbalanced subtree, which is returned back to driver method

int checkHeight(Node root)
{
    if(root == null)
    {
        return 0;
    }
    
    int leftheight = checkHeight(root.left);
    
    if(leftheight == -1)
    {
        return -1;
    }
    
    int rightheight = checkHeight(root.right);
    
    if(rightheight == -1)
    {
        return -1;
    }
    
    if(Math.abs(leftheight - rightheight) <= 1)
    {
        return 1 + Math.max(leftheight,rightheight);
    }
    
    return -1;
}
boolean isBalanced(Node root)
{
    return checkHeight(root) != -1 ;
}