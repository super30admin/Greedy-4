#time m*n, space 1
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        hmap={}
        for i in source:
            if i not in hmap.keys():
                hmap[i]=0
            hmap[i]+=1
        i=0
        pos=0
        counter=1
        
        while i<len(target):
            print(i,pos)
            if target[i] not in hmap.keys():
                return -1
            if target[i]==source[pos]:
                pos+=1
                i+=1
            else:
                pos+=1
            if pos==len(source) and i<len(target):
                pos=0
                counter+=1
        
        return counter
        
                
                
            
        