static Set<String> set = new TreeSet<>();

//If a word is matched
//The remaining substring is checked for more words recursively 
//Division is done per word found -- a DP solution will also work but the output string will require some backtracking 
//When the empty string is encountered, the words found are printed
//Empty string is encountered only when words were found till the last letter of the string (valid words in the entire string)

//A string str is used for storing word combinations
//Any matched words are appended to str
//Finally, if an empty string is found in the method (indicating that the string has all valid words) then str is added to set for sorted output
static void wordbreak(String word,Set<String> dict,String str)
{
    //Calculate size for verifying 
    int size = word.length();
    
    //If string is empty 
    //i.e a word was found previously 
    //This does not handle cases when input string is empty 
    if(size==0)
    {
        str = str.substring(0,str.length()-1);
        str += ")";
        set.add(str);
        return ;
    }
    
    //Append letters from start of current string, check for words formed
    //If word is formed, recursively check remaining substring after the word for more words
    for(int i=1;i<=size;i++)
    {
        if(dict.contains(word.substring(0,i)))
        {
            //New string passed instead of modifying existing one (for backtracking)
            String newstr = str + word.substring(0,i) + " ";
            wordbreak(word.substring(i),dict,newstr);
        }
    }
}

public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            set = new TreeSet<>();
            int n = Integer.parseInt(br.readLine().trim());
            String[] dictwords = br.readLine().trim().split("\\s+");
            String word = br.readLine().trim();
            Set<String> dict = new HashSet<>();
            for(String s : dictwords)
            {
                dict.add(s);
            }
            wordbreak(word,dict,"(");
            StringBuilder output = new StringBuilder();
            if(set.isEmpty())
            {
                output.append("Empty");
            }
            else
            {
                for(String str : set)
                {
                    output.append(str);
                }
            }
            System.out.println(output);
        }
    }