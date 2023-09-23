# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def minDominoRotations(self, tops, bottoms):
        """
        :type tops: List[int]
        :type bottoms: List[int]
        :rtype: int
        """
        for num in range(1, 7):
            if all(num in pair for pair in zip(tops, bottoms)):
                return (len(tops) - (max(tops.count(num), bottoms.count(num))))
        return -1