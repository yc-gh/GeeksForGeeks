    //Inefficient sol. -> Add all elements to priority queue and pop all
    //More efficient sol. -> Create an array currpos that tracks the indexes last offered element in each array
    //When an element is popped from the priority queue, check which array it belonged to and push the next element of the array unless last element was reached
    //Using this approach can be slightly faster since the tree will always have only k elements at any time
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
        {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            ArrayList<Integer> list = new ArrayList<>();
            int[] currpos = new int[k];
            for(int i=0;i<k;i++)
            {
                pq.offer(arrays[i][0]);
            }
            
            while(!pq.isEmpty())
            {
                int min = pq.peek();
                list.add(pq.poll());   
                for(int i=0;i<k;i++)
                {
                    if(min == arrays[i][currpos[i]])
                    {
                        if(currpos[i]<k-1)
                        {
                            currpos[i]++;
                            pq.offer(arrays[i][currpos[i]]);
                            break;
                        }
                    }
                }
            }
            return list;
        }