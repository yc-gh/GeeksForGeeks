Node sortedMerge(Node headA, Node headB) {
      //If either is null return the other
      if(headA==null) return headB;
      if(headB==null) return headA;
      Node result = null;
      //Compare each head data 
      //Recursively repeat process after comparing each node
      if(headA.data<=headB.data)
      {
          result = headA;
          result.next = sortedMerge(headA.next,headB);
      }
      else
      {
          result = headB;
          result.next = sortedMerge(headB.next,headA);
      }
      return result;
   }