# Time complexity - O(s * t)
# Space complexity - O(1)

# Approach - Two pointers - keep moving the s and t pointers as long as s[i] == t[i], else only move s 
# pointer. When s pointer goes out-of-bounds, reset it and increase the resulting count by 1.

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        src_char = set()
        for s in source:
            src_char.add(s)
        
        res = 0
        si = 0
        ti = 0
        while ti < len(target):
            print(si, ti, source[si], target[ti], res)
            if target[ti] not in src_char:
                return -1            
            if target[ti] == source[si]:
                ti += 1
                si += 1
            else:
                si += 1
            if si == len(source) or ti == len(target):
                si = 0
                res += 1
        return res