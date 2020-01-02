// https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1

/* 
ALGORITHM


*/

class Tree
{
	/* Should return true if trees with roots as root1 and 
   root2 are identical else false */
        boolean isIdentical(Node root1, Node root2)
	{
		if(root1==null && root2==null) return true;
	    if(root1==null && root2!=null) return false;
	    if(root1!=null && root2==null) return false;
		if(root1.data==root2.data)
		{
		    return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
		}
		return false;
	}
}