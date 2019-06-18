    //Approach -- 
    //Total petrol provided by pumps has to be > total distance to be covered in order to complete a tour
    //For each pump visited, add the petrol to petrol available in the truck
    //If the available petrol becomes negative, this amount is deficit and must be covered by any subsequent pumps in order to cover these pumps
    //Add this amount to deficit petrol, reset petrol available to 0
    //Also, since the available petrol reached zero from the assumed starting position, new starting position is set as next pump (no pump in b/w can provide complete tour)
    //Repeat till end of array (all pumps), check if total petrol_available + deficit > 0 (tour possible with starting point) else not possible
    int tour(int petrol[], int distance[])
    {
        int n = petrol.length;
        int petrol_available = 0;
        int petrol_deficit = 0;
        int start = 0;
        for(int i=0;i<n;i++)
        {
            //If petrol from the pump 
            petrol_available += petrol[i] - distance[i];
            
            //If petrol ran out
            if(petrol_available < 0)
            {
                //Add this to deficit petrol
                //This much petrol must be covered by subsequent pumps
                petrol_deficit += petrol_available;
                //Set next as starting point
                start = i+1;
                //Reset petrol available
                petrol_available = 0;
            }
        }
        return (petrol_available+petrol_deficit >= 0 ? start : -1);
    }