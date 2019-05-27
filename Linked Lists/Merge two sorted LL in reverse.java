Node mergeResult(Node headA, Node headB)
    {
      //If either is null return the other
      if(headA==null) return headB;
      if(headB==null) return headA;
      Node result = null;
      //Iterate both lists and compare each node till either reaches null
      while(headA!=null && headB!=null)
      if(headA.data<=headB.data)
      {
          Node savednext = headA.next;
          headA.next = result;
          result = headA;
          headA = savednext;
      }
      else
      {
          Node savednext = headB.next;
          headB.next = result;
          result = headB;
          headB = savednext;
      }
      
      //Attach remaining elements if either list reaches null before other one
      while(headA!=null)
      {
          Node savednext = headA.next;
          headA.next = result;
          result = headA;
          headA = savednext;
      }
      while(headB!=null)
      {
          Node savednext = headB.next;
          headB.next = result;
          result = headB;
          headB = savednext;
      }
      return result;
    }