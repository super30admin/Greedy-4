class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        a=tops[0]
        b=bottoms[0]
        top_rot=bot_rot=0

        idx=0
        res1=res2=-1
        #a
        flag1=False
        while idx<len(tops):
            if tops[idx]!=a and bottoms[idx]!=a:
                flag1=True
                break
            
            if tops[idx]!=a:
                top_rot+=1
            
            if bottoms[idx]!=a:
                bot_rot+=1
            
            idx+=1
        
        if not flag1:
            res1=min(top_rot, bot_rot)
        
        #b
        idx=0
        flag2=False
        top_rot=bot_rot=0
        while idx<len(bottoms):
            if tops[idx]!=b and bottoms[idx]!=b:
                flag2=True
                break
            
            if tops[idx]!=b:
                top_rot+=1
            
            if bottoms[idx]!=b:
                bot_rot+=1

            idx+=1
        
        if not flag2:
            res2=min(top_rot, bot_rot)
        
        if res1==-1 and res2==-1:
            return -1
        
        elif res1!=-1:
            return res1
        
        elif res2!=-2:
            return res2
        
        else:
            return min(res1, res2)

        
        

