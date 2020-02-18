TC: O(n)
SC: O(1)


Runtime: 2 ms, faster than 85.60% of Java online submissions for Shortest Way to Form String.
Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for Shortest Way to Form String.



  
  class Solution {
    
    int shortestWay (String source, String target) {
     
        int sp= 0;
        int tp = 0;
    
        int TL = target.length();
        int SL = source.length();
        int count=0;
        
        while(tp< TL ){
            sp =0;
            int curr = tp;
                
                while(sp< SL){
                    if(tp< TL && source.charAt(sp) == target.charAt(tp)){ 
                        tp++;
                    }
                    sp++;
                }
            count++;
            if(curr == tp) return -1;
            }
            
    return count;
        
    }
};
