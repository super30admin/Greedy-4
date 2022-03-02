# TC: O(m) where m is len of arr
# SC: O(n) which will be 6 in this case. Hence we can say O(1)
# Approach 1:
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        if tops is None or len(tops) == 0 or len(bottoms) != len(tops):
            return -1

        hashmap = {}
        target = -1
        for i in range(0, len(tops)):
            hashmap[tops[i]] = hashmap.get(tops[i], 0) + 1
            if hashmap[tops[i]] >= len(tops):
                target = tops[i]

        for i in range(0, len(bottoms)):
            hashmap[bottoms[i]] = hashmap.get(bottoms[i], 0) + 1
            if hashmap[bottoms[i]] >= len(bottoms):
                target = bottoms[i]

        topRotations = 0
        bottomRotations = 0

        if target == -1:
            return target

        for i in range(0, len(tops)):
            if tops[i] != target and bottoms[i] != target:
                return -1

            if tops[i] != target and bottoms[i] == target:
                topRotations += 1

            if bottoms[i] != target and tops[i] == target:
                bottomRotations += 1

        return min(topRotations, bottomRotations)

# TC: O(m) where m is len of arr
# SC: O(1)
#     Approach 2:
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        if tops is None or len(tops) == 0 or len(bottoms) != len(tops):
            return -1

        hashmap = {}
        target = -1
        for i in range(0, len(tops)):
            hashmap[tops[i]] = hashmap.get(tops[i], 0) + 1
            if hashmap[tops[i]] >= len(tops):
                target = tops[i]

        for i in range(0, len(bottoms)):
            hashmap[bottoms[i]] = hashmap.get(bottoms[i], 0) + 1
            if hashmap[bottoms[i]] >= len(bottoms):
                target = bottoms[i]

        target = self.getRotation(tops, bottoms, tops[0])
        if target != -1:
            return target

        return self.getRotation(tops, bottoms, bottoms[0])

    def getRotation(self, tops, bottoms, target):

        topRotations = 0
        bottomRotations = 0

        for i in range(0, len(tops)):
            if tops[i] != target and bottoms[i] != target:
                return -1

            if tops[i] != target and bottoms[i] == target:
                topRotations += 1

            if bottoms[i] != target and tops[i] == target:
                bottomRotations += 1

        return min(topRotations, bottomRotations)

