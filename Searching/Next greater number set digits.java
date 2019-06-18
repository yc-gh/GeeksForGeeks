    //Theory --
    //If digits are sorted in descending order, no greater number exists
    //If digits are sorted in ascending order, swap last two digits
    //Any other case, find next greater number using - 
    //Traverse in reverse from right side till a smaller digit D is found
    //Swap D with minimum greater digit in the subarray to it's right
    //Sort the subarray to right of D 
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        //Deal with the number as a character array rather than integer array
	        //Or convert to integer array if parsing is necessary
	        String n = br.readLine().trim();
			
			//Number of digits
	        int numofdigits = n.length();
			
			//Character array of given number
	        char[] digits = n.toCharArray();
			
			//Flag to check if bigger number is found
	        boolean found = false;
			
			//Starting from second last index, compare each digit to it's right
	        for(int i=numofdigits-2;i>=0;i--)
	        {
	            //If smaller digit found
	            if(digits[i]<digits[i+1])
	            {
	                //Save the next digit's index for swapping
                    int smallest = i+1;
                    //Check right subarray for min greater element
                    for(int j=i+1;j<numofdigits;j++)
                    {
                        if(digits[j]<digits[smallest] && digits[j]>digits[i])
                            smallest = j;
                    }
                    //Swap
                    char temp = digits[i];
                    digits[i] = digits[smallest];
                    digits[smallest] = temp;
                    //Set flag indicating greater number is found
                    found = true;
                    //Sort the right subarray (Library sort method uses Dual Pivot Quicksort nlogn)
                    Arrays.sort(digits,i+1,numofdigits);
                    break;
	            }
			}
			
	        if(found) System.out.println(digits);
	        else System.out.println("not possible");
	    }
	 }