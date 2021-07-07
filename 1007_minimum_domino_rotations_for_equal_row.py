from typing import List


class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        """
            https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
            Time Complexity - O(n)
                'n' is the number of dominos
            Space Complexity - O(1)
        """
        rotate_A = self.rotate_domino(A, B, A[0])
        if rotate_A != -1:
            return rotate_A
        return self.rotate_domino(A, B, B[0])

    def rotate_domino(self, A: List[int], B: List[int], x: int) -> int:
        top_rot = bot_rot = 0
        for i in range(len(A)):
            # we couldn't find x both in both faces
            # we cannot make any swaps
            if A[i] != x and B[i] != x:
                return -1
            elif A[i] != x:
                top_rot += 1
            elif B[i] != x:
                bot_rot += 1
        return min(top_rot, bot_rot)


if __name__ == '__main__':
    print(Solution().minDominoRotations([2, 1, 2, 4, 2, 2], [5, 2, 6, 2, 3, 2]))
    print(Solution().minDominoRotations([1, 2, 1, 1, 1, 2, 2, 2],
                                        [2, 1, 2, 2, 2, 2, 2, 2]))
