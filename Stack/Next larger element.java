//Approach --
//A naive approach is to use 2 loops by picking one index
// and checking remaining array for greater element

//A better approach is to find the greater element of next element if next is not the greater element
//Once a greater element is found, this has to be checked against all previous elements which don't have a greater element
//This is done using a stack 

static void printNGE(long[] a, int n)
{
    Deque<Integer> stack = new ArrayDeque<>();
    long[] nextarr = new long[n];
    
    
    //Indices are pushed instead of element
    //Push first index
    stack.push(0);
    
    //Index of element in the array to be checked against top of stack
    int next = 1;
    
    //Traverse all elements     
    while(next < n)
    {   
        //While stack has elements and top element is smaller, keep popping
        while(!stack.isEmpty() && (a[next] > a[stack.peek()]))        
        {
            int curr = stack.pop();
            nextarr[curr] = a[next];
        }
        
        //Push the array element to stack so that greater of this will be checked 
        stack.push(next);
        
        //Increment index
        next++;
    }
    
    //If any elements are left in stack
    //These don't have a greater element
    while(!stack.isEmpty())
    {
        int curr = stack.pop();
        nextarr[curr] = -1;
    }
    
    StringBuilder output = new StringBuilder();
    
    for(long i : nextarr)
    {
        output.append(i+" ");    
    }
    
    System.out.println(output);
}
    
public static void main (String[] args) throws IOException
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while(t-->0)
    {
        int n = Integer.parseInt(br.readLine().trim());
        String[] input = br.readLine().trim().split("\\s+");
        long[] arr = new long[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = Long.parseLong(input[i]);
        }
        
        printNGE(arr, n);
    }
}