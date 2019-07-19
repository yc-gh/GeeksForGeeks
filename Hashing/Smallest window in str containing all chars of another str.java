class GFG
 {
    static int MAX_CHAR = 256; 
     
    //The idea is to read string till all characters (with proper no. of occurrences)
    // are found in the pattern
    //Then starting index is moved so that any unrequired or duplicate matches are skipped
    static String findWindow(char[] str, char[] pat)
    {
        
        int n1 = str.length;
        int n2 = pat.length;
        
        //If length of string is less than pattern, pattern can't be matched
        if(n1 < n2)
        {
            return "-1";
        }
        
        int[] strHash = new int[MAX_CHAR];
        int[] patHash = new int[MAX_CHAR];
        
        //Count occurrences of each character in pattern
        for(char ch : pat)
        {
            patHash[ch]++;
        }
        
        //Variable to track whether all characters of pattern have been read from str
        int count = 0;
        
        //Variable to track starting of window
        int start = 0;
        int startIndex = -1;
        
        //Variable to track minimum length window
        int minLength = Integer.MAX_VALUE;
        
        //Check occurrences of each character in string 
        //And check if it matches any characters in pattern
        for(int j=0; j<n1; j++)
        {
            strHash[str[j]]++;
            
            //In order to check whether all characters of pattern have been found
            //Counting must be done for each occurrence of each character in pattern
            //Duplicates must be handled
            
            //When a character from pattern is found 
            //Count only if occurrences found so far is <= occurrences in pattern
            //Example -- pattern has tt and str has ttt, counting needs to be done only for tt
            if(patHash[str[j]]!=0 && strHash[str[j]]<=patHash[str[j]])
            {
                count++;
            }
            
            //If all characters of pattern have been found
            //Check if the window size can be reduced
            //By removing all unrequired characters from start (initially 0) 
            //And if character at start has more occurrences later in the string, 
            //Then starting can be done from a later index
            if(count == n2)
            {
                while(patHash[str[start]]==0 || strHash[str[start]]>patHash[str[start]])
                {
                    //If character is matched and it has more occurrences further in the string
                    //Reduce it's count (and increment start)
                    if(strHash[str[start]] > patHash[str[start]])
                    {
                        strHash[str[start]]--;
                        
                        //No need to decrement count since this window consists of all required chars
                        // and count tracks all required chars
                    }
                    //Increment start even if no character matched (unrequired character)
                    start++;
                }
                
                //At this point starting index will be at first required matching character
                int windowLength = j - start + 1;
                if(windowLength < minLength)
                {
                    minLength = windowLength;
                    startIndex = start;
                }
            }
        }
        
        //If pattern was not found
        if(startIndex == -1)
        {
            return "-1";
        }
        
        else
        {
            //Rebuild string here or take strings as args of method
            String newstr = new String(str);
            return newstr.substring(startIndex, startIndex + minLength);
        }
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        char[] str = br.readLine().trim().toCharArray();
	        char[] pat = br.readLine().trim().toCharArray();
	        System.out.println(findWindow(str,pat));
	    }
	 }
}