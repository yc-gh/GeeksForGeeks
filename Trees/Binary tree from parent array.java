//Reference for root node, reset this to null for each test case
static Node root=null;

//Creating nodes
//If node is already created, do nothing
//Else create a new node and set root if root doesn't exist
//Create parent if parent doesn't exist
static void createNode(int[] parent,int i,Node[] created)
{
    //Already created
    if(created[i]!=null) return;
    
    //Create node and store reference
    created[i] = new Node(i);
    
    //If parent is -1, this node is root
    if(parent[i]==-1)
    {
        root = created[i];
        return;
    }
    
    //If parent doesn't exist, create it
    if(created[parent[i]]==null)
    {
        createNode(parent,parent[i],created);
    }
    
    //Set left or right child whichever is null
    Node parentnode = created[parent[i]];
    if(parentnode.left==null) parentnode.left = created[i];
    else parentnode.right = created[i];
}
public static Node createTree(int[] parent, int n)
{
    root=null;
    
    //Keep array of references to track whether a node is created or not
    Node[] created = new Node[n];
    for(int i=0;i<n;i++)
    {
        createNode(parent,i,created);
    }
    return root;
}