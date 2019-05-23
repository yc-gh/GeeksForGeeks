public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
		    BigInteger n = new BigInteger(br.readLine().trim());
		    BigInteger rem = n.remainder(new BigInteger("10"));
		    if(rem.compareTo(new BigInteger("5"))>0)
		    {
		        BigInteger ten = new BigInteger("10");
		        System.out.println(n.add(ten.subtract(rem)));
		    }
		    else
		    {
		        System.out.println(n.subtract(rem));
		    }
		}
	}