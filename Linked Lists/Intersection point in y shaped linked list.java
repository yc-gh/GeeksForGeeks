    
    //Iterate through one list
    //For each node, traverse the other list and check if this node is reachable
	int intersectPoint(Node headA, Node headB)
	{
         if(headA==null || headB==null) return -1;
         
         //Set mark node for checking
         Node mark = headA;
         
         //Traverse till end of list A
         while(mark!=null)
         {
             //Initialize iterating node as headB
             Node currB = headB;
             //Traverse till currB reaches end of list or mark node
             while(currB!=null && currB!=mark)
             {
                 currB = currB.next;
             }
             //If currB reached mark node
             if(currB!=null) return currB.data;
             //Else check for next node in list A
             mark = mark.next;
         }
         
         //Lists are not merged
         return -1;
	}