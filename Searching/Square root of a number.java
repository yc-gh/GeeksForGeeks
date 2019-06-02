long floorSqrt(long x)
	 {
	    long i=1;
	    for(;i*i<=x;i++);
	    return i-1;
	 }