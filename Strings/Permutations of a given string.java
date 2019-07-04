static Set<String> set;

static String swap(String a, int i, int j) 
{ 
    char temp; 
    char[] charArray = a.toCharArray(); 
    temp = charArray[i] ; 
    charArray[i] = charArray[j]; 
    charArray[j] = temp; 
    return String.valueOf(charArray); 
} 

static void permute(String str, int l, int r) 
{ 
    if (l == r) 
        set.add(str); 
    else
    { 
        for (int i = l; i <= r; i++) 
        { 
            str = swap(str,l,i); 
            permute(str, l+1, r); 
            str = swap(str,l,i); 
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
            String s = br.readLine().trim();
            permute(s,0,s.length()-1);
            StringBuilder output = new StringBuilder();
            for(String str : set)
            {
                output.append(str+" ");
            }
            System.out.println(output);
        }
    }