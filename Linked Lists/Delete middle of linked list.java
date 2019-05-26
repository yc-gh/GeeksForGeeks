Node Delete(Node head)
   {
       //Two pointers used, one moves at double the rate of other
       //Slow starts after one iteration of fast, resulting in one less movement (final position before middle)
	   Node fast = head;
	   Node slow = head;
	   boolean start = false;
	   while(fast!=null&&fast.next!=null)
	   {
	       fast=fast.next.next;
	       if(start)
	       {
	            slow=slow.next;   
	       }
	       else
	       {
	           start=true;
	       }
	   }
	   slow.next=slow.next.next;
	   return head;
   }