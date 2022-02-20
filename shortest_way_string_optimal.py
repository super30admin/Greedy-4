#time mlogn, space n, list stored at each step
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        hmap={}
        for i in range(len(source)):
            if source[i] not in hmap.keys():
                hmap[source[i]]=[]
            hmap[source[i]].append(i)
        print(hmap)
        i=0
        pos=0
        counter=1
        
        while i<len(target):
            if target[i] not in hmap.keys():
                return -1
            #find corresponding index
            li=hmap[target[i]]
            print(li,pos)
            k=self.binarysearch(li,pos)
            print(k)
            if k<0:
                k=-k-1
            if k==len(li):
                counter+=1
                pos=0
                
            
            else:
                pos=li[k]+1
                i+=1
            print(pos,i,counter)
              
                
            
        return counter
    def binarysearch(self,li,pos):
        l=0
        h=len(li)-1
        
        while l<=h:
            mid=(l+h)//2
            if li[mid]==pos:
                return mid
            elif li[mid]>pos:
                h=mid-1
            else:
                l=mid+1
        print(l)
        return l
                
    
            
            
        
        
        
                
                
            
        