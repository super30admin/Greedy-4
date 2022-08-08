# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        mapping = {}
        for i in range(len(source)-1, -1, -1):
            ch = source[i]
            if i == len(source)-1:
                mapping[i] = {}
            else:
                mapping[i] = mapping[i+1].copy()
            mapping[i][ch] = i

        idx = 0
        res = 1
        for ch in target:
            if ch not in mapping[0]:
                return -1
            else:
                if idx == len(source) or ch not in mapping[idx]:
                    idx = 0
                    res += 1

                idx = mapping[idx][ch] + 1

        return res
