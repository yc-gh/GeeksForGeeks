// https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1

/* 
ALGORITHM

1. Search if nodes are present in the tree
2. If both nodes are less than current node, search left subtree
3. If both nodes are greater than current node, search right subtree
4. Else current node is LCA

*/

class BST
{   
    static boolean search(Node root, int n1)
    {
        if(root==null)
        {
            return false;
        }

        if(root.data==n1)
        {
            return true;
        }

        if(root.data > n1)
        {
            return search(root.left, n1);
        }

        if(root.data < n1)
        {
            return search(root.right, n1);
        }
        
        return false;
    }

    Node LCA(Node root, int n1, int n2) 
    {
        if(search(root,n1) && search(root,n2))
        {
            while (root != null)  
            {  
                // If both n1 and n2 are smaller  
                // than root, then LCA lies in left  
                if (root.data > n1 && root.data > n2)  
                    root = root.left;  
          
                // If both n1 and n2 are greater  
                // than root, then LCA lies in right  
                else if (root.data < n1 && root.data < n2)  
                    root = root.right;  
          
                else break;  
            }  
            return root;
        }
        return null;
    }
}
