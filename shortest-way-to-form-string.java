//time complexity O(m x n)
//space complexity O(1)

class Solution {
    public int shortestWay(String source, String target) {
        int s = source.length(); int t = target.length();
        int SP = 0; int TP = 0;
        int result = 0;
        while(TP < t){
            result++; SP = 0;
            int curr = TP;
            while(SP < s && TP < t){
                char sChar = source.charAt(SP);
                char tChar = target.charAt(TP);
                if(sChar == tChar){
                    SP++; TP++;
                } else{
                    SP++;
                }
            }
            if(curr == TP) return -1;
        }
        return result;
    }
}
