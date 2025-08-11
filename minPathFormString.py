class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        count=1
        hmap={}

        def binSearch(arr, t):
            ans=None
            l=0
            r=len(arr)-1

            while l<=r:
                mid=(l+r)//2

                if arr[mid]>t:
                    ans=arr[mid]
                    r=mid-1
                else:
                    l=mid+1

            return ans

        # Hashmap of characters from source with list of indices (for repeats)
        for idx, char in enumerate(source):
            if char not in hmap:
                hmap[char]=[]
            
            hmap[char].append(idx)

        curr_idx=-1
        for char in target:
            if char not in hmap:
                return -1
            
            li=hmap[char]
            newIdx=binSearch(li, curr_idx)

            if newIdx is None:
                count+=1
                curr_idx=li[0]
            
            else:
                curr_idx=newIdx
        
        return count


        
