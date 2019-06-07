    //Method to check if a person knows the other
    boolean knows(int M[][], int first, int second)
    {
        return M[first][second]==1 ? true : false;
    }
    
    //Checking matrix for an all 0 row would require n^2 checks
    //Push all people into a stack
    //Pop 2 people from stack
    //If first knows second, push second back to stack (possible celebrity)
    //Else push first (if first doesn't know second, second can't be celebrity)
    //Repeat till only 1 person left in stack
    //If last person knows anyone or if someone doesn't know last person, no celebrity exists
    //Else last person is celebrity
    int getId(int M[][], int n)
    {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++) stack.push(i);
        while(stack.size()>1)
        {
            int first = stack.pop();
            int second = stack.pop();
            if(knows(M,first,second))
            {
                stack.push(second);
            }
            else
            {
                stack.push(first);
            }
        }
        //Get last remaining person
        int last = stack.pop();
        for(int i=0;i<n;i++)
        {
            //Skip checking last with itself
            //If last person knows anyone or someone doesn't know last person, return -1
            if(last!=i && (!knows(M,i,last)||knows(M,last,i)))
            {
                return -1;
            }
        }
        return last;
    }

    //ALTERNATIVE APPROACH
    //Using two pointers

    //Method to check if a person knows the other
    boolean knows(int M[][], int first, int second)
    {
        return M[first][second]==1 ? true : false;
    } 
    
    int getId(int M[][], int n)
    {
        int first = 0;
        int second = n-1;
        //Check each pair of people 
        //If first knows second, first can't be celebrity, check next of first
        //Else second can't be celebrity, check previous of second
        //Continue till only one person left
        while(first < second)
        {
            if(knows(M,first,second)) first++;
            else second--;
        }
        //Check last person for celebrity
        int last = first;
        for(int i=0;i<n;i++)
        {
            //Skip checking last with itself
            //If last person knows anyone or someone doesn't know last person, return -1
            if(last!=i && (!knows(M,i,last)||knows(M,last,i)))
            {
                return -1;
            }
        }
        return last;
    }