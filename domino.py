#To solve this problem, first find the maximum frequency element by maintining hash map then calcultee the maximum rotations in the array.
#Time Compleexity: O(2n)
#Space Compleexity: O(n)
class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        if A is None or len(A)==0:
            return 0
        maxfreq = 0
        max = -1
        countMap = dict()
        for i in range(len(A)):
            if A[i] not in countMap:
                countMap[A[i]] = 1
            if B[i] not in countMap:
                countMap[B[i]] = 1
            elif A[i] in countMap:
                countMap[A[i]] = countMap[A[i]]+1
            elif B[i] in countMap:
                countMap[B[i]] = countMap[B[i]]+1
            maxfreq = min(maxfreq,countMap[A[i]])
            if maxfreq >= len(A):
                max = A[i]
                break
            maxfreq = min(maxfreq,countMap[B[i]])
            if maxfreq >= len(A):
                max = B[i]
                break
        if max == -1:
            return -1
        arot = 0
        brot = 0
        for i in range(len(A)):
            if A[i]!=max and B[i]!=max:
                return -1
            if A[i]!=max:
                arot += 1
            if B[i]!=max:
                brot += 1
        return min(arot,brot)