class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        if not tops or not bottoms:
            return 0
        
        topmin = self.computeminimum(tops,bottoms,tops[0])
        
        if topmin == -1 :
            return self.computeminimum(tops, bottoms, bottoms[0])
        else:
            return topmin
        

        
    def computeminimum(self,tops,bottoms,target):
        arot, brot = 0,0
        for i in range(0,len(tops)):
            
            if tops[i] != target and bottoms[i] != target:
                return -1
            
            elif tops[i] != target:
                arot +=1
            elif bottoms[i] != target:          
                brot+=1
        
        return min(arot,brot)
             
