// https://practice.geeksforgeeks.org/problems/maximum-path-sum/1

/* 
ALGORITHM

Path sum is from one leaf node to another

1. For each node, path sum is max(leftsubtree) + max(rightsubtree) + current
2. However, this may not be max path sum
3. Store this sum to compare later
4. Return a half path sum so that more complete paths can be checked

*/


//Using a static member will cause issues with multiple test cases
//Better use an object 
class GfG
{
    static class Res
    {
        int res = Integer.MIN_VALUE;
    }
    public static int maxPathSum(Node root)
    {
        Res r = new Res();
        maxPathSumUtil(root, r);
        return r.res;
    }
    
    public static int max(Res r, int b)
    {
        if(r.res >= b)
         return r.res;
         else
         return b;
    }
    public static int maxPathSumUtil(Node root, Res r)
    {
        if (root==null) return 0;
        if (root.left == null && root.right == null) return root.data;
        int ls = maxPathSumUtil(root.left, r);
        int rs = maxPathSumUtil(root.right, r);
        if (root.left != null && root.right != null)
        {
            r.res = max(r, ls + rs + root.data);
            return Math.max(ls, rs) + root.data;
        }
        if(root.left == null)
          return rs+root.data;
        else
          return ls + root.data;
    }
}