#Time Complexity :o(m*n) 
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def shortestWay(self, source, target):
        """
        :type source: str
        :type target: str
        :rtype: int
        """
        
        trg=0
        src=0
        cnt=0
        
        while trg<len(target):
            cnt+=1
            src=0
            curr=trg
            while (src<len(source) and trg<len(target)):
                if(source[src]==target[trg]):
                    trg+=1
                src+=1
            if(curr==trg):
                return -1
        return cnt
                
            
                