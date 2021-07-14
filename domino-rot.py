class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        if tops is None or len(tops)==0:
            return 0
        rotations = self.computeRotations(tops,bottoms,tops[0])
        if rotations !=-1:
            return rotations
        return self.computeRotations(tops,bottoms,bottoms[0])
    
    def computeRotations(self,top,bottom,target):
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
                

        
        