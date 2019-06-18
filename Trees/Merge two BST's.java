public static void merge(Node root1 , Node root2)
{
    Deque<Node> stack1 = new ArrayDeque<>();
    Deque<Node> stack2 = new ArrayDeque<>();
    Node curr1 = root1;
    Node curr2 = root2;
    StringBuffer output = new StringBuffer();
    //Use DFS traversal (gives inorder sorted output) for each tree using 2 auxiliary stacks
    //Push elements from both trees (till smallest node of current subtree)
    //Instead of popping elements, peek both stacks and compare
    //If tops of both are equal, pop both and print 
    //Else pop the smaller one and print (don't pop other one)
    //Repeat till either tree is traversed
    while((curr1!=null || stack1.size()>0) && (curr2!=null || stack2.size()>0))
    {
        while(curr1!=null)
        {
            stack1.push(curr1);
            curr1 = curr1.left;
        }
        while(curr2!=null)
        {
            stack2.push(curr2);
            curr2 = curr2.left;
        }
        int s1top = stack1.peek().data;
        int s2top = stack2.peek().data;
        if(s1top==s2top)
        {
            curr1 = stack1.pop();
            curr2 = stack2.pop();
            curr1 = curr1.right;
            curr2 = curr2.right;
            output.append(s1top+" "+s2top+" ");
        }
        else if(s1top<s2top)
        {
            curr1 = stack1.pop();
            curr1 = curr1.right;
            output.append(s1top+" ");
        }
        else
        {
            curr2 = stack2.pop();
            curr2 = curr2.right;
            output.append(s2top+" ");
        }
    }
    
    //If either tree still has elements left
    //DFS traversal for remaining elements
    while(curr1!=null || stack1.size()>0)
    {
        while(curr1!=null)
        {
            stack1.push(curr1);
            curr1 = curr1.left;
        }
        curr1 = stack1.pop();
        output.append(curr1.data+" ");
        curr1 = curr1.right;
    }
    while(curr2!=null || stack2.size()>0)
    {
        while(curr2!=null)
        {
            stack2.push(curr2);
            curr2 = curr2.left;
        }
        curr2 = stack2.pop();
        output.append(curr2.data+" ");
        curr2 = curr2.right;
    }
    System.out.print(output);
}