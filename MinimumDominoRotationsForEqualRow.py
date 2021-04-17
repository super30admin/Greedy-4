# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Greedy Approach


class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        if not A or not B:
            return None
        maxfreq = -inf
        for i in range(1, 7 + 1):
            count = 0
            for j in range(len(A)):
                if A[j] == i:
                    count += 1
                if B[j] == i:
                    count += 1
            if count >= len(A):
                maxfreq = i
                break

        aRotations = 0
        bRotations = 0
        for i in range(len(A)):
            if A[i] != maxfreq and B[i] != maxfreq:
                return -1
            if A[i] != maxfreq:
                aRotations += 1
            if B[i] != maxfreq:
                bRotations += 1
        return min(aRotations, bRotations)
