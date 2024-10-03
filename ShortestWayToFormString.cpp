// Time Compelxity - O(m*n)
// Space Comlexity - O(1)
class Solution {
public:
    int shortestWay(string source, string target) {
        int s_ptr = 0;
        int t_ptr = 0;
        int sSize = source.size();
        int tSize = target.size();
        int answer = 0;
        
        while(t_ptr < tSize){
            int pos = t_ptr;
            while(s_ptr < sSize){
                if(source[s_ptr] == target[t_ptr]){
                t_ptr++;
                s_ptr++;
                }
                if(source[s_ptr] != target[t_ptr])
                    s_ptr++;
            }
            if(pos == t_ptr)
                return -1;
            s_ptr = 0;
            answer++;
        }
        return answer;
    }
};