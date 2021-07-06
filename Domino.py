### take the first elements from A,B and check if they exist in A,B-> if they dont in any given index of A,B return -1.
## tim - O(n)
# space-O(1)
class Solution:
    def check(self, A, B, target):

        for i in range(len(A)):
            if target != A[i] and target != B[i]:
                return -1
            if target != A[i]:
                self.count_a += 1
            if target != B[i]:
                self.count_b += 1
        return min(self.count_a, self.count_b)

    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        self.count_a = 0
        self.count_b = 0
        first = self.check(A, B, A[0])
        self.count_a = 0
        self.count_b = 0
        second = self.check(A, B, B[0])
        if first != -1 and second != -1:
            return min(first, second)
        if second == -1:
            return first
        return second
