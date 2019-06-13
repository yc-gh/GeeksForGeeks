//If the left or right height of current subtree is equal to k
//Then there is a leaf node reachable from current node
static int count;
static int height(Node node,int k)
{
    if(node==null) return 0;
    int leftSubHeight = height(node.left,k);
    int rightSubHeight = height(node.right,k);
    if(leftSubHeight==k || rightSubHeight==k) count++;
    return Math.max(leftSubHeight,rightSubHeight) + 1;
}
public static int printKDistantfromLeaf(Node node, int k)
{
    //Don't forget to reset count on each method call
    count=0;
    //Utility method
    height(node,k);
    return count;
}