#Time O(n),space O(1)
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        
        #comparing top element
        res=self.helper(otops,bottoms,tops[0])
        
        if res !=-1:
            return res
        #comparing bottom element
        return self.helper(tops,bottoms,bottoms[0])
        
  #helper  to find the min count      
    def helper(self,tops,bottoms,target):
        
        t=0
        b=0
        
        for i in range(len(tops)):
            
            if tops[i]!=target and bottoms[i]!=target:
                return -1
            
            if tops[i]!=target:
                t+=1
                
            elif bottoms[i]!=target:
                b+=1
                
           
        return min(t,b)
