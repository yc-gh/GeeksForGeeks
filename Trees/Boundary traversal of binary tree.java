//Print root node
//Print left boundary nodes except leaf nodes
//Print leaf nodes 
//Print right boundary nodes except leaf nodes

StringBuilder output;
//Demonstrated initialization block
{
    output = new StringBuilder();
}

void printLeftBoundary(Node node)
{
    if(node==null) return;
    
    //Traverse left while left child exists
    if(node.left!=null)
    {
        //Print each node of left boundary
        output.append(node.data+" ");
        //Move to left child
        printLeftBoundary(node.left);
    }
    
    //If right child exists, print and move right
    else if(node.right!=null)
    {
        output.append(node.data+" ");
        printLeftBoundary(node.right);
    }
    //Else if no children exist (leaf node is reached), do nothing
}
void printRightBoundary(Node node)
{
    if(node==null) return;
    
    //Printing is done in reverse (after traversing)
    //Traverse right while right child exists
    if(node.right!=null)
    {
        printRightBoundary(node.right);
        output.append(node.data+" ");
    }
    
    //If left child exists, move left
    else if(node.left!=null)
    {
        printRightBoundary(node.left);
        output.append(node.data+" ");
    }
    //Else if leaf node is reached, do nothing
}
void printLeaves(Node node)
{
    if(node==null) return;
    
    //Inorder traversal, print leaf nodes
    printLeaves(node.left);
    if(node.left==null && node.right==null)
    {
        output.append(node.data+" ");
    }
    printLeaves(node.right);
}
void printBoundary(Node node)
{
    if(node==null) return;
    output.append(node.data+" ");
    
    //If methods are called with node as parameter, root node will get printed as well
    //Print left boundary nodes
    printLeftBoundary(node.left);
    
    //Print leaf nodes of left subtree
    printLeaves(node.left);
    
    //Print leaf nodes of right subtree
    printLeaves(node.right);
    
    //Print right boundary nodes
    printRightBoundary(node.right);
    System.out.print(output);
}