    static Node sortedMerge(Node a,Node b)
    {
        //If either list is empty, return other one
        if(a==null) return b;
        if(b==null) return a;
        Node result = null;
        //Compare data of each node of each list
        if(a.data<=b.data) 
        {
            result = a;
            result.next = sortedMerge(a.next,b);
        }
        else
        {
            result = b;
            result.next = sortedMerge(b.next,a);
        }
        return result;
    }
    
    static Node getMiddle(Node head)
    {
        if(head==null || head.next==null) return head;
        Node fast = head;
        Node slow = head;
        Node prev = head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        return prev;
    }
    
    static Node mergeSort(Node head)
    {
        if(head==null || head.next==null) return head;
        //Get middle of list
        Node middle = getMiddle(head);
        //Next of middle for splitting lists
        Node nextofmiddle = middle.next;
        middle.next=null;
        //Mergesort on first half
        Node left = mergeSort(head);
        //Mergesort on second half
        Node right = mergeSort(nextofmiddle);
        //Merge sorted lists
        Node sortedlist = sortedMerge(left,right);
        return sortedlist;
    }