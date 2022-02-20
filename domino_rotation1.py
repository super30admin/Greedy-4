#time n, space 1
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        t=0
        b=0
        n=min(self.check(tops[0],tops,bottoms),self.check(bottoms[0],tops,bottoms))
        if n==inf:
            return -1
        return n
        
    def check(self,a,tops,bottoms):
        t=0
        b=0
        print(a)
        for i in range(len(tops)):
            if tops[i]==a and bottoms[i]==a:
                continue
            if tops[i]==a:
                b+=1
            elif bottoms[i]==a:
                t+=1
            
            else:
                return inf
        print(b,t)
        return min(b,t)
                
        