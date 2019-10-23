class GfG
{
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        int size = q.size();
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0; i<k; i++)
        {
            stack.push(q.poll());
        }
        
        while(stack.size()>0)
        {
            q.offer(stack.pop());
        }
        
        for(int i=0; i<(size-k); i++)
        {
            q.offer(q.poll());
        }
        
        return q;
    }
}