class GfG
{
    // sq is the object of class TwoStack
    /* The method push to push element into the stack 2 */
    void push1(int x, TwoStack sq)
    {
        sq.arr[++sq.top1]=x;
    }
    /* The method push to push element into the stack 2*/
    void push2(int x, TwoStack sq)
    {
        sq.arr[--sq.top2]=x;
    }
    /* The method pop to pop element from the stack 1 */
    int pop1(TwoStack sq)
    {
        if(sq.top1==-1) return -1;
        int ele = sq.arr[sq.top1--];
        return ele;
    }
    /* The method pop to pop element from the stack 2 */
    int pop2(TwoStack sq)
    {
        if(sq.top2==sq.size) return -1;
        int ele = sq.arr[sq.top2++];
        return ele;
    }
}