'''
Leetcode - 1055 - Minimum Path Form String formation 
time complexity - O(n*m)
space complexity - o(1)

Approach - Two pointers approach 
         1) increment sp and tp when both the source and target chars are equal else increment sp alone
         2) if curr remains the same after we pass through entire source then that particular char is not present in source. forexample a
        3) if there are chars in target and source iteration get over then again we start from intial char from source onwards.
        
        4) In the end return res
        
'''
#code
def minimum (source,target):
    s=len(source)
    t=len(target)
    
    SP=0
    TP=0
    
    res=0
    
    while TP<t:
        SP=0
        curr=TP
        while SP<s:
            if TP<t and source[SP]==target[TP]:
                TP+=1
            SP+=1
        if curr==TP:
            return -1
        res+=1
    return res
source="xyz"
target="xzyxz"
print(minimum(source, target))