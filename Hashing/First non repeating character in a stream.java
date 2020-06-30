//An alternate efficient approach is to make a static class for characters with their count and first index
//Keep an array for all objects corresponding to each character [26]
//Iterate through given stream storing all counts and first indices
//Iterate through character array and get character with count 1 and least index

// O(n) approach with hashmap and DLL
class GFG
{
    static class Node
    {
        char ch;
        Node next, prev;
        Node(char c) 
        {
            ch = c;
        }
    }
    
    static Node head, tail;
    
	public static void main (String[] args) throws IOException
     {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim()); 
            String[] input = br.readLine().trim().split("\\s+");
            Map<Character, Node> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            
            head=new Node('0');
            tail = new Node('0');
            head.next = tail;
            tail.prev = head;
            
            for(String s : input)
            {
                char ch = s.charAt(0);
                
                if(!map.containsKey(ch))
                {
                    Node newNode = new Node(ch);
                    addNode(newNode);
                    map.put(ch, newNode);
                }
                else
                {
                    Node node = map.get(ch);
                    if(node!=null) 
                    {
                        removeNode(node);
                        map.put(ch, null);
                    }
                }
                
                if(head.next == tail) sb.append("-1 ");
                else sb.append(head.next.ch).append(" ");
            }
            
            System.out.println(sb.toString().trim());
            
        }
     }
     
    private static void addNode(Node node)
    {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
    
    private static void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

//Keep adding non repeated characters to a list
//And keep track of repeated characters using a boolean array
//Remove element from list if it is repeated
//Print first element from list
public static void main (String[] args) throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine().trim());
	while(t-->0)
	{
		int n = Integer.parseInt(br.readLine().trim());
		String[] input = br.readLine().trim().split("\\s+");
		
		//ArrayList or LinkedList any will do
		List<Character> list = new ArrayList<>();
		
		//Keep boolean array for tracking whether any character has been repeated
		//char = 1 byte = 8 bits = 256 possible characters
		boolean[] repeated = new boolean[256];
		StringBuilder output = new StringBuilder();
		for(String str : input)
		{
			char curr = str.charAt(0);
			
			//If character is not repeated
			//If it is not in the list, add it
			//Else remove it and set it's repeated true
			//If character is repeated, nothing is done about it
			if(!repeated[curr])
			{
				if(!list.contains(curr))
				{
					list.add(curr);
				}
				else
				{
					//Typecast to Character or else compiler will try to get the numeric value of char
					list.remove((Character)curr);
					repeated[curr]=true;
				}
			}
			
			//If list is empty ie. no elements added or all removed because of repetition
			//Print -1
			if(list.isEmpty()) output.append("-1 ");
			//Else print the first non repeated character
			else output.append(list.get(0)+" ");
		}
		System.out.println(output);
	}
}
