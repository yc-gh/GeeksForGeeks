public static int isAnagram(String text, String word)
    {
        //Map each character of text substring and word to number of occurrences
        Map<Character,Integer> textmap = new HashMap<>();
        Map<Character,Integer> wordmap = new HashMap<>();
        int tlength = text.length();
        int wlength = word.length();
        for(int i=0;i<tlength;i++)
        {
            Character curr = text.charAt(i);
            if(!textmap.containsKey(curr))
            {
                textmap.put(curr,1);
            }
            else
            {
                textmap.put(curr,textmap.get(curr)+1);
            }
        }
        for(int i=0;i<wlength;i++)
        {
            Character curr = word.charAt(i);
            if(!wordmap.containsKey(curr))
            {
                wordmap.put(curr,1);
            }
            else
            {
                wordmap.put(curr,wordmap.get(curr)+1);
            }
        }
        
        //For each character in text substring, 
        //Check if there are same number of occurrences in word
        //If mismatch in count or character, return 0 (not anagram)
        for(int i=0;i<tlength;i++)
        {
            Character curr = text.charAt(i);
            if(wordmap.containsKey(curr)&&wordmap.get(curr)>0)
            {
                textmap.put(curr,textmap.get(curr)-1);
            }
            else return 0;
        }
        return 1;
    }
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String text = br.readLine();
		    String word = br.readLine();
		    int textlength = text.length();
		    int wordlength = word.length();
		    int count = 0;
		    //For each text substring of word length, check if it is an anagram
		    for(int i=0;i<textlength-(wordlength-1);i++)
		    {
		        String textsub = text.substring(i,i+wordlength);
		        count += isAnagram(textsub,word);
		    }
		    System.out.println(count);
		}
	}