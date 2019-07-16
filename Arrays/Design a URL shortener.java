class Gfg
{
	public static void main (String[] args) throws IOException
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine().trim());
			while(t-->0)
			{
				long num = Long.parseLong(br.readLine().trim());
				
				//Make temporary copy of number for base conversion
				long tempnum = num;
				String newbase = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
				
				//Object for storing shortened url
				StringBuilder newurl = new StringBuilder();
				
				//Convert base 10 to 62 --
				//Repeatedly divide number by 62 while it's > 0
				//For each remainder, append the character in 'newbase' at given (rem) offset
				while(tempnum > 0)
				{
					int rem = (int)(tempnum % 62);
					newurl.append(newbase.charAt(rem));
					tempnum /= 62;
				}
				
				//Reverse the obtained shortened URL (Remainder are obtained in reverse order)
				newurl = newurl.reverse();
				int length = newurl.length();
				long original = 0;
				long p = 0;
				
				//Convert the shortened URL back to original integer
				//Each character is multiplied by increasing power of 62, starting from right, and added to previously obtained number
				//Index of each character is obtained using 'newbase'
				for(int i=length-1;i>=0;i--)
				{
					char curr = newurl.charAt(i);
					original += (long)(Math.pow(62,p)*newbase.indexOf(curr));
					p++;
				}
				System.out.println(newurl);
				System.out.println(original);
			}
		}
}