/**
 * @param {string} source
 * @param {string} target
 * @return {number}
 */
var shortestWay = function(source, target) {
    let i = 0;
    let j = 0;
    let count = 0;
    let set = new Set(source);

    for(let char of target) {
        if(!set.has(char)){
            return -1;
        }
    }

    while(j < target.length) {
        i = 0;
        count++;
        
        while(i < source.length && j < target.length) {
            if(source[i] === target[j]) {
                j++;
            }
            i++;
        }
    }
    return count;
};