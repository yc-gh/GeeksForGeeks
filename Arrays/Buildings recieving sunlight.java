class Gfg
{
	public static void main (String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine().trim());
			while(t-->0)
			{
				int n = Integer.parseInt(br.readLine().trim());
				String[] input = br.readLine().trim().split("\\s+");
				
				//Iterate through array
				//Only those buildings will recieve light which have more height than building with max height prior to them
				int maxheight = Integer.parseInt(input[0]);
				int count=1;
				for(int i=1;i<n;i++)
				{
					int currheight = Integer.parseInt(input[i]);
					if(currheight>=maxheight) 
					{
						maxheight=currheight;
						count++;
					}
				}
				System.out.println(count);
			}
		}
}