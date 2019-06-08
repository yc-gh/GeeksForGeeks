    public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String n = br.readLine().trim();
	        //Reference words for 0-20
	        String[] numbers = {"","one","two","three","four","five","six","seven","eight","nine",
                "ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen",
                "nineteen"};
            //Reference words for multiples of ten <100
            String[] tens = {"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
            //Reference words for powers of 10
            String[] powers = {"zero","ten","hundred","thousand"};
            //Calculate number of digits
	        int numofdigits = (int)Math.log10(Integer.parseInt(n))+1;
	        //Number of zeroes after leftmost digit (1 - number of digits)
	        int zeroes = numofdigits-1;
	        StringBuilder output = new StringBuilder();
	        int i=0;
	        //Repeatedly get one character starting from left side, till only two digits left 
	        //Convert to word and append power of ten
	        if(numofdigits>2)
	        {
    	        for(i=0;i<numofdigits-2;i++)
    	        {
    	            int curr = Character.getNumericValue(n.charAt(i));
    	            if(curr!=0)
    	            output.append(numbers[curr]+" "+powers[zeroes--]+" ");
    	        }
    	        //Get remaining two digit number, if it's not 0, append and
    	        if(Integer.parseInt(n.substring(i))!=0) output.append("and ");
	        }
	        //Get last two digits (or if number was two digits only)
            int num = Integer.parseInt(n.substring(i));
            //If number is less than 20, print it's word 
            if(num<20) output.append(numbers[num]+" ");
            //Else split it into two digits 
            //If units place is 0 ie. number is multiple of 10 then don't append anything for unit's place
            else
            {
                int tensplace = Integer.parseInt(n.substring(i,i+1));
                int units = Integer.parseInt(n.substring(i+1,i+2));
                output.append(tens[tensplace]+" ");
                if(units!=0) output.append(numbers[units]);
            }
	        System.out.println(output);
	    }
	 }