#Time: O(s*t)
#Space: O(1)

class Solution:
    def shortestWay(self, source: str, target: str) -> int:

        
        sCursor = 0
        tCursor = 0
        count = 0

       
        while (tCursor < len(target)):

           
            currentTargetCursor = tCursor

            
            while (sCursor < len(source) and tCursor < len(target)):
                if (source[sCursor] == target[tCursor]):
                    sCursor += 1
                    tCursor += 1
                else:
                    sCursor += 1

           
            if (currentTargetCursor == tCursor):
                return -1

           
            count += 1
            sCursor = 0

        
        return count
