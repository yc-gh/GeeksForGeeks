//Pattern is matched if each character in the pattern string 
//Matches the same character in dictionary word
//Map each character of pattern to character in dictionary word if not mapped
//If a character is already mapped but doesn't map to current character in dictionary word, pattern match fails 
public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
	{
	    ArrayList<String> result = new ArrayList<>();
	    int patternlength = pattern.length();
	    char[] patternchars = pattern.toCharArray();
	    for(String dictword : dict)
        {
            int wordlength = dictword.length();
            char[] dictwordchars = dictword.toCharArray();
            if(wordlength!=patternlength) continue;
            Map<Character,Character> map = new HashMap<>();
            boolean patternmatched = true;
            for(int i=0;i<wordlength;i++)
            {
                if(map.containsKey(patternchars[i]))
                {
                    if(!map.get(patternchars[i]).equals(dictwordchars[i]))
                    {
                        patternmatched = false;
                        break;
                    }
                }
                else
                {
                    map.put(patternchars[i],dictwordchars[i]);
                }
            }
            if(patternmatched)
            {
                result.add(dictword);
            }
        }
        return result;
	}