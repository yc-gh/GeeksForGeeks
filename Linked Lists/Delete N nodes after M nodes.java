//Keep two pointers (references) one for reaching M-1th node, other for traversing N nodes 
static Node linkdelete(Node head, int M, int N)
{
    if(head==null || N==0) return head;
    int x = M-1;
    int y = N;
    Node first = head;
    Node second = head;
    //Repeat till first pointer reaches null
    while(first!=null)
    {
        //Traverse M-1 nodes 
        while(x-->0 && first.next!=null)
        {
            first = first.next;
        }
        //Set second pointer here as well
        second = first;
        //Traverse N nodes using second pointer
        while(y-->0 && second.next!=null)
        {
            second = second.next;
        }
        first.next = second.next;
        first = first.next;
    }
} 