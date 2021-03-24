"""
Time Complexity : O()
Space Complexity : O()
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination O(n)
METHOD 1:
1. find element with max frequency 
2. look if we have that element at each index either in one row
3. swap and calculate swaps for both the arrays
4. return the min one

METHOD 2: O(N)
1. take elements of oth index from both the lists
2. if both are not present at any index then return -1
3. swap both and return min

"""
class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        if len(A) == 0 or len(B) == 0: return 0
        
        def rot(target):
            arot,brot =0,0
            for i in range(len(A)):
                if A[i] != target and B[i]!= target:
                    return -1
                if A[i] != target:
                    arot += 1
                if B[i] != target:
                    brot += 1
            return min(arot, brot)
        
        res = rot(A[0])
        if res != -1: return res
        return rot(B[0])
        
        
        
#         ca,cb = 0,0
#         v = [0]*7
#         for i in range(len(A)):
#             v[A[i]] += 1
#             v[B[i]] += 1
#         mx = max(v)
#         for i in range(1, len(v)):
#             if v[i] == mx:
#                 mx = i
                
#         for j in range(len(A)):
#             if A[j] != mx and B[j] != mx:
#                 return -1
#             if A[j] != mx:
#                 ca += 1
#             if B[j] != mx:
#                 cb += 1
#         return min(ca,cb)
        
        
        
        
        