   // Note that top is by default null
   // in Java
   StackNode top;
   void push(int a) 
   {
       StackNode newnode = new StackNode(a);
       if(top==null)
       {
            top=newnode;
       }
       else
       {
           newnode.next=top;
           top=newnode;
       }
   }
   int pop() 
   {
       if(top==null) return -1;
       else 
       {
           StackNode curr=top;
           top=top.next;
           return curr.data;
       }
   }