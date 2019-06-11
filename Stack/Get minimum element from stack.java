    //Initialization is not actually done here, compiler will move these into a constructor
    int minEle = -1;
    //Create object of stack 
    Stack<Integer> s = new Stack<>();
    /*returns min element from stack*/
    int getMin()
    {
	    return minEle;
    }
    
    /*returns popped element from stack*/
    int pop()
    {
        //If stack is empty 
        if(s.isEmpty()) return -1;
        int y = s.pop();
        //If popped element was last element, set minEle as -1
        if(s.isEmpty()) 
        {
            minEle = -1;
        }
        /*
          If popped element is less than min element, this is the modified (encrypted)
          value that was pushed and can be used to find the previous min element
          2*currmin - prevmin = y (this expression was used)
          2*currmin - y = prevmin
          The method must return the current minimum, not the value on stack
        */
        else if(y < minEle)
        {
            int currmin = minEle;
            minEle = 2*minEle - y;
            return currmin;
        }
        return y;
    }
    /*push element x into the stack*/
    void push(int x)
    {
        //When stack is empty, push and make the element min element
	    if(s.isEmpty())
	    {
	        s.push(x);
	        minEle = x;
	        return ;
	    }
        if(x<minEle)
        {
            /*
              We need a way to find previous min from current element
              Since we can't just directly map this element to previous min, 
              some arithmetic value involving previous min must be pushed to stack.
              Then this new value can be reversed to find the previous value.
              Also, since this value is the new min BUT the stack will not contain this exact value,
              we need to use an expression that can be detected as being the min value (such as a value that is smaller than this min value)
              So a suitable expression is 
              x < min (known) 
              x - min < 0
              x - min + x < x
              2*x - min < x
              y = 2*x - min should be pushed to stack 
            */
            s.push(2*x-minEle);
            //Set minEle as this element
            minEle = x;
        }
        //Else just push the element
        else
        {
            s.push(x);
        }
        return;
    }