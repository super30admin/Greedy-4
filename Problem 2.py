# time complexity: O(N)
# space complexity: O(1)
class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:

        # helper function will take a value and iterate to find min num of rotations possible
        def helper(val):
            a_rotations = 0
            b_rotations = 0
            for i in range(len(A)):
                # not possible to make array of value val
                if (A[i] != val and B[i] != val):
                    return -1
                elif (A[i] != val):
                    a_rotations += 1
                elif (B[i] != val):
                    b_rotations += 1
            return min(a_rotations, b_rotations)

        # try with first value of A
        rot1 = helper(A[0])

        # if first value of both are same then makes no sense
        if A[0] == B[0]:
            return rot1
        else:
            rot2 = helper(B[0])

            # if both of them gives some value then find min and return it
            if rot2 != -1 and rot1 != -1:
                return min(rot1, rot2)
            elif rot1 != -1:
                return rot1
            else:
                return rot2
