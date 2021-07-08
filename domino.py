# Time complexity - O(2n)
# Space complexity - O(1)
# Did this code run on leetcode? - yes
# STEPS:
# check if A[0] or B[0] is present in the remaining array.
# iterate through the array.
# if the element is not present in either A or B at any position, break.
# else, count the occurrence of A and B.
class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        # length of dominon array
        n = len(A)
        self.min_rotations = float('inf')
        
        for elem in [A[0], B[0]]:
            i=0
            found = True
            Acount, Bcount = 0, 0
            while i<n:
                if elem not in [A[i], B[i]]:
                    found = False
                    break
                if elem == A[i]:
                    Acount += 1
                if elem == B[i]:
                    Bcount += 1
                i+=1
            
            if found:   
                return n-max(Acount, Bcount)
            
        return self.min_rotations if self.min_rotations!=float('inf') else -1 


# Time complxity - O(7n)
# Space complexity - O(1)
# Did this code run on leetcode? - yes
# count the maximum occuring element
# if the count is greater than or equal to length of A.
# count the number of rotations that would be required for this element.
# if this element is not found at the current location in either A or B, return -1.
class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        # length of dominon array
        n = len(A)
        
        # count the maximum occuring element
        for elem in range(1, 7):
            count = 0
            for i in range(n):
                if A[i]!=elem and B[i]!=elem:
                    break
                if A[i]==elem:
                    count+=1
                if B[i]==elem:
                    count+=1
                if count >= n:
                    return self._check_element(A, B, elem)
        
        return -1
    
    def _check_element(self, A, B, target):
        n = len(A)
        ARot, BRot = 0, 0
        for i in range(n):
            if (A[i]!=target and B[i]!=target):
                return -1
            if A[i]!=target:
                ARot += 1
            if B[i]!=target:
                BRot += 1
        return min(ARot, BRot)
        
        