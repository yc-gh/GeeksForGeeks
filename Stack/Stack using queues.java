Queue<Integer> q1 = new LinkedList<Integer>();
Queue<Integer> q2 = new LinkedList<Integer>();

//Pop from one queue till the last element and push these to other queue
//Last element is the required element
//Swap references of queues so this method can be reused
int pop()
{
    if(q1.size()==0)
    {
        return -1;
    }
    while(q1.size()>1)
    {
        q2.offer(q1.poll());
    }
    
    int retValue = q1.poll();
    
    //Swap queue references so that proper queue is checked on each method call
    
    Queue<Integer> temp_q = q1;
    q1 = q2;
    q2 = temp_q;
    
    return retValue;
}

/* The method push to push element into the stack */
void push(int a)
{
    q1.offer(a);	
}