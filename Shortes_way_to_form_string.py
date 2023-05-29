# Time Complexity : O(S * T), where S is the length of the source string and T is the length of the target string. 
# Space Complexity : O(1) 
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        def isSubsequence(s: str, t: str) -> bool:
            i = j = 0
            while i < len(s) and j < len(t):
                if s[i] == t[j]:
                    i += 1
                j += 1
            return i == len(s)
        
        count = 0
        t_index = 0
        while t_index < len(target):
            s_index = 0
            while s_index < len(source) and t_index < len(target):
                if source[s_index] == target[t_index]:
                    s_index += 1
                    t_index += 1
                else:
                    s_index += 1
            if t_index < len(target):
                if not isSubsequence(source, target[t_index:]):
                    return -1
                count += 1
        return count