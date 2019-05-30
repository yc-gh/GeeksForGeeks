    //Approach -- 
    //Keep track of maxSum value using a static variable
    //Traversal is done similar to inorder, for each node the total sum (node + children)
    //is compared to maxSum and the larger of two subtrees' sums is returned to parent
    //This way, end to end sum is compared in each recursive call and a sum is returned to previous call for checking
    static int maxSum = Integer.MIN_VALUE;
    static int calcSum(Node root)
    {
        if(root==null) return 0;
        //Recursively traverse left subtree till leaf node is reached
        int leftsum = calcSum(root.left);
        //Then recursively traverse right subtree till another leaf is reached
        int rightsum = calcSum(root.right);
        //Since leaf to leaf is traversed, calculate this total (inorder) sum and compare
        int currsum = root.data + leftsum + rightsum;
        if(currsum > maxSum) maxSum = currsum;
        //Return only the larger subtree sum to previous recursive call
        return root.data + Math.max(leftsum,rightsum);
    }
    
    public static int maxPathSum(Node root)
    {
        if(root==null) return 0;
        //Static variable is used to track maximum across method calls
        //It must be reset between test cases
        maxSum = Integer.MIN_VALUE;
        calcSum(root);
        return maxSum;
    }