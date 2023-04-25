#Could not be tested on leetcode as its premium problem

class Solution:

    from bisect import bisect_right

class Solution:
    
    #Here we store chars of source in a map with their indices. We then iterate over source and target. If cur char in both are equal then increment both pointers. If chars mismatch then we get index from indices array for the cur target char.If this index is out of bound then we set s pointer to 0. If source pointer goes out of bounds then reset to 0. If target char is not in set then return -1
    #Time complexity - O(m) + O(nlogk) where m=souce length and n = target length, k= avg length of indices array for each char. Here we form cource chars map, then we perform binary search on indices(k) array for each char in target(n)
    #Space complaeity - O(m) - list of indices
    
    def binarySearch(self, indices, start):
        i = bisect_right(indices, start)
        if i>=len(indices):
            return -1
        if indices[i]>=start:
            return i
        return -1
                
        
    def shortestWayToFormString(self, source, target):
        slen = len(source)
        tlen = len(target)
        smap = {}
        for i in range(slen):
            if source[i] not in smap:
                smap[source[i]] = [i]
            else:
                smap[source[i]].append(i)
        
        sl = 0
        tl = 0
        count = 0
        while tl<tlen:
            if target[i] not in smap:
                return -1
            if source[sl]==target[tl]:
                sl+=1
                tl+=1
            else:
                list = smap[target[tl]]
                idx = self.binarySearch(list, sl)
                if idx==-1:
                    sl=0
                    count+=1
                else:
                    sl = list[idx]
            if sl>=slen:
                sl=0
                count+=1
        return count
      
    
    
s = Solution()
res = s.shortestWayToFormString("abc", "abcbc")
print(res)
res = s.shortestWayToFormString("xyz", "xzyxz")
print(res)
res = s.shortestWayToFormString("abc", "abdbc")
print(res)




#--------------------------------------OR-----------------------------------------------
    
    #Here we store chars of source in a set. We then iterate over source and target. If cur char in both are equal then increment both pointers. If chars mismatch then increment only source pointer. If source pointer goes out of bounds then reset to 0. If target char is not in set then return -1
    #Time complexity - O(m*n) where m=souce length and n = target length. There can be case of iterating source array from start for every target char
    #Space complaeity - O(1) - set stores max 26 chars
    def shortestWayToFormString(self, source, target):
        slen = len(source)
        tlen = len(target)
        sset = set()
        for i in range(slen):
            if source[i] not in sset:
                sset.add(source[i])
        
        sl = 0
        tl = 0
        count = 0
        while tl<tlen:
            if target[i] not in sset:
                return -1
            if source[sl]==target[tl]:
                sl+=1
                tl+=1
            else:
                sl+=1
            
            if sl>=slen:
                sl=0
                count+=1
        return count
        
    
    
s = Solution()
res = s.shortestWayToFormString("abc", "abcbc")
print(res)
res = s.shortestWayToFormString("xyz", "xzyxz")
print(res)
res = s.shortestWayToFormString("abc", "abdbc")
print(res)