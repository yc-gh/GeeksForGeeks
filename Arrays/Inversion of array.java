//Use modified merge sort
//In merge method during comparison, 
//for each element of right subarray that is < element of left subarray,
//All remaining elements in left subarray (which will be sorted) are greater than right subarray element
//Therefore these are added to inversion count
//This process is done for each merge and added to counts from previous merges
static long merge(int[] arr,int l,int m,int r)
{
    //Merge method same as default
    int n1 = m-l+1;
    int n2 = r-m;
    int i=0,j=0,k=l;
    long count = 0;
    int[] leftarr = new int[n1];
    int[] rightarr = new int[n2];
    for(i=0;i<n1;i++)
    {
        leftarr[i] = arr[l+i];
    }
    for(j=0;j<n2;j++)
    {
        rightarr[j] = arr[m+1+j];
    }
    i=0;
    j=0;
    while(i<n1 && j<n2)
    {
        if(leftarr[i]<=rightarr[j])
        {
            arr[k++] = leftarr[i++];
        }
        //When a smaller element is found in right subarray
        //All remaining elements in left subarray will be > than this 
        //Add those to inversion count
        else
        {
            arr[k++] = rightarr[j++];
            count+=n1-i;
        }
    }
    while(i<n1)
    {
        arr[k++] = leftarr[i++];
    }
    while(j<n2)
    {
        arr[k++] = rightarr[j++];
    }
    return count;
}

//Modified merge sort to add inversion counts of all merges
static long mergesort(int[] arr,int l,int r)
{
    if(l<r)
    {
        int m = (l+r)/2;
        long leftinver = mergesort(arr,l,m);
        long rightinver = mergesort(arr,m+1,r);
        long mergeinver = merge(arr,l,m,r);
        return leftinver + rightinver + mergeinver;
    }
    return 0;
}
public static void main (String[] args) throws IOException
    {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while(t-->0)
    {
        int n = Integer.parseInt(br.readLine().trim());
        String[] input = br.readLine().trim().split("\\s+");
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = Integer.parseInt(input[i]);
        }
        long count = mergesort(arr,0,n-1);
        System.out.println(count);
    }
    }