//2 approaches --
//Since question just asks whether the string can be broken into dictionary words, 
//(1) way is to keep appending letters till a word is formed, then start afresh from next letter
//(2) way is to use prefix suffix method - when a word is formed, search remaining string for more words in similar fashion

//In this approach, if last letter is reached with valid words found, then string is valid
//If an invalid word exists in between, it's letters will get appended and no valid word will be formed
//A word division is only made when a valid word is found
//Else string is invalid

//(1) approach done here

static boolean wordbreak(String word,int size,Set<String> dict)
{
    boolean[] wb = new boolean[size+1];
    int i=0;
    //Iterate through the entire string
    for(int j=1;j<=size;j++)
    {
        //If a matching word is found, mark it as true
        if(wb[j]==false && dict.contains(word.substring(i,j)))
        {
            wb[j] = true;
        }
        
        //If a word is found, start afresh from the next letter to find more words
        if(wb[j]==true)
        {
            //If this is the last letter at which word is found, then string is valid
            if(j==size) 
            {
                return true;
            }
            
            //Set new starting index as this index
            i=j;
        }
    }
    return false;
}

public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] dictwords = br.readLine().trim().split("\\s+");
            String word = br.readLine().trim();
            int wordlength = word.length();
            Set<String> dict = new HashSet<>();
            for(String s : dictwords)
            {
                dict.add(s);
            }
            System.out.println(wordbreak(word,wordlength,dict) ? 1 : 0);
        }
    }
    
//(2) approach done here

static boolean wordbreak(String word,int size,Set<String> dict)
{
    boolean[] wb = new boolean[size+1];
    
    //Iterate through the string
    for(int i=1;i<=size;i++)
    {
        //If a word is matched, mark it as true
        if(wb[i]==false && dict.contains(word.substring(0,i)))
        {
            wb[i] = true;
        }
        
        //If a marked word is found, search remaining string in similar fashion and mark any words
        if(wb[i]==true)
        {
            if(i==size) 
            {
                return true;
            }
            for(int j=i+1;j<=size;j++)
            {
                if(wb[j]==false && dict.contains(word.substring(i,j)))
                {
                    wb[j] = true;
                }
                if(wb[j]==true && j==size)
                {
                    return true;    
                }
            }
        }
    }
    return false;
}

public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] dictwords = br.readLine().trim().split("\\s+");
            String word = br.readLine().trim();
            int wordlength = word.length();
            Set<String> dict = new HashSet<>();
            for(String s : dictwords)
            {
                dict.add(s);
            }
            System.out.println(wordbreak(word,wordlength,dict) ? 1 : 0);
        }
    }