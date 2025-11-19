# Time complexity: O(n). Space: 0(n) for count map
# The approach here is to determine the highest frequency element and then determine with that element can we either get top or bottom row as the same with minimum operations.

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        countMap = {}
        for num in tops:
            if num not in countMap:
                countMap[num] = 1
            else:
                countMap[num] += 1

        for num in bottoms:
            if num not in countMap:
                countMap[num] = 1
            else:
                countMap[num] += 1

        result = float("inf")
        maxKey = 0
        maxVal = 0
        for key, val in countMap.items():
            if val > maxVal:
                maxKey = key
                maxVal = val

        result = min(result, self.helper(tops, bottoms, maxKey))
        return -1 if result == float("inf") else result

    def helper(self, tops, bottoms, num):
        topS = 0
        bottomS = 0
        for i in range(len(tops)):
            if tops[i] != num and bottoms[i] != num: return -1
            if tops[i] != num:
                topS += 1

            if bottoms[i] != num:
                bottomS += 1

        return min(topS, bottomS)

# The time complexity: O(n). The space is O(1). Here if we have to achieve the solution, the value has to be there in either top or bottom array. So we can consider taking the
# first value in top row and the first value in bottom row and check if we can make either top or bottom row as same number. If we can then we can return the operations otherwise -1

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:

        result1 = self.helper(tops, bottoms, tops[0])
        result2 = self.helper(tops, bottoms, bottoms[0])

        if result1 == -1 and result2 == -1:
            return -1

        if result1 > 0:
            return result1
        else:
            return result2

    def helper(self, tops, bottoms, num):
        topS = 0
        bottomS = 0
        for i in range(len(tops)):
            if tops[i] != num and bottoms[i] != num: return -1
            if tops[i] != num:
                topS += 1

            if bottoms[i] != num:
                bottomS += 1

        return min(topS, bottomS)
