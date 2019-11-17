#time complexity:O(s*t)
#space complexity:O(1)

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        if source == target:
            return 1
        ans = 0
        s_idx = 0
        t_idx = 0
        t = len(target)
        s = len(source)
        #while we have reached the end of the target
        while t_idx < t:
            s_idx = 0
            curr = t_idx
            #start from index o  of the scource and find matching elements of target
            while s_idx < s:
                if t_idx < t and source[s_idx] == target[t_idx]:
                    t_idx += 1
                s_idx += 1
            #this will be true when an element is not present in source and will have to  return -1
            if curr == t_idx:
                return -1
            #else add +1 to the number of times source is required
            ans += 1
        return ans