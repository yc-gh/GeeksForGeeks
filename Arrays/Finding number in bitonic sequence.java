class Gfg
{
    //Find the pivot element between the ascending and descending sequence using binary search
    //Search left subarray using binary search
    //Search right subarray using binary search
    
    public static int ascendingBinarySearch(int a[],int l,int r,int key)
    {
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(key==a[mid]) return mid;
            else if(key<a[mid]) r=mid-1;
            else l = mid+1;
        }
        return -1;
    }
    
    public static int descendingBinarySearch(int a[],int l,int r,int key)
    {
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(key==a[mid]) return mid;
            else if(key<a[mid]) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
    
    public static int binarySearch(int a[],int n,int pivot,int key)
    {
        if(key>a[pivot])
        {
            return -1;
        }
        else if(key==a[pivot])
        {
            return pivot;
        }
        else
        {
            int temp = ascendingBinarySearch(a,0,pivot-1,key);
            if(temp!=-1) return temp;
            return descendingBinarySearch(a,pivot+1,n-1,key);
        }
    }
    
    public static int findPivot(int a[],int n,int l,int r)
    {
        int mid = (l+r)/2;
        //Some testcases have pivot at first or last index (Not bitonic sequence ?)
        if(mid==0||mid==n-1) return mid;
        if(a[mid]>a[mid-1] && a[mid]>a[mid+1])
        {
            return mid;
        }
        else if(a[mid]>a[mid-1] && a[mid]<a[mid+1])
        {
            mid = findPivot(a,n,mid+1,r);
        }
        else
        {
            mid = findPivot(a,n,l,mid-1);
        }
        return mid;
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine().trim());
		    String[] input = br.readLine().trim().split("\\s+");
		    int x = Integer.parseInt(br.readLine().trim());
		    int a[] = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(input[i]);
		    }
		    int pivot = findPivot(a,n,0,n-1);
		    if(pivot==-1) System.out.println(-1);
		    else
		    {
		        int search = binarySearch(a,n,pivot,x);
		        System.out.println(search);
		    }
		}
    }
}