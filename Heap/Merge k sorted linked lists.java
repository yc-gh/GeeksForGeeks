//Store heads of each list in an array
//Put all nodes of each list into a min heap
//Create a new linked list from min elements of heap 
Node mergeKList(Node[]a,int N)
{
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    //Put all nodes into pq
    for(int i=0;i<N;i++)
    {
        Node curr = a[i];
        while(curr != null)
        {
            pq.add(curr.data);
            curr = curr.next;
        }
    }
    
    //Create a new list
    Node newhead = new Node(pq.remove());
    
    Node last = newhead;
    
    while(pq.size()>0)
    {
        Node newnode = new Node(pq.remove());
        last.next = newnode;
        last = newnode;
    }
    
    return newhead;
}