# Time Complexity : O(MN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach


class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        if not source or not target:
            return -1
        left = 0
        right = 0
        count = 0
        while left < len(source) and right < len(target):
            count += 1
            current = right
            while left < len(source):
                if source[left] == target[right]:
                    left += 1
                    right += 1
                else:
                    left += 1
            if current == right:
                return -1
            left = 0
        return count
