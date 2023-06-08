//Space -> O(1)
//Time -> O(n log m)
class Solution{
  public int shortestString(String source, String target){
    int m = source.length(); 
    int n = target.length(); 
    int sp = 0; 
    int tp = 0; 
    int count = 1;
    if(source == null || target == null)
      return -1;
    HashSet<Character> set = new HashSet<>();
    for(int i = 0; i < m; i++){
      char c = source.charAt(i);
      set.add(c);
    }
    while(tp < n){
      char s = source.charAt(sp);
      char t = target.charAt(tp);
      if(!set.contains(t)){
        return - 1;
      }
      if(s == t){
        sp++;
        tp++;
        if(tp == n){
          return count;
        }
      }
      else{
        sp++;
      }
      if(sp == m){
        sp = 0; 
        count++;
      }
    }
    return 99;      
  }
}
