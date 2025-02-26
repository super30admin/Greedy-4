# Time complexity - O(t * log(s))
# Space complexity - O(1)

# Approach - Optimised - Maintain a map for the chars in source and list of their indices. Go through the 
# target string and for every char, find the index of that char (k) which is not greater than or equal to 
# the s pointer in the map using binary search. Increement t pointer by 1 and s pointer to list[k] + 1.

import bisect
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        srcMap = {}
        for i in range(len(source)):
            if source[i] not in srcMap:
                srcMap[source[i]] = []
            srcMap[source[i]].append(i)
        
        si = 0
        ti = 0
        res = 1
        while ti < len(target):
            # print(si, source[si], ti, target[ti], res)
            ch = target[ti]
            if ch not in srcMap:
                return -1
            k = bisect.bisect_left(srcMap[ch], si)
            if k == len(srcMap[ch]): # or ti == len(target):
                res += 1
                si = 0
            else:
                si = srcMap[ch][k] + 1
                ti += 1
        return res