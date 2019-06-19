static StringBuilder output = new StringBuilder();

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
        output.append(str);
        return;
    }
    //For each digit in the given array, append it to current list and recurse while checking the sum
    while(arrindex<a.length && sum-a[arrindex]>=0)
    {
        //Append a digit to the list
        currnum.add(a[arrindex]);
        
        //Check combinations of all digits with new list
        combine(a,n,sum-a[arrindex],currnum,arrindex++);
        
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
            output = new StringBuilder();
            int n = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split("\\s+");
            
            //Remove duplicates and sort the input array
            Set<Integer> set = new TreeSet<>();
            for(int i=0;i<n;i++)
            {
                set.add(Integer.parseInt(input[i]));
            }
            //Convert set to array
            Integer[] a = set.toArray(new Integer[0]);
            int sum = Integer.parseInt(br.readLine().trim());
            
            //Find all combinations whose sum is B (sum)
            combine(a,n,sum,new ArrayList<>(),0);
            
            //If no combination found, print Empty
            if(output.length()==0)
            {
                output.append("Empty");
            }
            System.out.println(output);
        }
    }