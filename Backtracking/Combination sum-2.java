//Similar to other combination sum
//(1) in each recursive method call, the arrayindex must be preincremented so that it doesn't start with the same index
//(2) Output must be unique strings, so a set is used

static Set<String> output = new TreeSet<>();

//In order to find all valid combinations
//Take one digit, combine it with other digits till the sum reaches 0 (reduce sum for each appended digit)
//Then backtrack (remove this digit) and redo for other digits
//Perform recursively for all digits with the new list of digits
static void combine(Integer[] a,int n,int sum,List<Integer> currnum,int arrindex)
{
    //If sum of digits in list becomes greater, return
    if(sum < 0)
    {
        return;
    }
    
    //If sum of digits matches, print list
    if(sum == 0)
    {
        String str = "";
        for(int i : currnum)
        {
            str += i + " ";
        }
        str = "(" + str.substring(0,str.length()-1) + ")";
        output.add(str);
        return;
    }
    //For each digit in the given array, append it to current list and recurse while checking the sum
    while(arrindex<a.length && sum-a[arrindex]>=0)
    {
        //Append a digit to the list
        currnum.add(a[arrindex]);
        
        //Check combinations of all digits with new list
        combine(a,n,sum-a[arrindex],currnum,++arrindex);
        
        //Remove the digit so that next combinations starting with next digit can be checked
        currnum.remove(currnum.size()-1);
    }
}

public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            //Reset StringBuilder instance for each test case
            output = new TreeSet<>();
            int n = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split("\\s+");
            Integer[] a = new Integer[n];
            //Input array
            for(int i=0;i<n;i++)
            {
                a[i] = Integer.parseInt(input[i]);
            }
            //Sort the array
            Arrays.sort(a);
            
            int sum = Integer.parseInt(br.readLine().trim());
            
            //Find all combinations whose sum is B (sum)
            //Set is not used since multiple occurences of same digit are allowed as per the array
            combine(a,n,sum,new ArrayList<>(),0);
            
            //If no combination found, print Empty
            if(output.isEmpty())
            {
                System.out.println("Empty");
            }
            else
            {
                StringBuilder sb = new StringBuilder();
                for(String str : output)
                {
                    sb.append(str);
                }
                System.out.println(sb);
            }
        }
    }