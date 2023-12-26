# Time: O(mn)
# Space: O(mn)
# Did it run on Leetcode: yes

class Solution(object):
    def shortest(self, source, target):
        count=1
        m=len(source)
        n=len(target)
        hmap={}
        for i in range(m):
            c=source[i]
            if(c not in hmap):
                hmap[c]=[]
                hmap[c].append(i)
        i=0
        j=0
        while(j<n):
            tc=target[j]
            sc=source[i]
            if(tc not in hmap):
                return -1
            li=hmap[tc]
            k=binarysearch(li,i)
            if(k<0):
                k=-k-1
            if(k==len(li)):
                i=0
                count+=1
            else:
                i=li[k]
                i+=1
                j+=1
        return count