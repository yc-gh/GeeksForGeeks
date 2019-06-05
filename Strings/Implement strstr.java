    //Naive solution check each character
    int strstr(String str, String target)
    {
       int strlength = str.length();
       int targetlength = target.length();
       boolean found = false;
       int index = -1;
       for(int i=0;i<strlength;i++)
       {
           if(str.charAt(i)==target.charAt(0))
           {
               int j = 1;
               for(j=1;i+j<strlength && j<targetlength;j++)
               {
                   if(str.charAt(i+j)!=target.charAt(j))
                   {
                       break;
                   }
               }
               if(j==targetlength)
               {
                   index = i;
                   break;
               }
           }
       }
       return index;
    }