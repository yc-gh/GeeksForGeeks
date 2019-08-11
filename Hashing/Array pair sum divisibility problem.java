class GFG
 {
    // Returns true if arr[0..n-1] can be divided into pairs 
    // with sum divisible by k. 
    static String canPairs(int ar[], int n, int k)  
    { 
        // An odd length array cannot be divided into pairs 
        if (n % 2 == 1) 
            return "False"; 
          
        // Create a frequency array to count occurrences 
        // of all remainders when divided by k. 
        HashMap<Integer, Integer> hm = new HashMap<>(); 
          
        // Count occurrences of all remainders 
        for (int i = 0; i < n; i++)  
        { 
            int rem = ar[i] % k; 
            if (!hm.containsKey(rem))  
            { 
                hm.put(rem, 0); 
            } 
            hm.put(rem, hm.get(rem) + 1); 
        } 
          
        // Traverse input array and use freq[] to decide 
        // if given array can be divided in pairs 
        for (int i = 0; i < n; i++)  
        { 
             // Remainder of current element 
            int rem = ar[i] % k; 
              
            // If remainder with current element divides 
            // k into two halves. 
            if (2 * rem == k)  
            { 
                // Then there must be even occurrences of 
                // such remainder 
                if (hm.get(rem) % 2 == 1) 
                    return "False"; 
            }  
              
            // If remainder is 0, then there must be two  
            // elements with 0 remainder 
            else if (rem == 0)  
            { 
                // Then there must be even occurrences of 
                // such remainder 
                if (hm.get(rem) % 2 == 1) 
                    return "False"; 
            } 
              
            // Else number of occurrences of remainder 
            // must be equal to number of occurrences of 
            // k - remainder 
            else 
            { 
                if (hm.get(k - rem) != hm.get(rem)) 
                    return "False"; 
            } 
        } 
        return "True"; 
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
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = Integer.parseInt(input[i]);
            }
            System.out.println(canPairs(arr, n, k));
	    }
	 }
}