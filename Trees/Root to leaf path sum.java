class Gfg
{
//Approach --
    //Check required sum - current node data at each node
    //If a null child is reached before sum reaches 0, return false as this can't be the path
    //If a non null node is reached with sum 0, this cannot be the path and no further checking required
    //If a leaf node is reached and sum is not 0, check if sum - current node data is 0
    //Recursively check for left and right of current node
    boolean hasPathSum(Node node, int sum)
    {
        if(node==null) return false;
        if(sum==0) return false;
        if(node.left==null && node.right==null) return (sum-node.data==0 ? true : false);
        return hasPathSum(node.left,sum-node.data)||hasPathSum(node.right,sum-node.data);
    }

    //ALTERNATIVE APPROACH 
    //Similar to above, but add each node's data instead of subtracting
    boolean checkSum(Node node, int sum, int prevsum)
    {
        if(node==null) return false;
        int currsum = prevsum + node.data;
        if(node.left==null && node.right==null && currsum==sum) return true;
        return checkSum(node.left,sum,currsum) || checkSum(node.right,sum,currsum);
    }
    boolean hasPathSum(Node node, int sum)
    {
        if(node==null) return false;
        return checkSum(node.left,sum,node.data) || checkSum(node.right,sum,node.data);
    }
}