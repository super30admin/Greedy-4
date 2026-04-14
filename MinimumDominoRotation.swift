//
//  MinimumDominoROtation.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/20/26.
//

/*
 the count of a number should be equal to or greater than 6.
 If 4 4s, 4 3s or 3 2s, it can;t be made neither at the top nor at the bottom.
 We should have a number greater than or equal to 6
 So, count the numbers and create a hashmap.
 [2 1 2 4 2 2]
 [5 2 6 2 3 2]
 2 is a potential candidate to make either at the top or bottom. But not ceessariliy
 then iterate and chec if 2 is their either at the top or at the bottom. If it's not there, return -2.
 If one of them has, it's fine
 keep rorationForTop - _ + 1 + _ + 1 + _ + _ = 2
 ratationForBottom - 1 + _ + 1 + _ + 1 + _ = 3
 take minimum(2, 3) = 2 - reault
 
 If we have 2 potential candidates - take any of it
 222222,
 555555
 can take any of it. For 2, rotation required for top - 0, for bottom - 6 -> take min(0, 6) = 0
 take 5 -> rotation at top - 6, bottom - 0 -> take min(0, 6) = 0
 
 If 1 is not working then other one will also not work
 222555
 222555 -> they
 
222525
252555 -> both will fail here
 If they fail, they fail togere. If they pass, they pass together with the same no of rotations.
 
 Time complexity -> O(2n)
 O(n) - for creating hash map
 O(n) - For taking the number of rotations
 space compelxity -> O(1), only fix numbers in the map. 1 to 6 numbers.
 */
class MinimumDominoRotation {
    
    init() {
        
    }
    
    func minDominoRotations(_ tops: [Int], _ bottoms: [Int]) -> Int {
        var map = Dictionary<Int, Int>()
        var target = -1
        let n = tops.count
        for i in 0..<n {
            var t = tops[i]
            map[t, default: 0] += 1
            if (map[t] == n) {
                //if the count of any no is 6 then target will be t
                //means try to find the rotations needed for t
                target = t
                break
            }

            var b = bottoms[i]
            map[b, default: 0] += 1
            if (map[b] == n) {
                target = b
                break
            }
            //we can take either t or b - any of it.
        }

        if (target == -1) {
            return -1
        }
        var rotForTop = 0
        var rotForBottom = 0
        for i in 0..<n {
            if (tops[i] != target && bottoms[i] != target) {
                return -1
            }
            if (tops[i] != target) {
                rotForTop += 1
            }
            if (bottoms[i] != target) {
                rotForBottom += 1
            }
        }
        return min(rotForTop, rotForBottom)
    }
    
    /*
     approach 2 - without keeping track of the count of no. without hashmap
     Just choose between the first pair elements (from tops and bottoms), and check if it's the target, If it's not present in the folowing pairs means it's not target, return -1 and look for another element.
     */
    
    //amortized O(n) - 1 pass can be truncated in between only. If it goes till the end then we get the result
    func minDominoRotationsWithoutHashMap(_ tops: [Int], _ bottoms: [Int]) -> Int {

        let rotForTop = check(tops: tops, bottoms: bottoms, target: tops[0])
        if (rotForTop != -1) {
            return rotForTop
        }

        return check(tops: tops, bottoms: bottoms, target: bottoms[0])
    }

    private func check(tops: [Int], bottoms: [Int], target: Int) -> Int {
        var n = tops.count
        var rotForTop = 0
        var rotForBottom = 0
        for i in 0..<n {
            if (tops[i] != target && bottoms[i] != target) {
                return -1
            }
            if (tops[i] != target) {
                rotForTop += 1
            }
            if (bottoms[i] != target) {
                rotForBottom += 1
            }
        }
        return min(rotForTop, rotForBottom)
    }


}
