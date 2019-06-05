    //Split string around 0, count length of each string
    public int count(String s)
    {
        String[] strs = s.split("0");
        int maxlength = 0;
        for(String str : strs)
        {
            int length = str.length();
            if(length > maxlength) maxlength = length;
        }
        return maxlength;
    }