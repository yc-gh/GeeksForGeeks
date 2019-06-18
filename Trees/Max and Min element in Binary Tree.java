public static int findMax(Node root)
	{
        if(root==null) return 0;
        int curr = root.data;
        
        //Recursively find max of left subtree
        int left = findMax(root.left);
        
        //Recursively find max of right subtree
        int right = findMax(root.right);
        
        //Compare
        if(curr>left&&curr>right) return curr;
        else if (left>curr&&left>right) return left;
        else return right;
	}
	public static int findMin(Node root)
	{
	    if(root==null) return 0;
        int curr = root.data;
        int left = findMin(root.left);
        int right = findMin(root.right);
        
        //Null pointers return 0
        //Must not compare to 0 values
        if(root.left==null&&root.right==null) return curr;
        if(root.left==null)
        {
            if(curr<right) return curr;
            else return right;
        }
        
        if(root.right==null)
        {
            if(curr<left) return curr;
            else return left;
        }
        
        if(curr<left&&curr<right) return curr;
        else if (left<curr&&left<right) return left;
        else return right;
	}