Node addTwoLists(Node first, Node second) {
        Node res = null; // res is head node of the resultant list 
        Node prev = null; 
        Node temp = null; 
        int carry = 0, sum; 
  
        while (first != null || second != null) //while either list exist 
        { 
            // Calculate value of next digit in resultant list. 
            // The next digit is sum of following things 
            // (i)  Carry 
            // (ii) Next digit of first list (if there is a next digit) 
            // (ii) Next digit of second list (if there is a next digit) 
            sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0); 
  
            // update carry for next calulation 
            carry = (sum >= 10) ? 1 : 0; 
  
            // update sum if it is greater than 10 
            sum = sum % 10; 
  
            // Create a new node with sum as data 
            temp = new Node(sum); 
  
            // if this is the first node then set it as head of 
            // the resultant list 
            if (res == null) 
            { 
                res = temp; 
            } 
            else // If this is not the first node then connect it to the rest. 
            { 
                prev.next = temp; 
            } 
  
            // Set prev for next insertion 
            prev = temp; 
  
            // Move first and second pointers to next nodes 
            if (first != null) 
            { 
                first = first.next; 
            } 
            if (second != null) 
            { 
                second = second.next; 
            } 
        } 
  
        if (carry > 0) 
        { 
            temp.next = new Node(carry); 
        } 
  
        // return head of the resultant list 
        return res;
    }