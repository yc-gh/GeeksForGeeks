int maxLen(int arr[], int n)
{
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int length = 0;
    int sum = 0;
    for(int i=0; i<n; i++)
    {
        sum += arr[i];
        
        //If sum reaches 0 then length of subarray is 0->i
        if(sum == 0)
        {
            //Length will be final index - initial index + 1
            length = i + 1;
        }
        
        //If this sum has been obtained at a previous index, elements after that index have 0 sum
        if(map.containsKey(sum))
        {
            //Get number of elements after prev index as temp length
            int templength = i - map.get(sum);
            length = Math.max(length,templength);
        }
        //Else hash this sum
        else
        {
            map.put(sum, i);    
        }   
    }   
    return length;
}