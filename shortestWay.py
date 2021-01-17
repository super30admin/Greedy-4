class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        
        count = 0
        
        targetLength = len(target);
        sourceLength = len(source)
        
        
        targetPointer = 0
        sourcePointer = 0
        
        while targetPointer<targetLength:
            count+=1
            sourcePointer = 0
            curr = targetPointer
            # print(sourcePointer, targetPointer, targetLength, sourceLength )
            while targetPointer<targetLength and sourcePointer<sourceLength:
                # print(sourcePointer, targetPointer )
                if source[sourcePointer] == target[targetPointer]:
                    targetPointer+=1
                sourcePointer+=1
            
            if targetPointer == curr:
                return -1
    
        return count
                    
Time: O(targetLength*sourceLength)
Space: O(1)
