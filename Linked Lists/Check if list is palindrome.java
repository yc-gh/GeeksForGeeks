boolean isPalindrome(Node head) 
    {
        //Stack Implementation
        Deque<Integer> stack = new ArrayDeque<>();
        Node curr = head;
        while(curr!=null)
        {
            stack.push(curr.data);
            curr = curr.next;
        }
        curr = head;
        while(!stack.isEmpty())
        {
            if(stack.pop()!=curr.data) return false;
            curr = curr.next;
        }
        return true;
    }

    /* ALTERNATE STRING APPROACH */

    boolean isPalindrome(Node head) 
    {
        //String implementation
        Node curr = head;
        String test = "";
        while(curr!=null)
        {
            test+=curr.data;
            curr=curr.next;
        }
        StringBuilder original = new StringBuilder(test);
        if(!test.equals(original.reverse().toString())) return false;
        return true;
    } 