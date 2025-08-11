from typing import List
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:

        def check(target):
            topr,botr=0,0
            for t,b in zip(tops,bottoms):
                if target!=t and target!=b:
                    return float("inf")
                if target!=t:
                    topr+=1
                if target!=b:
                    botr+=1
            return min(topr,botr)
        rotations = min(check(tops[0]), check(bottoms[0]))
        return rotations if rotations!=float("inf") else -1


# class Solution:
#     def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
#         maptb = defaultdict(int)
#         target, le = -1,len(tops)
#         for i in range(le):
#             maptb[tops[i]]+=1
#             if maptb[tops[i]] == le:
#                 target = tops[i]
#                 break
#             maptb[bottoms[i]]+=1
#             if maptb[bottoms[i]] == le:
#                 target = bottoms[i]
#                 break
#         if target == -1:
#             return -1
#         return self.helper(target, tops,bottoms)
    
#     def helper(self, target, tops, bottoms):
#         i,le,top,bot=0,len(tops),0,0
#         for i in range(le):
#             if target!=tops[i] and target!=bottoms[i]:
#                 return -1
#             elif target== tops[i] and target == bottoms[i]:
#                 continue
#             elif target!= tops[i]:
#                 top+=1
#             elif target!=bottoms[i]:
#                 bot+=1
#         return min(top,bot)

        