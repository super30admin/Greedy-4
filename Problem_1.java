// Time complexity - O(mn)
// Space complexity - O(1)

class Solution {
    public int shortestWay(String source, String target) {
        int s = source.length();
        int t = target.length();
        int tp = 0;
        int sp = 0;
        int count = 0;
        while(tp < t){
            int curr = tp;
            sp = 0;
            count++;
            while(tp < t && sp < s){
                if(source.charAt(sp) == target.charAt(tp)){
                    tp++;
                }
                sp++;
            }
            
            if(curr == tp){
                return -1;
            }
        }
        return count;
    }
}
