public static void pairwiseSwap(Node node)
    {
       Node curr = node;
       //While current and next node are not null
       //Swap data
       while(curr!=null&&curr.next!=null)
       {
           int currdata = curr.data;
           int nextdata = next.data;
           currdata = currdata + nextdata;
           nextdata = currdata - nextdata;
           currdata = currdata - nextdata;
           curr = curr.next.next;
       }
       StringBuilder output = new StringBuilder();
       while(node!=null)
       {
           output.append(node.data);
           node = node.next; 
       }
    }