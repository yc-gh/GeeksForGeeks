//We need to save the k largest elements till the current element of the stream
//And we need the kth largest element
//Use a min heap of size k
//The min element of the heap gives kth largest element
//A new element is added to heap only if it is larger than the min of heap

static int getKmin(PriorityQueue<Integer> minHeap, int k, int i)
{   
    //If heap doesn't have enough elements yet
    if(minHeap.size() < k)
    {
        minHeap.add(i);
    }
    
    //Else if heap has k elements already
    else if(minHeap.size() == k)
    {
        //Add new element if it is greater than root
        if(i > minHeap.peek())
        {
            minHeap.poll();
            minHeap.add(i);
        }
    }
    
    //If the heap doesn't have k elements yet, kth largest is -1
    if(minHeap.size()<k)
    {
        return -1;
    }
    
    //Else return kth largest ie. root of k size minheap
    return minHeap.peek();
}

public static void main (String[] args) throws IOException
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while(t-->0)
    {
        String[] input = br.readLine().trim().split("\\s+");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        input = br.readLine().trim().split("\\s+");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder output = new StringBuilder();
        for(int i=0;i<n;i++)
        {
            output.append(getKmin(minHeap, k, Integer.parseInt(input[i])) + " ");
        }
        System.out.println(output);
    }
}