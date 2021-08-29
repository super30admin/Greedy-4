# Time Complexity: O(n)
# Space Complexity: O(1)
from typing import List

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:

        n = len(tops)

        min_rotation = -1

        possible_values = []

        if tops[0] != bottoms[0]:
            possible_values.append(tops[0])
            possible_values.append(bottoms[0])
        else:
            possible_values.append(tops[0])

        for value in possible_values:

            top_rot = 0
            bottom_rot = 0
            index = n - 1

            while index >= 0:

                if tops[index] != value and bottoms[index] != value:
                    break

                if tops[index] != value:
                    top_rot += 1

                if bottoms[index] != value:
                    bottom_rot += 1

                index -= 1

            if index < 0:
                return min(top_rot, bottom_rot)

        return -1