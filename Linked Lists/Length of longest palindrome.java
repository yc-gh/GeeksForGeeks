    //One approach is to store all linked list elements in an array and check for palndrome
    //Another approach is to iterate through the list while reversing the references such that at any point,
    //All nodes before (current node) reference their previous nodes and all node after (current node) reference next nodes
    //At each iteration, iterate through the list till null is reached on both sides and count no. of common elements
    static int checkCount(Node left,Node right)
    {
        int count = 0;
        for(;left!=null && right!=null;left=left.next,right=right.next)
        {
            if(left.data==right.data) count++;
            else break;
        }
        return count;
    }
    
    public static int maxPalindrome(Node head)
    {
        if(head==null) return 0;
        if(head.next==null) return 1;
        int length = 0;
        Node curr = head;
        Node prev = null;
        while(curr!=null)
        {
            Node next = curr.next;
            curr.next = prev;
            //Check length of palindrome and compare to previous maximum found length
            //2 types of palindromes can exist: odd length and even length
            //Odd length -- when the no. of elements is odd and all elements excluding middle match
            //Even length -- when no. of elements is even and all elements match
            //Check for both -- if either exists, the method will return non 0 value
            //The method returns half value for even length and half - 1 value for odd
            //Add those to get total length
            //In given example (2-3-7-3-2-12-24) when curr is at 7, check both 2-3,3-2-12-24 and 2-3-7,3-2-12-24
            //Odd length -- exclude current element and check elements starting prev and next
            length = Math.max(length,checkCount(prev,next)*2 + 1);
            length = Math.max(length,checkCount(curr,next)*2);
            
            //Move references to next set of nodes
            prev = curr;
            curr = next;
        }
        return length;
    }