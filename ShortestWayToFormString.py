import collections, bisect
# class Solution:
#     def shortestWay(self, source: str, target: str) -> int:
#         charset = set(source)
#         count,i,j=0,0,0
#         while j<len(target):
#             schar,tchar = source[i], target[j]
#             if tchar not in charset:
#                 return -1
#             if schar == tchar:
#                 i+=1
#                 j+=1
#                 if j == len(target):
#                     return count+1
#             else:
#                 i+=1

#             if i==len(source):
#                 count+=1
#                 i=0
#         return -1

# class Solution:
#     def shortestWay(self, source: str, target: str) -> int:
#         mapchartolist = collections.defaultdict(list)
#         for i,c in enumerate(source):
#             mapchartolist[c].append(i)
#         i,j,count=0,0,0
#         while j <len(target):
#             tchar = target[j]
#             if tchar not in mapchartolist:
#                 return -1
#             list_ = mapchartolist[tchar]
#             idx = self.binarysearch(list_,i)
#             if idx==len(list_):
#                 i=list_[0]
#                 count+=1
#             else:
#                 i = list_[idx]
#                 i+=1
#                 j+=1
#                 if j == len(target):
#                     return count+1
#             if i == len(source):
#                 i=0
#                 count+=1
#         return -1

#     def binarysearch(self, list_, target):
#         l,h=0,len(list_)-1
#         while l<=h:
#             mid = l+(h-l)//2
#             if target == list_[mid]:
#                 return mid
#             elif target > list_[mid]:
#                 l = mid+1
#             else:
#                 h = mid-1
#         return l
            
                
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        mapchartolist = collections.defaultdict(list)
        for i,c in enumerate(source):
            mapchartolist[c].append(i)
        i,j,count=0,0,0
        while j <len(target):
            tchar = target[j]
            if tchar not in mapchartolist:
                return -1
            list_ = mapchartolist[tchar]
            idx = bisect.bisect_left(list_,i)
            if idx==len(list_):
                i=list_[0]
                count+=1
            else:
                i = list_[idx]
                i+=1
                j+=1
                if j == len(target):
                    return count+1
            if i == len(source):
                i=0
                count+=1
        return -1
                
        
        