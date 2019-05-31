    //Insertion in BST is done at leaf nodes
    Node insert(Node root, int data)
    {
         //If tree is empty or if null child of leaf node is reached, return a new node
         if(root==null)
         {
             Node newnode = new Node(data);
             return newnode;
         }
         //If a node matches the data, return unmodified node
         if(data==root.data)
         {
             return root;
             
         }
         //If key data is less than current node, traverse it's left subtree
         //Existing links/references remain unchanged, 
         //A newnode is returned to the left or right of current node if current is a leaf node
         if(data<root.data)
         {
             root.left = insert(root.left,data);
         }
         //If key data is greater than current node, traverse it's right subtree
         else if(data>root.data)
         {
             root.right = insert(root.right,data);
         }
         //This always returns root of the tree
         return root;
    }