    //3 approaches
    //(1) Use a stack and 2 references, front and follow. 
    //Front moves k nodes and pushes them into stack, follow moves to front and sets data from popped stack elements
    //(2) Same as above, use array
    //(3) Using references, keep a reference to starting of sublist of size k and another reference to next element after sublist
    //Reverse the sublist and set references
    public static Node reverse(Node node, int k)
    {
        if(node==null) return null;
        Node front = node;
        Node follow = node;
        int i = 0;
        
        //Move front till it reaches end of list
        while(front!=null)
        {
            int kindex = k;
            int[] a = new int[k];
            //Traverse k elements at a time and store in array
            while(kindex-->0 && front!=null)
            {
                a[i++] = front.data;
                front = front.next;
            }
            //Move follow till it reaches front, copying array elements in reverse to each node traversed
            while(follow!=front)
            {
                follow.data = a[--i];
                follow = follow.next;
            }
        }
        return node;
    }