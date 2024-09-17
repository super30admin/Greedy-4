Procedure 1:
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we start by traversing the target string and check if each character is present in source or not.
If it reaches the end of the source then we reset the source index pointer and increment the out pointer count.
we do the process till all the characters in the target are traversed.


# Time complexity --> o(mn) m- len of source and n- len of target
# space complexity --> o(1)
class Solution(object):
    def shortestWay(self, source, target):
        """
        :type source: str
        :type target: str
        :rtype: int
        """
        i=0
        count=0
        j=0
        while i<len(target):
            index=i
            #source='abc' target='abcbc'
            #In the above we check each character in target with that source.if both are equal we increment the indexes in both source and target else we increment the index in source.
            while j<len(source) and i<len(target):
                if target[i]==source[j]:
                    i=i+1
                    j=j+1
                else:
                    j=j+1
            #If character at a given index in target is not present in the source then we return -1
            #source='abc' target='abdbc'
            if index==i:
                return -1
            #If the index in the target reaches the end then start from 0
            if j==len(source):
                j=0
            count=count+1
        return count
                

Procedure 2:
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we tried to optimise the above problem by using binary search in searching the elements in the dictionary.
we created a dictionary to store all the characters and their indices.
Next we check if every character in target is present in source or not and we use binary search to get the next greatest index to be traversed in source.we do this till we reach the end of the target string.


# Time complexity --> o(m logn) m--> len(target) n--> len(source)
# space complexity --> o(len(unique letters in source))
class Solution(object):
    def binarysearch(self,arr1,index):
        low=0
        high=len(arr1)-1
        if index<arr1[0]:
            return 0
        if index>arr1[-1]:
            return len(arr1)
        while low<high:
            mid=low+(high-low)/2
            if arr1[mid]<index:
                low=mid+1
            elif arr1[mid]>=index:
                high=mid
        return high
                
        
    def shortestWay(self, source, target):
        """
        :type source: str
        :type target: str
        :rtype: int
        """
        sindex=0
        tindex=0
        sdict=dict()
        out=0
        #for the given source create a map which has the character as key and its indices as the values.
        for i in range(len(source)):
            if source[i] not in sdict:
                sdict[source[i]]=[i]
            else:
                sdict[source[i]].append(i)
        #we start traversing the target string
        while tindex<len(target):
            #if the target character is not present in the map using the source string then we return -1
            if target[tindex] not in sdict:
                return -1
            #we need to get the next greatest index of the given character in the dictionary.
            index1=self.binarysearch(sdict[target[tindex]],sindex)
            #if it reaches the length of the dictionary then we need to reset the index and increment the out variable indicating source subset
            if index1==len(sdict[target[tindex]]):
                index1=0
                out=out+1
            #gng to the next index in the source string
            sindex=sdict[target[tindex]][index1]+1
            tindex=tindex+1
        return out+1
        
        
