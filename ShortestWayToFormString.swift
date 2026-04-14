//
//  ShortestWayToFormString.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/20/26.
//

/*
 target - abcbc
 source - abc -> 2 subsequences of source is required to form the target
 result = 2
 
 target - abccdb
 source - abc
 result = -1 (can't for d)
 
 approach 1 -> do a normal 2-pointer
 if char qual - move both pointers
 if source pointer goes out of bounds, reset the pointer to the beginning of source and
 increase the count of result
 if chars not equal - just move the source pointer.
 move back the pointer at the source and increase the count by 1.
 as soon as the target pointer goes out of bouds, we get the final count.
 
 for checking the scenario where we have something like d. create a hash set,
 check if current character in target is present in source or not.
 space complexity -> O(1), only 26 haracters
 
 time compelxity for this colution -> m * n bruteforce solution
 
 If we want to give list of subsequences-
 in each pass, whereever the character matches, add it to that pass's subsequence, and return that.
 */

class ShortestWayToFormString {
    
    //m * n -> bruteforce
    func shortestWay(_ source: String, _ target: String) -> Int {
        var sourceArr = Array(source)
        var targetArr = Array(target)
        var m = sourceArr.count
        var n = targetArr.count
        
        var set = Set<Character>()
        for i in 0..<m {
            let char = sourceArr[i]
            set.insert(char)
        }
        var count = 1
        var sp = 0
        var tp = 0
        while (tp < n) {
            let tChar = targetArr[tp]
            if (!set.contains(tChar)) {
                return -1
            }
            if (tChar == sourceArr[sp]) {
                tp += 1
                sp += 1
            } else if (tChar != sourceArr[sp]) {
                sp += 1
            }
            if (sp == m && tp != n) {
                sp = 0
                count += 1
            }
        }
        return count
    }
    
    /*
     approach2  - optimal solution
     source - abcaabbcadeeedabbcefaab
     t = acccda
     If I knowthe next position of c, then can jump to that position rather than going one by one
     for that we need to know idnics of characters
     Will store the indices of each and every character in source
     c : [2, 8, 17]
     a : [0, 3, 4, 7, 14, 20, 21]
     b: [1, 5, 6, 15, 16, 22]
     d: [9, 13]
     e: [10, 11, 12, 18]
     f: [19]
     
     In target, if we have p - char is not present in hash map, return -1
     If curent char is a in target, check closest index which is closest to 0 in s pointer. Move t pointer.and s pointer further
     is c in map, yes, get the closest no which is greater than 1 among the indices of c. It's 2, Move spointer to 2 and increment by 1. tPointer ++
     potential complexty ->
     we will be finding the next greater no in the indices array(already sorted).
     for n characters -> n log k, k= n of occurrences of character. worst case k = n, all chrs are same, so, n log n
     */
    
        func shortestWayUsingHashMap(_ source: String, _ target: String) -> Int {
            var sourceArr = Array(source)
            var targetArr = Array(target)
            var m = sourceArr.count
            var n = targetArr.count

            var map = Dictionary<Character, [Int]>()

            for i in 0..<m {
                let ch = sourceArr[i]
                if (map[ch] == nil) {
                    map[ch] = [i]
                } else {
                    map[ch]!.append(i)
                }
            }

            var count = 1
            var sp = 0
            var tp = 0
            while(tp < n) {
                let tChar = targetArr[tp]

                //in source hash map, this char is not present so return -1
                if (map[tChar] == nil) {
                    return -1
                }
                //pass list of indices and the target.
                //using bonary search, we need to find the target in the list of integers. It should be closest to sp
                let list = map[tChar]!
                var bsIdx = binarySearch(list: list, target: sp)
                if (bsIdx == list.count) {
                    count += 1
                    bsIdx = 0 //when bsIdx is out of bounds then move it to zero
                }
                sp = list[bsIdx]
                sp += 1
                tp += 1
            }
            return count
        }
        //list of indices and sPointer
        private func binarySearch(list: [Int], target: Int) -> Int {
            var low = 0
            var high = list.count - 1
            while (low <= high) {
                var mid = low + (high - low) / 2
                if (list[mid] == target) {
                    return mid
                } else if (target < list[mid]) {
                    high = mid - 1
                } else {
                    low = mid + 1
                }
            }
            //there are 2 conditions where low will give me out of bounds or just the next greater element in list.
            return low
        }
    
}

