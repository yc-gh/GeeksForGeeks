//Subtree = each node including all it's descendants
//Check the sum of root data + it's left and right  subtrees 
//Not just root + children data
//Recursively traverse left then right subtrees, set root data = left + right children data (which includes their subtrees)
//Compare to x
int countSubtreesWithSumX(Node root, int x)
{
    if(root==null) return 0;
    int leftsums = countSubtreesWithSumX(root.left,x);
    int rightsums = countSubtreesWithSumX(root.right,x);
    if(root.left!=null) root.data += root.left.data;
    if(root.right!=null) root.data +=root.right.data;
    return (root.data==x ? 1 : 0) + leftsums + rightsums;
}