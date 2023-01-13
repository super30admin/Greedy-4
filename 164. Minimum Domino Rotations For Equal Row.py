class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        if tops is None or len(tops) == 0:
            return 0
        hashMap = dict()
        n = len(tops)
        target = -1
        for i in range(n):
            top = tops[i]
            count = hashMap.get(top, 0)

            if count + 1 == n:
                target = top
            else:
                hashMap[top] = count + 1

            bottom = bottoms[i]
            count_1 = hashMap.get(bottom, 0)

            if count_1 + 1 == n:
                target = bottom
            else:
                hashMap[bottom] = count_1 + 1

        return self.checks(tops, bottoms, target)

    def checks(self, tops, bottoms, target):
        topR = 0
        bottomR = 0

        for i in range(len(tops)):
            if target != tops[i] and target != bottoms[i]:
                return -1

            if target != bottoms[i]:
                bottomR += 1

            if target != tops[i]:
                topR += 1

        return min(topR, bottomR)

# greedy
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No