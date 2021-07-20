#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 29 08:30:10 2019

@author: tanvirkaur
implemented on spyder
Time Complexity = O(m*n)
Space Complexity = O(1)
we maintain two pointers one for source and one for target
Then we compare the first element of source with the target
If we iterate through the entire source we again reset the pointer 
untill we visit the entire target
We maintain the curr pointer to check whether we have found the ith element
of target in source or not.

"""
def shortestWay(source, target):
    if source == target:
        return 1
    result = 0
    s = len(source)
    t = len(target)
    i = 0
    while (i<t):
        j =0
        curr = i
        while(j<s):
            if (i <t and source[j] == target[i]):
                i += 1
            j +=1
        if curr == i:
            return -1
        result += 1
    return result


    
                