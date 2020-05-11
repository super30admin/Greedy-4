'''
Solution:
1.  Check for first element in A and if -1 => check for first element in B
2.  While iterating, if both elements not equal to x => return -1
3.  Otherwise, return the minimum of both counts.

Time Complexity:    O(n)
Space Complexity:   O(1)

--- Passed all testcases on leetcode successfully
'''

class DominoRotation:

    def __check(self, A: List[int], B: List[int], x: int) -> int:

        #   initializations
        moveToTop = 0
        moveToBottom = 0

        #   iterate over A and B
        for i in range(len(A)):

            #   if both not equal to x => return -1
            if (A[i] != x and B[i] != x):
                return -1

            #   if B's element == x => move to top will be incremented
            elif (A[i] != x):
                moveToTop += 1

            #   else move to bottom will be incremented
            elif (B[i] != x):
                moveToBottom += 1

        #   take the minimum of both the counts
        return min(moveToTop, moveToBottom)

    def minDominoRotations(self, A: List[int], B: List[int]) -> int:

        #   check for first element in A and if -1 => check for first element in B
        rotations = self.__check(A, B, A[0])
        if (rotations != -1):
            return rotations
        return self.__check(A, B, B[0])
