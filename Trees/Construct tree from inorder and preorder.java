    //Search index of preorder digit in inorder
    static int search(int ino[],int st,int end,int key)
    {
        int index=0;
        for(int i=st;i<=end;i++)
        {
            if(ino[i]==key) 
            {
                index=i;
                break;
            }
        }
        return index;
    }
    
    public static Node buildTree(int ino[], int pre[], int st, int end)
    {
       //If there are any single null left/right children of a node, this condition will be true
       if(st>end) return null;
       
       //Create a new node from current preorder index number
       Node currnode  = new Node(pre[preIndex++]);
       
       //When a leaf node is reached, this condition will hold true
       if(st==end) return currnode;
       
       //Search position of current node in inorder 
       int inoIndex = search(ino,st,end,currnode.data);
       
       //Build left subtree of current node using the inorder digits to the left of current digit
       currnode.left = buildTree(ino,pre,st,inoIndex-1);
       
       //Build right subtree of current node using the inorder digits to the right of current digit
       currnode.right = buildTree(ino,pre,inoIndex+1,end);
       return currnode;
    }