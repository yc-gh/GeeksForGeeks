//The input needs to be sorted with each number entered
//Therefore one way is to use Insertion sort which has very high complexity
//Another approach is to use self balancing tree
//A third approach is to use Heap sort using two heaps
    
//The idea is to split the input into two parts by the median index 
//If there are odd number of elements, the value at median index is required
//If there are even number of elements, the average value of both median indices are required

//A max heap and min heap are considered
//The max heap is used for the left side elements and min for right side
//For even number of elements, we need the two median index elements ie. largest from maxheap and smallest from minheap
//For odd number of elements, we need the extra element from either heap (set according to preference)

static StringBuilder output;

static void findMedian(PriorityQueue<Integer> minheap, PriorityQueue<Integer> maxheap, int x)
{
    //One heap is chosen as entry for each element
    //On each input, the largest/smallest element (depending on which heap is entry point)
    // is sent to other heap to balance the entire input so far
    //If the size of input heap becomes less than other heap, an element is re-transferred to input heap to re-balance
    maxheap.add(x); 
    minheap.add(maxheap.poll());
    if(maxheap.size() < minheap.size()) 
    {
        maxheap.add(minheap.poll());
    }
    
    //Even number of elements (heap sizes equal) --> average of max from maxheap and min from minheap
    if(maxheap.size() == minheap.size())
    {
        int maxroot = maxheap.peek();
        int minroot = minheap.peek();
        int avg = (maxroot + minroot)/2;
        output.append(avg+"\n");
    }
    
    //Odd number of elements --> extra element from input heap
    else
    {
        output.append(maxheap.peek()+"\n");
    }
}
    
public static void main (String[] args) throws IOException
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Integer> minheap = new PriorityQueue<>();
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    output = new StringBuilder();
    int n = Integer.parseInt(br.readLine().trim());
    while(n-->0)
    {
        int x = Integer.parseInt(br.readLine().trim());
        findMedian(minheap, maxheap, x);
    }
    System.out.print(output);
}