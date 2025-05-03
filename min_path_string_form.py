# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        res = -1

        source_set = set(source)

        j = 0 # source pointer
        i = 0 # target pointer
        
        count = 0
        while i < len(target):
            if target[i] not in source_set:
                return -1
            if source[j] == target[i]:
                j += 1
                i += 1
                if i == len(target):
                    return count+1
            else:
                j += 1
            
            if j == len(source):
                count += 1
                j = 0