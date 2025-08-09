"""
Time Complexity: O(n)
Space Complexity: O(11)
"""
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:

        def rotation(target):
            topRotation = 0
            bottomRotation = 0
            for top, bottom in zip(tops, bottoms):
                if top != target and bottom != target:
                    return float("inf")
                elif top != target:
                    topRotation += 1
                elif bottom != target:
                    bottomRotation += 1
            return min(topRotation, bottomRotation)

        target1 = rotation(tops[0])
        target2 = rotation(bottoms[0])

        result = min(target1, target2)

        return result if result != float("inf") else -1