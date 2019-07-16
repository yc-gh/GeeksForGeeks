class LRUCache {
    
    Map<Integer,Integer> map;
    Deque<Integer> queue;
     int capacity;
     /*Inititalize an LRU cache with size N */
     public LRUCache(int N) {
        this.map = new HashMap<>();
        this.capacity = N;
        this.queue = new LinkedList<>();
     }
     
     /*
     Returns value from map if it contains x else returns 1
     If map contains the key (hit), the key is removed from queue and added to front
      */
     public int get(int x) {
        if(!map.containsKey(x))
        {   
         return -1;
        }
        else
        {
            int value = map.get(x);
            queue.remove(x);
            queue.offer(x);
            return value;
        }
     }
     
     /*
     When a value is to be set, if it is already in cache (i.e in map)
     Update the mapping, remove from queue and add to front.
     If value doesn't exist and cache capacity has been reached, remove last key of queue
     and add new key to map and queue
     Else if value doesn't exist and capacity hasn't been reached, add key to map and queue
     */
     public void set(int x, int y) {
        if(map.containsKey(x))
        {
            map.put(x,y);
            queue.remove(x);
            queue.offer(x);
        }
        else
        {
            if(map.size() == capacity)
            {
                map.remove(queue.poll());
                map.put(x,y);
                queue.offer(x);
            }
            else
            {
                map.put(x,y);
                queue.offer(x);
            }
        }
     }
 }
 