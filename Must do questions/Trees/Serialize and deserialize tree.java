// 

/* 
ALGORITHM

1. To serialize, use level order traversal
2. For each node, add it to list, followed by its children (-1 for null child)
3. To deserialize, reconstruct tree by checking each list index for data,
     followed by next two indices for its children
*/

class GfG{
    //Can use multiple approaches
    //Such as preorder,level order traversal
    //The array will contain all nodes, with -1 for null children
	public String serialize(Tree root,ArrayList<Integer> aa) 
	{
	    //Level order traversal
        Deque<Tree> queue = new ArrayDeque<>();
        queue.offer(root);
        //Offer root
        aa.add(root.data);
        while(!queue.isEmpty())
        {
            Tree curr = queue.poll();
            //If left child exist
            if(curr.left!=null)
            {
                //Offer to queue and
                queue.offer(curr.left);
                //Add data of left child to list
                aa.add(curr.left.data);
            }
            //Else add -1 to list indicating null child
            else aa.add(-1);
            //Same for right child
            if(curr.right!=null) 
            {
                queue.offer(curr.right);
                aa.add(curr.right.data);
            }
            else aa.add(-1);
        }
        //Store and return as a string
        String treestr = "";
        for(int i : aa)
        {
            treestr = treestr + i + " ";
        }
        return treestr;
    }
public Tree deSerialize(String data) 
    {
        String[] data_arr = data.trim().split("\\s+");
        int n = data_arr.length;
        int[] nodedata = new int[n];
        //Read string into array
        for(int i=0;i<n;i++)
        {
            nodedata[i] = Integer.parseInt(data_arr[i]);
        }
        Tree root = new Tree(nodedata[0]);
        //Using queue again
        Deque<Tree> queue = new ArrayDeque<>();
        queue.offer(root);
        //Indext
        int nodeindex=0;
        //Starting from root node in queue
        //Poll the queue and check left and right children in the array (array!=-1)
        //If children exist, create the left/right reference and push that to queue
        while(!queue.isEmpty())
        {
            Tree curr = queue.poll();
            if(nodedata[nodeindex+1]!=-1)
            {
                curr.left = new Tree(nodedata[nodeindex+1]);
                queue.offer(curr.left);
            }
            //Else left child is null -- 
            //But in java the null reference is already initialized, no need to do it explicitly
            if(nodedata[nodeindex+2]!=-1)
            {
                curr.right = new Tree(nodedata[nodeindex+2]);
                queue.offer(curr.right);
            }
            nodeindex+=2;
        }
        return root;
    }
}