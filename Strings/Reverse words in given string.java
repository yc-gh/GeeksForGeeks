//Using library method split
public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String[] input = br.readLine().trim().split("\\.");
            int length = input.length;
            StringBuilder output = new StringBuilder();
            output.append(input[length-1]);
            for(int i=length-2;i>=0;i--)
            {
                output.append("."+input[i]);    
            }
            System.out.println(output);
        }
    }