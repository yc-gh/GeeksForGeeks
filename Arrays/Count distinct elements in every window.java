void countDistinct(int A[], int k, int n)
    {
        StringBuilder output = new StringBuilder();
	    for(int i=0;i<n-(k-1);i++)
	    {
	        Set<Integer> set = new HashSet<>();
	        for(int j=0;j<k;j++) set.add(A[i+j]);
	        output.append(set.size()+" ");
	    }
	    System.out.print(output);
    }