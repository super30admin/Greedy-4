class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        
        def getRotations(a,b,val):
            a_rot=0
            b_rot=0
            
            for i in range(len(a)):
                if a[i]!=val and b[i]!=val:
                    return -1
                elif a[i]!=val:
                    a_rot+=1
                elif b[i]!=val:
                    b_rot+=1
                    
            return min(a_rot,b_rot)
        
        output=getRotations(tops,bottoms,tops[0])
        if output!=-1:
            return output
        return getRotations(tops,bottoms,bottoms[0])
        