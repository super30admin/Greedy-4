#Leetcode 1007 Dominos
#time -  O(n)
#Question
#Given a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.

#We may rotate the i-th domino, so that A[i] and B[i] swap values.

#Find the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

#If it cannot be done, return -1.

#algo : If the dominos has to be same, either of A[0] or B[0] has to be present in the evry index either at A or B
#TO FIND THIS WE HAVE CHECK, WE FIRST CHECK for A[0] and then checl for B[0], in both cases we find the min_rotations for A and also min_rotations for B for A[0] and then also find for B[0] id A[0] does not exist, if both exist then A[0] sol will be equal to B[0], so no need to worru about this case


class Solution_1:
    def check(self,A,B,z):
        A_rotations =0
        B_rotations =0

        for i in range(len(A)):
            if A[i] != z and B[i] != z:
                return -1
            elif A[i] != z: #this case when we have to flip domino at A, if we give B[i] == X, then we may miss cases when both B[i] = A[i]= X
                A_rotations += 1
            elif B[i] != z:
                B_rotations += 1
        return min(A_rotations,B_rotations)
    def minDominoRotations_for_elementX(self,A,B):
        return_val = self.check(A,B,A[0]) #checking for A
        if return_val != -1 or A[0] == B[0]:
            return return_val
        return self.check(A,B,B[0])

#another approcah wihout using 2 functions , same logic
class Solution:
    def check(self,A,B):
        A_rotations =0
        B_rotations =0
        X= [A[0],B[0]] #cheking first 2 variables
        #return variables
        return_val = 0
        for z in X: #X has 2 values
            for i in range(len(A)):
                if A[i] != z and B[i] != z:
                    return_val =  -1
                    break;
                elif A[i] != z: #this case when we have to flip domino at A, if we give B[i] == X, then we may miss cases when both B[i] = A[i]= X
                    A_rotations += 1
                elif B[i] != z:
                    B_rotations += 1

            if return_val != -1:
                return_val = min(A_rotations, B_rotations)
                break;
        return return_val


j = Solution()
print(j.check([2,3,4,2,2],[4,2,2,1,5]))
k = Solution_1()
print(k.minDominoRotations_for_elementX([2,3,4,2,2],[4,2,2,1,5]))




