// https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1

/* 
ALGORITHM

1. Get left and right subtree heights, height of current subtree is max of these + 1 

*/

class Tree
{
    int height(Node node) 
    {
         if(node==null) return 0;
         int leftheight = 1 + height(node.left);
         int rightheight = 1 + height(node.right);
         return leftheight > rightheight ? leftheight : rightheight;
    }   
}
