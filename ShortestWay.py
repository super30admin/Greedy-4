#  Time Complexity : O(N*M)
#  Space Complexity :O(N)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


def shortestWay(source, target):
    i=0
    j=0
    count=0
    existing=set(source)
    while(j<len(target)):
        if(i==0):                           
            count+=1
        if (target[j] not in existing):     
            return -1
        if (source[i]==target[j]):          
            i+=1
            j+=1
        else:                               
            i+=1
        if(i==len(source)):                
            i=0

    return count 