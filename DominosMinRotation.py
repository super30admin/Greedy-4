"""1007. Minimum Domino Rotations For Equal Row
TC - O(N)
SC - O(1)"""
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        if tops is None or len(tops)==0:
            return 0
        result = self.check(tops,bottoms,tops[0])
        if result !=-1:
            return result
        return self.check(tops,bottoms,bottoms[0])
    
    def check(self,top,bottom,target):
        aRot=0
        bRot=0
        n=len(top)
        for i in range(0,n):
            if top[i]!= target and bottom[i]!=target:
                return -1
            elif top[i]!=target:
                aRot +=1

            elif bottom[i]!=target:
                bRot+=1
        return min(aRot,bRot)

        
        






"""
Time Complexity : O(n)
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        if tops ==None or bottoms ==None:
            return 0
        hashmap = {}
        maxFreq = 0
        max_ele = 0
        for i in range(0,len(tops)):
            top = tops[i]
            bottom = bottoms[i]
            countTop = hashmap.get(top,0)
            countTop+=1
            if countTop>maxFreq :
                maxFreq =countTop
                max_ele = top
            hashmap[top] = countTop
            countBottom = hashmap.get(bottom,0)
            countBottom+=1
            if countBottom>maxFreq:
                maxFreq =countBottom
                max_ele = bottom
            hashmap[bottom] = countBottom
        aRot = 0
        bRot = 0
        for  i in range(0, len(tops)):
            if tops[i] != max_ele and bottoms[i]!= max_ele:
                return -1
            elif tops[i]!= max_ele:
                aRot+=1
            elif bottoms[i]!= max_ele:
                bRot +=1
        return min(aRot,bRot)"""
