class MinimumPathFormStringFormation {
    
    // Time Complexity: O(nm)   (where n -> len(source) and m -> len(target))
    // Space Complexity: O(1)
    
    public int shortestWay(String source, String target){
        int s = source.length();
        int t = target.length();
        
        int tp = 0;
        int sp = 0;
        
        int result = 0;
        
        while(tp < t){
            sp = 0;
            int prev = tp;
            while(sp < s && tp < t){
                if(source.charAt(sp) == target.charAt(tp))
                    tp++;
                sp++;
            }
            if(prev != tp)
                result++;
            else
                return -1;
        }
        return result;
    }
}