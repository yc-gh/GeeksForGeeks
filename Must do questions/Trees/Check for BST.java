// https://practice.geeksforgeeks.org/problems/check-for-bst/1


/* 
Given a binary tree, return true if it is BST, else false

ALGORITHM 1

1. Keep track of min max range of possible node values
2. If a node value doesn't lie within range, tree isn't BST
3. Check subtree with new ranges

ALGORITHM 2

1. Do inorder traversal and check if it's sorted
2. To avoid using extra space, keep track of previous node for comparison

*/


//Be careful not to try using a function arg instead of static variable. 
// Function args arent passed back up the tree

class GfG
{
    static Node prev;
    boolean checkBST(Node root)
    {
        if(root!=null)
        {
            if(!checkBST(root.left)) return false;
            if(prev!=null && root.data <= prev.data) return false;
            prev = root;
            return checkBST(root.right);
        }
        return true;
    }
    
    int isBST(Node root)  
    {
        prev = null;
        return checkBST(root) ? 1 : 0;
    }
}