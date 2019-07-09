//The idea is to count number of times each character occurs in the string
//Create a new string by taking each character once at a time without repetition - starting from highest frequency character 
//Compare result length to original string length to verify if rearrangement was successful
class GFG
 {
    //Used for creating a counting array for each lowercase character
    static int MAX_CHAR = 26; 
     
    //Static nested classes are used and objects are referenced from within the enclosing class
    //Therefore outer class name with nested class object is optional
    
    //Comparator used for priority queue ordering
    static class KeyComparator implements Comparator<Key>
    {
        @Override 
        public int compare(Key k1, Key k2)
        {
            //If k1 frequency is less than k2 frequency, k2 should appear before k1 in ordering
            if(k1.freq < k2.freq)
            {
                return 1;
            }
            else if(k1.freq > k2.freq)
            {
                return -1;
            }
            return 0;
        }
    }
    
    //Need to store character and it's frequency together in the priority queue
    //The pqueue is ordered according to each character's frequency
    static class Key
    {
        char ch;
        int freq;
        Key(char c, int f)
        {
            this.ch = c;
            this.freq = f;
        }
    }
     
    static void rearrangeString(String str)
    {
        int n = str.length();
        
        //Count of each character in string
        int[] count = new int[MAX_CHAR];
        
        for(int i=0; i<n; i++)
        {
            count[str.charAt(i)-'a']++;
        }
        
        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        
        //Only those characters with frequency > 0 are added to pqueue
        for(char ch='a'; ch<='z'; ch++)
        {
            int index = ch - 'a';
            if(count[index] > 0)
            {
                pq.add(new Key(ch, count[index]));
            }
        }
        
        String result = "";
        
        //Each character taken from pqueue shouldn't be encountered again in the next iteration
        //To avoid that, highest frequency character is removed from pqueue and saved in prev 
        //It is added back after next character removal (or next character addition to string) from pqueue
        
        //The first time pqueue is polled, prev doesn't exist
        // -1 flag allows first time skip
        Key prev = new Key('#',-1);
        
        while(pq.size() > 0)
        {
            //Get the highest frequency key from pqueue
            Key k = pq.remove();
            
            //Append the character to output string
            result += k.ch;
            
            //Reduce it's frequency
            (k.freq)--;
            
            //Check if previously removed character's frequency is not 0
            //If yes, then add it to pqueue again
            if(prev.freq > 0)
            {
                pq.add(prev);    
            }
            
            //Set new prev as this removed key
            prev = k;
        }
        
        if(result.length() == str.length())
        {
            System.out.println("1");
        }
        else
        {
            System.out.println("0");
        }
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String input = br.readLine().trim();
	        rearrangeString(input);
	    }
	 }
}