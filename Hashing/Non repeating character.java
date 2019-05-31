    //Store counts of each character in a linked hash map
    //Iterate through map and print first character with count 1
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(br.readLine().trim());
	        char[] chararr = br.readLine().trim().toCharArray();
	        Map<Character,Integer> map = new LinkedHashMap<>();
	        for(int i=0;i<n;i++)
	        {
	            if(!map.containsKey(chararr[i]))
	            {
	                map.put(chararr[i],1);
	            }
	            else
	            {
	                map.put(chararr[i],map.get(chararr[i])+1);
	            }
	        }
	        if(!map.containsValue(1)) System.out.println(-1);
	        else
	        {
	            Iterator<Map.Entry<Character,Integer>> iter = map.entrySet().iterator();
	            while(iter.hasNext())
	            {
	                Map.Entry<Character,Integer> entry = iter.next();
	                if(entry.getValue()==1)
	                {
	                    System.out.println(entry.getKey());
	                    break;
	                }
	            }
	        }
	    }
	 }