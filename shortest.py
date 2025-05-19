
# TC: O(n * m) - Worst case iterating through `source` multiple times.
# SC: O(1) - Constant space used.


class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        s_len, t_len = len(source), len(target)
        ans,t_reader = 0,0
        
        while t_reader < t_len:
            s_reader = 0
            flag = False
            while s_len > s_reader and t_len > t_reader:
                if source[s_reader] == target[t_reader]:
                    t_reader += 1
                    flag = True
                s_reader += 1
            if not flag:
                return -1
            ans += 1
        return ans