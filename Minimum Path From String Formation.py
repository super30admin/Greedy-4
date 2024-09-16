# Time:- O(2n)
# Space:-O(1)
class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        # first number from A
        a=A[0]
        # First number from B
        b=B[0]
        def check(a):
            check=0
            check1=0
            for i in range(len(A)):
                # if the number not in A or B return -1
                if a not in (A[i],B[i]):
                    return -1
                elif a!=B[i]:
                    check+=1
                elif a!=A[i]:
                    check1+=1
            return min(check,check1)
        # Check how many rotations required to make A or B equal
        checka=check(a)
        checkb=check(b)
        if checka==-1 and checkb==-1:
            return -1
        if checka==-1:
            return checkb
        return checka