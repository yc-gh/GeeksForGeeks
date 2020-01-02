// https://practice.geeksforgeeks.org/problems/symmetric-tree/1 

/* 

ALGORITHM

1. Perform simple traversal of both trees
2. Traverse in opposite order for one of the trees ie. compare left child with right child and vice versa

*/

class GfG
{
    public static boolean isSymmetric(Node root)
    {
        if(root==null)
        return true;
        //Need to check the left and right subtrees of root
        //Split them and check if they mirror each other
        return check(root.left,root.right);
    }
    public static boolean check(Node a, Node b)
    {
        //If both trees are traversed without any mismatch
        if(a==null&&b==null) return true;
        //One is null other is not
        if(a==null||b==null) return false;
        //Data is not equal
        if(a.data!=b.data) return false;
        //Recursively travel and check (in a mirrored fashion)
        return check(a.left,b.right)&&check(a.right,b.left);
    }
}