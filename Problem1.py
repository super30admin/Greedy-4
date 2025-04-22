#time complexity o(n)
#space complexity o(1)
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        def check(target):
            arot = brot = 0
            for i in range(len(tops)):
                if tops[i] != target and bottoms[i] != target:
                    return float('inf') 
                
                if tops[i] != target:
                    arot += 1
                if bottoms[i] != target:
                    brot += 1
            return min(arot, brot)

        option1 = check(tops[0])
        option2 = check(bottoms[0])
        result = min(option1, option2)
        return result if result != float('inf') else -1
