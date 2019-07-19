class GFG
 {
    static class Node
    {
        int data;
        Node left;
        Node right;
        
        Node(int d)
        {
            data = d;
            left = null;
            right = null;
        }
    }
    
    static Node arrToBst(int[] arr, int start, int end)
    {
        //Base case -- when single elements are reached
        if(start > end)
        {
            return null;
        }
        
        //Get middle index for current subtree root
        int mid = start + (end - start)/2;
        
        Node node = new Node(arr[mid]);
        
        //Elements in the left subarray belong in left subtree
        node.left = arrToBst(arr, start, mid-1);
        
        //Elements in right subarray belong in right subtree
        node.right = arrToBst(arr, mid+1, end);
        
        return node;
    }
    
    static void printPreorder(Node root)
    {
        if(root == null)
        {
            return ;
        }
        
        System.out.print(root.data+" ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        int[] arr = new int[n];
	        for(int i=0; i<n; i++)
	        {
	            arr[i] = Integer.parseInt(input[i]);
	        }
	        Node root = arrToBst(arr, 0, n-1);
	        printPreorder(root);
	        System.out.println();
	    }
	 }
}