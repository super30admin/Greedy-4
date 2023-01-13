class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        if tops is None or len(tops) == 0:
            return 0
        result = self.check(tops, bottoms, tops[0])
        if result != -1:
            return result
        return self.check(tops, bottoms, bottoms[0])

    def check(self, tops, bottom, target):
        topR = 0
        bottomR = 0

        for i in range(len(tops)):
            if target != tops[i] and target != bottom[i]:
                return -1

            if target != tops[i]:
                topR += 1

            if target != bottom[i]:
                bottomR += 1
        print(topR, bottomR)
        return min(topR, bottomR)

# Greedy
# Time Complexity :O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No