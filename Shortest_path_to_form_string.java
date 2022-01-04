class Soluion{
  public int shortestWay(String source, String target){
      int sl = source.length();
      int tl = target.length();
      HashMap<Character, List<Integer>> map = new HashMap<>();
      
     for(int i = 0; i < sl; i++){
        char c = source.charAt(i);
        if(!map.containsKey(c)){
            map.put(c, new ArrayList<>());
        }
       map.get(c).add(i);
     }
    
    int result = 1;
    int i = 0;
    int pos = 0;
    
    while(i < tl){
        char c = target.charAt(i);
        if(!map.containsKey(c)) return -1;
        
        List<Integer> li = map.get(c);
        int k = Collections.binarySearch(li, pos);
        if(k < 0) k = -k - 1;
        if(k == li.size()) {
            result++;
            pos = 0;
        }else{
            pos = li.get(k)+1;
            i++;
        }
//         if(li.get(li.size() - 1) < pos){
//             pos = 0;
//             result++;
//         }else{
//             int bsIndex = binarySearch(li, 0, li.size() - 1, pos);
//             pos = bsIndex+1;
//             i++;
//         }
    }
    return result;
  }
  
//   private int binarySearch(List<Integer> li, int low, int high, int target){
//       while(low <= high){
//           int mid = low + (high - low) / 2;
//           if(li.get(mid) == target) return target;
//           else if(li.get(mid) > target){
//               high = mid -1 ;
//           }else{
//               low = mid + 1;
//           }
//       }
//     return high;
//   }
// }
}

//TC: m log n
