    //Modified binary search is used
    //For each middle (pivot) index found, 
    //Check if the left or right subarrays are sorted
    //And check if key value lies in that subarray 
	static int findEle(int[] a,int low,int high,int k)
	{
	    //If low/high values crossed during checking, meaning element wasn't found
	    if(low<=high)
	    {
	        //Calculate middle index
	        int mid = (low+high)/2;
			
			//If key matches middle element
	        if(a[mid]==k) return mid;
	        //Else if left subarray is sorted 
	        else if(a[low]<a[mid])
	        {
	            //If key value is b/w lowest and highest(middle) values of this left subarray (it's sorted)
	            if(k<a[mid] && k>=a[low]) return findEle(a,low,mid-1,k);
	            //Else check right side subarray
	            else return findEle(a,mid+1,high,k);
	        }
	        //Else (right subarray is sorted)
	        else
	        {
	            //If key value is b/w lowest(middle) and highest values of right subarray (it's sorted)
	            if(k>a[mid]&&k<=a[high]) return findEle(a,mid+1,high,k);
	            //Else check left subarray
	            else return findEle(a,low,mid-1,k);
	        }
	    }
        return -1;
	}
    
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        String[] input = br.readLine().trim().split("\\s+");
	        int k = Integer.parseInt(br.readLine().trim());
	        int[] a = new int[n];
	        for(int i=0;i<n;i++)
	        {
                a[i] = Integer.parseInt(input[i]);
	        }
	        //Set low and high indexes for binary search
	        int low = 0;
	        int high = n-1;
	        System.out.println(findEle(a,low,high,k));
	    }
	 }