// NON RECURSIVE APPROACH -- 
//Create a new resultant string
// from the original string, take any characters that don't match previous and next adjacent chars
// and append to resultant string
// Redo this process with the resultant string
// Each time after doing the process, check if string length is same as previous string length
// If no, redo / If yes, then no more duplicates were found

//Repeatedly run removal method while new string length is unequal to previous string length
//If new string length becomes equal to previous, then no further removals can be done
public static String removeAdjDupes(String str) 
{
        int n = str.length();
        String s = removeAdjDupesUtil(str);
        while(s.length() != n) {
            n = s.length();
            s = removeAdjDupesUtil(s);
        }
        return s;
}

public static String removeAdjDupesUtil(String str) {
    
    int n = str.length();
    
    //If string length is <= 1 then no removals can be done
    if(n <= 1) {
        return str;
    }
    
    //Create a new string
    StringBuilder result = new StringBuilder("");
    
    //Check each character with previous and next characters
    //Except first and last characters -- check only next and previous chars respectively
    
    //Get first character
    if(str.charAt(0) != str.charAt(1)) {
        result.append(str.charAt(0));
    }
    
    int j = 1;
    
    //Middle characters
    while(j<n-1) 
    {
        char ch = str.charAt(j);
        if(ch != str.charAt(j-1) && ch!= str.charAt(j+1))
        {
            result.append(ch);
        }
        j++;
    }
    
    //Last character
    if(str.charAt(j) != str.charAt(j-1))
    {
        result.append(str.charAt(j));
    }
    
    return result.toString();
}

public static void main (String[] args) 
{
    Scanner sc=new Scanner(System.in);
    int t=Integer.parseInt(sc.next());
    while(t-->0)
    {
        String str = sc.next();
        System.out.println(removeAdjDupes(str));
    }
}