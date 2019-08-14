//Inefficient approach -- 
//for each node check if left subtree's max value is less than node's data and right subtree's min value is greater than node's data

//Alternative approach -- Check if inorder traversal is sorted

//Efficient approach -- create a helper method that contains min and max values possible for current node
//For each node, check if it is within that range
//For it's left subtree, the range becomes previousmin <-> node.data-1
//For it's right subtree, the range becomes node.data+1 <-> previousmax
    
class Gfg
{
    boolean isBSTUtil(Node root,int min,int max)
    {
        if(root==null) return true;
        if(root.data<min || root.data>max) return false;
        return isBSTUtil(root.left,min,root.data-1) && isBSTUtil(root.right,root.data+1,max);
    }
    int isBST(Node root)  
    {
        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE)==true ? 1 : 0;
    }
}