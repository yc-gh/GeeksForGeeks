// https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1

/* 
ALGORITHM

1. Keep two references head, prev
2. Use inorder traversal and link nodes to each other
3. Return head reference

*/

class GfG
{
    Node head, prev;
    Node bToDLL(Node root)
    {
    	if(root==null) return root;
    	
    	bToDLL(root.left);
    	
	    if(prev==null) head = root;
	    else 
	    {
	        prev.right = root;
	        root.left = prev;
	    }
	    
	    prev = root;
	    
	    bToDLL(root.right);
	    
	    return head;
    }
}