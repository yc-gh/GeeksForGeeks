// https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1

/* 
ALGORITHM

1. Check if left,right subtrees are height balanced
2. If they are, get height of current subtree and check if current subtree is balanced

*/

class Tree
{
    int checkheight(Node root)
    {
        if(root==null) return 0;
        
        int leftheight = checkheight(root.left);
        
        if(leftheight==-1) return -1;
        
        int rightheight = checkheight(root.right);
        
        if(rightheight==-1) return -1;
        
        if(Math.abs(leftheight-rightheight) <= 1)
        {
            return Math.max(leftheight,rightheight)+1;
        }
        
        return -1;
    }
     
    boolean isBalanced(Node root)
    {
        return checkheight(root)!=-1;  
    }
}