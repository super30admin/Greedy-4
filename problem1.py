#Minimum Path Form String formation
# // Time Complexity : O(N*M)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def shortestWay(source, target):
    i=0
    j=0
    count=0
    existing=set(source)
    while(j<len(target)):
        if(i==0):                           #if you get to the first index of the source, count should always increment
            count+=1
        if (target[j] not in existing):     #if a character in target doesnt exists in source, return -1
            return -1
        if (source[i]==target[j]):          #if the both characters match, increment the indices of both strings
            i+=1
            j+=1
        else:                               #if the characters dont match, then just increment the index of the source
            i+=1
        if(i==len(source)):                 #if the source index gets to the end, then restart it
            i=0
            
    return count 


