class Solution {
    ArrayList<Integer> countDistinct(int A[], int n, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        int l=0, r=0;
        while(r<n)
        {
            if(r-l+1 <= k)
            {
                map.put(A[r], map.getOrDefault(A[r],0)+1);
            }
            else
            {
                res.add(map.size());
                if(map.get(A[l])==1) map.remove(A[l]);
                else map.put(A[l],map.get(A[l])-1);
                l++;
                map.put(A[r], map.getOrDefault(A[r],0)+1);
            }
            r++;
        }
        res.add(map.size());
        return res;
        
//         ArrayList<Integer> res = new ArrayList<>();
//         Set<Integer> set = new HashSet<>();
//         for(int i=0;i<n-(k-1);i++)
// 	   {
// 	      set.clear();
// 	      for(int j=0;j<k;j++) set.add(A[i+j]);
// 	      res.add(set.size());
// 	   }
// 	   return res;
    }
}
