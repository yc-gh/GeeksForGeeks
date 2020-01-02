// https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1

/* 

ALGORITHM

The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
ie. The node which has largest left subtree + right subtree height 

1. For each node, get diameter through current node ie. heights of left and right subtrees + 1 
2. Compare with diameters of left and right subtrees and return largest of 3

*/

class Tree
{
   /* Complete the function to get diameter of a binary tree */
    int height(Node node)
    {
        if(node==null) return 0;
        int leftheight = height(node.left);
        int rightheight = height(node.right);
        return 1+Math.max(leftheight,rightheight);
    }
       
    int diameter(Node node)
    {
        if(node==null) return 0;
        int leftheight = height(node.left);
        int rightheight = height(node.right);
        int currentdiameter = leftheight+rightheight+1;
        int leftdiameter = diameter(node.left);
        int rightdiameter = diameter(node.right);
        return Math.max(currentdiameter, Math.max(leftdiameter,rightdiameter));
    }
}