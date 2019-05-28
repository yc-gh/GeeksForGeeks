boolean isIdentical(Node root1, Node root2)
	{
	    //If both roots are at null
	    if(root1==null&&root2==null) return true;
	    //If either is null
		if(root1==null&&root2!=null) return false;
		if(root1!=null&&root2==null) return false;
		//Compare data
		if(root1.data!=root2.data) return false;
		//Check left subtree
		boolean left = isIdentical(root1.left,root2.left);
		//Check right subtree
		boolean right = isIdentical(root1.right,root2.right);
		return left&&right;
	}