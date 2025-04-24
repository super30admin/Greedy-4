# https://leetcode.com/problems/shortest-way-to-form-string/

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        hs = set()
        sl = len(source)
        tl = len(target)

        for i in range(sl):
            hs.add(source[sl])
        
        count = 1
        sp = 0 
        tp = 0
        while tp < tl:
            if target[tp] not in hs:
                return -1

            if source[sp] == target[tp]:
                sp += 1
                tp += 1
                if tp == tl:
                    return count
            else:
                sp += 1
            
            if sp == sl:
                sp = 0
                count += 1
        return count

# TC: O(mn)
# SC: O(m)