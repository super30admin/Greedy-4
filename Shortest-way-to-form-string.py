# Time Complexity : O(MN)
# Space Complexity : O(C)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        i, j = 0, 0
        count = 1
        while j < len(target):
            i = source.find(target[j], i)
            if i == -1:
                i = source.find(target[j])
                if i == -1:
                    return -1
                count += 1
            i += 1
            j += 1
        return count