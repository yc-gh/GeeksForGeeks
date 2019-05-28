    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    /* The method insert to push element
       into the queue */
    void insert(int B)
    {
	   s1.push(B);
    }
    /* The method remove which return the
      element popped out of the queue*/
    int remove()
    {
       //Push all elements from stack1 to stack2 
       //Pop one element from stack2 -- this is the first pushed element of stack1 (required element)
       //Push all elements from stack2 back to stack1
	   if(s1.isEmpty()) return -1;
	   int top_s2 = 0;
	   while(!s1.isEmpty()) 
	   {
	       int s1_ele = s1.pop();
	       s2.push(s1_ele);
	   }
       top_s2 = s2.pop();
       while(!s2.isEmpty())
       {
           int s2_ele = s2.pop();
           s1.push(s2_ele);
       }
	   return top_s2;
    }