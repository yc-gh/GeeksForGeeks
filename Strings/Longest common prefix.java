// Find minimum length string from all strings
// Prefix checking will be done till length of this string
static int findMinLength(String arr[], int n)  
{ 
    int min = arr[0].length(); 

    for (int i = 1; i < n; i++)  
    { 
        if (arr[i].length() < min) 
        { 
            min = arr[i].length(); 
        } 
    } 

    return (min); 
} 

// For each index from 0 to minimum string length -1 
// Check the character at this index in each string
static String commonPrefix(String arr[], int n) 
{ 
    // Find minimum length string
    int minlen = findMinLength(arr, n); 

    String result = "";

    for (int i = 0; i < minlen; i++) 
    { 
        // Character from first string 
        // This character is checked in all strings
        char current = arr[0].charAt(i); 

        for (int j = 1; j < n; j++)  
        { 
            // If current index character of other string doesn't match
            // then return -1 if result is empty, else return result
            if (arr[j].charAt(i) != current)  
            { 
                return (result.length()==0 ? "-1" : result); 
            } 
        } 

        // Append to result 
        result += (current); 
    } 
    
    return result; 
} 
    
public static void main (String[] args) throws IOException
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while(t-->0)
    {
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr = br.readLine().trim().split("\\s+");
        System.out.println(commonPrefix(arr, n));
    }
}