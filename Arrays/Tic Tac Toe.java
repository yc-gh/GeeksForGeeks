static String check(char[][] a)
    {
        boolean xwins = false;
        boolean owins = false;
        int rows = a.length;
        int cols = a[0].length;
        //Check rows    
        for(int i=0;i<rows;i++)
        {
            if(a[i][0]==a[i][1] && a[i][0]==a[i][2])
            {
                if(a[i][0]=='X') xwins = true;
                else owins = true;
            }
        }
        
        //Check if both win 
        if(xwins==true && owins==true) return "Invalid";
        
        //Check cols
        for(int j=0;j<cols;j++)
        {
            if(a[0][j]==a[1][j] && a[0][j]==a[2][j])
            {
                if(a[0][j]=='X') xwins = true;
                else owins = true;
            }
        }
        if(xwins==true && owins==true) return "Invalid";
        
        //Check left to right diagonal
        if(a[0][0]==a[1][1] && a[0][0]==a[2][2])
        {
            if(a[0][0]=='X') xwins = true;
            else owins = true;
        }
        if(xwins==true && owins==true) return "Invalid";
        
        //Check right to left diagonal
        if(a[0][2]==a[1][1] && a[0][2]==a[2][0])
        {
            if(a[0][2]=='X') xwins = true;
            else owins = true;
        }
        if(xwins==true && owins==true) return "Invalid";
        else if(xwins==true) return "xwins";
        else if(owins==true) return "owins";
        else return "Valid";
    }
    
    //On a fully filled board, following cases can occur
    //If X count > 5 or O count > 4 , board is invalid
    //If both X and Y win, board is invalid
    //If X wins, board is valid
    //If Y wins, the board cannot be fully filled since only one grid cell will be left which should not be filled ie. X count == O count
    //Else board is invalid
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-->0)
	    {
	        String[] input = br.readLine().trim().split("\\s+"); 
	        char[][] a = new char[3][3];
	        int k = 0;
	        int xcount = 0;
	        int ocount = 0;
            
            //Read input into a 2d char array
	        for(int i=0;i<3;i++)
	        {
	            for(int j=0;j<3;j++)
	            {
	                char curr = input[k++].charAt(0);
	                a[i][j] = curr;
	                if(curr == 'X') xcount++;
	                else ocount++;
	            }
	        }
            
            //Total X's should be 5 and O's should be 4
	        //If either is more than this, board is invalid
	        if(xcount>5 || ocount>4)
	        {
	            System.out.println("Invalid");
	        }
	        //Else check the board
	        else
	        {
	            //Method called for checking the board
	            //Method returns Invalid/xwins/owins/Valid
	            String result = check(a);
	            if(result.equals("Invalid"))
	            {
	                System.out.println("Invalid");
	            }
	            //If O wins, the board cannot have more X's than O's
	            else if(result.equals("owins") && xcount>ocount) 
	            {
	                System.out.println("Invalid");
	            }
	            //Else it's valid 
	            else System.out.println("Valid");
	        }
	    }
	 }