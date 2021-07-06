// Time , Space - O(N), O(N)
/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number}
 */
var minDominoRotations = function(A, B) {
    if(!A || A.length == 0) {
        return 0;
    }
    let map = {};
    let maxFreq = 0, max = -1;
    
    for(let i=0;i<A.length;i++) {
        map = {
            ...map,
            [A[i]]: map[A[i]] ? map[A[i]] + 1 : 1
        }
        maxFreq = Math.max(maxFreq, map[A[i]]);
        if(maxFreq >= A.length) {
            max = A[i];
            break;
        }
        
        map = {
            ...map,
            [B[i]]: map[B[i]] ? map[B[i]] + 1 : 1
        }
        if(maxFreq >= A.length) {
            max = B[i];
            break;
        }
        
    }
    if(max == -1) {
        return max;
    }
    let aRot = 0, bRot = 0;
    for(let i=0;i<A.length;i++) {
        if(A[i]!=max &&B[i]!=max) {
            return -1;
        }
        if(A[i] != max) {
            aRot++;
        }
        if(B[i] != max) {
            bRot++;
        }
    }
    
    return Math.min(aRot, bRot);
    
    
};
