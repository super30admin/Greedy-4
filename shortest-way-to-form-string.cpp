// Time Complexity: O(slen * tlen) slen = source length tlen = target length
// Space Complexity: O(1)
class Solution {
public:
    int shortestWay(string source, string target) {
        int slen = source.size();
        int tlen = target.size();
        int sp = 0; // source pointer
        int tp = 0; // target pointer
        int res = 0;
        while(tp < tlen) {
            int curr = tp;
            while(tp < tlen && sp < slen) {
                if(source[sp] == target[tp]) {
                    tp++;
                }
                sp++;
            }
            res++;
            sp = 0;
            if(curr == tp) return -1;
        }
        return res;
    }
};
