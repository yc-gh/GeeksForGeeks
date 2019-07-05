//Constant space ~ (check) using a 256 size array to track which characters have been read already

static String remDuplicates(char[] str)
{
    int n = str.length;
    
    char[] chars = new char[256];
    
    //Index to modify existing string 
    int index = 0;
    
    for(int i=0;i<n;i++)
    {
        if(chars[(int)str[i]] == 0)
        {
            chars[(int)str[i]] = 1;
            str[index++] = str[i];
        }
    }
    
    return new String(str,0,c);
}
    
public static void main (String[] args) throws IOException
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while(t-->0)
    {
        char[] str = br.readLine().trim().toCharArray();
        System.out.println(remDuplicates(str));
    }
}