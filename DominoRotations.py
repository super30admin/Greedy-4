# Time Complexity : O(n) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# class Solution:
#     def minDominoRotations(self, A, B):
#         maxFreq = 0 
#         for i in range(1, 7):
#             count = 0 
#             for j in range(len(A)):
#                 if A[j] == i :
#                     count +=1 
#                 if B[j] == i:
#                     count += 1 
#             if count >= len(A):
#                 maxFreq = i

#         maxA = 0 
#         maxB = 0 
#         for i in range(len(A)):
#             if A[i] != maxFreq and B[i] != maxFreq: 
#                 return -1 
#             if A[i] != maxFreq:
#                 maxA += 1 
            
#             if B[i] != maxFreq:
#                 maxB += 1 
        
#         return min(maxA, maxB)

class Solution:
    def minDominoRotations(self, A, B):
        if len(A) == 0 or A is None :
            return 0
        res = self.check(A, B, B[0])
        if res != -1:
            return res 
        return self.check(A, B, A[0])
    
    def check(self, A, B, target):
        maxA = 0 
        maxB = 0 
        for i in range(len(A)):
            if A[i] != target and B[i] != target: 
                return -1 
            if A[i] != target:
                maxA += 1 
            
            if B[i] != target:
                maxB += 1 
        
        return min(maxA, maxB)
    
if __name__ == "__main__":
    s = Solution()
    A = [2,1,2,4,2,2]
    B = [5,2,6,2,3,2]
    res = s.minDominoRotations(A, B )
    assert res == 2
        