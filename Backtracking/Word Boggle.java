//2 Approaches -- DFS and Trie

//(1) Using DFS

static Set<String> set = new TreeSet<>();
    
//Check if the string matches word in dictionary
static boolean isWord(Set<String> dict,String str)
{
    if(dict.contains(str)) return true;
    return false;
}

//Utility method to check whether the next character to be included in the word
//Is within bounds and hasn't been visited in current traversal
static boolean isSafe(int r,int c,int n,int m,boolean[][] visited)
{
    return (r>=0) && (r<n) && (c>=0) && (c<m) && (visited[r][c]==false);
}

static void searchWords(char[][] boggle,int r,int c,Set<String> dict,boolean[][] visited,String str,int maxlen)
{
    //Append current cell character to previous string 
    str += boggle[r][c];
    
    //If word length exceeds max length word in dictionary, don't check any further
    if(str.length()>maxlen) return;
    
    //Check if current set of letters matches word
    if(isWord(dict,str)) set.add(str);
    
    //Utility indexes for adjacent cells
    int[] rowNums = {-1,-1,-1,0,0,1,1,1};
    int[] colNums = {-1,0,1,-1,1,-1,0,1};
    
    //Set visited true so that the current word check doesn't check it again
    visited[r][c] = true;
    
    for(int i=0;i<8;i++)
    {
        //Adjacent cell indexes
        int adjX = r + rowNums[i];
        int adjY = c + colNums[i];
        
        //Check if these adjacent cells are safe to go to (within bounds and not visited)
        if(isSafe(adjX,adjY,boggle.length,boggle[0].length,visited))
        {
            //Continue DFS with next character
            searchWords(boggle,adjX,adjY,dict,visited,str,maxlen);
        }
    }

    //Reset it's visited in so that other words forming from the same char can be checked
    visited[r][c] = false;
}

//Search words starting with a blank (or starting characters) of the given matrix
static void findWords(char[][] boggle,int n,int m,Set<String> dict,int maxlen)
{
    boolean[][] visited = new boolean[n][m];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            searchWords(boggle,i,j,dict,visited,"",maxlen);
        }
    }
    
}

public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            //Reset set for each test case
            set = new TreeSet<>();
            
            int x = Integer.parseInt(br.readLine().trim());
            String[] inputdict = br.readLine().trim().split("\\s+");
            String[] inputbounds = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inputbounds[0]);
            int m = Integer.parseInt(inputbounds[1]);
            String[] inputmat = br.readLine().trim().split("\\s+");
            char[][] boggle = new char[n][m];
            
            //Store dictionary as a hashset
            //And also store length of maximum length word
            //So that DFS can be stopped when this length is exceeded
            int maxwordlen = 0;
            Set<String> dict = new HashSet<>();
            for(String str : inputdict)
            {
                int strlen = str.length();
                if(strlen > maxwordlen) maxwordlen = strlen;
                dict.add(str);
            }
            
            //Fill the board from input
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    boggle[i][j] = inputmat[i*m+j].charAt(0);
                }
            }
            
            //Find words
            findWords(boggle,n,m,dict,maxwordlen);
            
            if(set.isEmpty())
            {
                System.out.println(-1);
                continue;
            }
            
            StringBuilder output = new StringBuilder();
            for(String str : set)
            {
                output.append(str+" ");
            }
            System.out.println(output);
        }
    }

//(2) Using Trie

static final int SIZE = 26;
//Automatically put in constructor by compiler
//Used to store matched words in sorted order
static Set<String> set = new TreeSet<>();

//WARNING -- the Trie is made to handle upper case words as was indicated in the problem statement
//However, the test cases contain lower case words as well therefore the input is converted to upper case words
//TrieNode class
//Each instance consists of an array of objects
//And a variable isEndOfWord indicating that a word ends at current character
static class TrieNode
{
    TrieNode[] child;
    boolean isEndOfWord;
    TrieNode()
    {
        isEndOfWord = false;
        child = new TrieNode[SIZE];
        for(int i=0;i<SIZE;i++)
        {
            child[i] = null;
        }
    }
}

//Insertion into Trie
//Given a string, using it's length,
//Create a new object whose reference is stored the previous character's array 
//This way a linked list is made for each word
static void insertTrie(TrieNode root,String key)
{
    int level = 0;
    int length = key.length();
    TrieNode curr = root;
    for(level=0;level<length;level++)
    {
        int index = key.charAt(level) - 'A';
        if(curr.child[index]==null)
        {
            curr.child[index] = new TrieNode();
        }
        curr = curr.child[index];
    }
    curr.isEndOfWord = true;
}

//Utility method to check whether the next character to be included in the word
//Is within bounds and hasn't been visited in current traversal
static boolean isSafe(int r,int c,int n,int m,boolean[][] visited)
{
    return (r>=0) && (r<n) && (c>=0) && (c<m) && (visited[r][c]==false);
}

//Method to search for words starting with the character str (from findWords)
//If the current node of Trie has reached a node indicating end of word, then this word is included in found words
//Set current character as visited and recursively visit all it's adjacent safe characters that match Trie character at current index of word in Trie
//Once the inner adjacent characters are all traversed, set current character as unvisited for next iteration
static void searchWords(char[][] boggle,int r,int c,TrieNode root,boolean[][] visited,String str)
{
    //If current root of Trie is a leaf, print the word till here
    //But continue checking for more words with these letters
    if(root.isEndOfWord==true) set.add(str);
    
    //Utility indexes for adjacent cells
    int[] rowNums = {-1,-1,-1,0,0,1,1,1};
    int[] colNums = {-1,0,1,-1,1,-1,0,1};

    //Set visited true so that the current word check doesn't check it again
    visited[r][c] = true;
    
    for(int i=0;i<8;i++)
    {
        //Adjacent cell indexes
        int adjRow = r + rowNums[i];
        int adjCol = c + colNums[i];
        
        //Check if these adjacent cells are safe to go to (within bounds and not visited)
        if(isSafe(adjRow,adjCol,boggle.length,boggle[0].length,visited))
        {
            //Get the index of adjacent cell's character (for checking in the Trie)
            int adjcharindex = boggle[r+rowNums[i]][c+colNums[i]] - 'A';
            //If the trie contains character for the current index
            if(root.child[adjcharindex]!=null)
            {
                //Include current letter into previously formed word and check for complete word and more words
                searchWords(boggle,adjX,adjY,root.child[adjcharindex],visited,str+(char)(adjcharindex+'A'));
            }
        }
    }

    //Reset it's visited in so that other words forming from the same char can be checked
    visited[r][c] = false;
}

//Search words starting with each character of the given matrix
static void findWords(char[][] boggle,int n,int m,TrieNode root)
{
    boolean[][] visited = new boolean[n][m];
    TrieNode curr = root;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            char currchar = boggle[i][j];
            if(root.child[currchar-'A']!=null)
            {
                String str = "" + currchar;
                searchWords(boggle,i,j,root.child[currchar-'A'],visited,str);
            }
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
            int x = Integer.parseInt(br.readLine().trim());
            String[] inputdict = br.readLine().trim().split("\\s+");
            String[] dict = new String[x];
            
            //Input dictionary words in upper case for Trie matching
            for(int i=0;i<x;i++)
            {
                dict[i] = inputdict[i].toUpperCase();
            }
            
            String[] inputbounds = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inputbounds[0]);
            int m = Integer.parseInt(inputbounds[1]);
            String[] inputmat = br.readLine().trim().split("\\s+");
            char[][] boggle = new char[n][m];
            TrieNode root = new TrieNode();
            
            //Fill the board from input
            //The input is converted to upper case for the Trie
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    boggle[i][j] = Character.toUpperCase(inputmat[i*m+j].charAt(0));
                }
            }
            
            //Insert all words into trie
            for(int i=0;i<x;i++)
            {
                insertTrie(root,dict[i]);
            }
            
            //Find words
            findWords(boggle,n,m,root);
            
            //If no words were found
            if(set.isEmpty())
            {
                System.out.println(-1);
                continue;
            }
            
            //Else if words are found
            StringBuilder output = new StringBuilder();
            
            //If input words where in lowercase 
            //Convert output to lowercase
            if(!Character.isUpperCase(inputdict[0].charAt(0)))
            {
                for(String str : set)
                {
                    output.append(str.toLowerCase()+" ");
                }
            }
            //Else don't
            else
            {
                for(String str : set)
                {
                    output.append(str+" ");
                }
            }
            System.out.println(output);
        }
    }