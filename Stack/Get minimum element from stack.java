class GfG
{
    int minEle = -1;
    Stack<Integer> s = new Stack<>();
    /*returns min element from stack*/
    int getMin()
    {
	    //If stack is empty
	    if(s.size()<1) 
	    {
	        return -1;
	    }
	    return minEle;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	    //If stack is empty
	    if(s.size()<1)
	    {
	        return -1;
	    }
	    
	    //Else get the top element 
	    //And if popped element was min element
	    //Pop again to get previous min
	    //Exclude the case when only 1 element in stack
	    int ele = s.pop();
	    if(ele == minEle && s.size()>1)
	    {
	        minEle = s.pop();
	    }
	    
	    //If stack becomes empty
	    //Reset min element
	    else if(s.size()<1)
	    {
	        minEle = -1;
	    }
	    return ele;
    }
    /*push element x into the stack*/
    void push(int x)
    {
	    //If first push into stack
	    //Set min element
	    if(minEle == -1)
	    {
	        s.push(x);
	        minEle = x;
	    }
	    
	    //Else 
	    //If pushed element is smaller than min element
	    //Push min element then push new element and set new min
	    else
	    {
	        if(x <= minEle)
	        {
	            s.push(minEle);
	            s.push(x);
	            minEle = x;
	        }
	        
	        //Else just push new element
	        else
	        {
	            s.push(x);
	        }
	    }
    }	
}