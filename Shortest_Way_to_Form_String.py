class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        if not target:
            return 0
        
        count= 0
        tidx = 0
        sidx = 0
        slen = len(source)
        tlen = len(target)
        
        while tidx < tlen :
            count += 1
            curr = tidx
            sidx = 0
            
            while sidx < slen and tidx < tlen:
                
                if source[sidx] == target[tidx]:
                    sidx +=1
                    tidx +=1
                else: 
                    sidx +=1
            
            if  curr == tidx:
                return -1
            
        return count
