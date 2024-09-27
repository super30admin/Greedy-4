//Time - O(mn)
//Space - O(1)
class Solution {
public:
    int shortestWay(string source, string target){
        int s = 0, t = 0, slen = source.size(), tlen = target.size();
        int cnt = 0;
        while(t<tlen){
            int currt = t;
            s = 0;
            while(s<slen){
                if(source[s] == target[t]){
                    t++;
                }
                s++;
            }
            if(currt == t){
                return -1;
            }
            cnt++;
        }
        return cnt;
    }
};
