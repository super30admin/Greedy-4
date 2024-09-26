'''
Accepted on leetcode(1007)
time - O(N)
space - O(1)
Approach:
# As we have to check for single number which can replace either A or B. So, that number must be either of element which exist in 0th index(any one index corresponding to A and B)
'''


class Solution:
    def minDominoRotations(self, A, B) -> int:
        # First we check for A[0], if thats the number then return the minimum replacement count. or else check for B[0]
        retVal = self.check(A, B, A[0])

        if retVal != -1 or A[0] == B[0]:
            return retVal
        return self.check(A, B, B[0])

    def check(self, A, B, x):
        a_rot = 0
        b_rot = 0
        # iterate over either array and check for 3 cases.
        for i in range(len(A)):
            if A[i] != x and B[i] != x:
                return -1
            elif A[i] != x:
                a_rot += 1
            elif B[i] != x:
                b_rot += 1

        return min(a_rot, b_rot)