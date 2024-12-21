/**
 * @param {number[]} tops
 * @param {number[]} bottoms
 * @return {number}
 */
// var minDominoRotations = function(tops, bottoms) {
//     let map = new Map();
//     let target = -1;
//     let le = tops.length;

//     for(let i = 0; i < tops.length; i++){
//         map.set(tops[i], (map.get(tops[i]) ?? 0) +1);
//         if(map.get(tops[i]) >= le) {
//             target = tops[i];
//             break;
//         }
//         map.set(bottoms[i], (map.get(bottoms[i]) ?? 0) + 1);
//         if(map.get(bottoms[i]) >= le) {
//             target = bottoms[i];
//             break;
//         }
//     }

//     let tRot = 0;
//     let bRot = 0;
//     for(let i = 0; i < le; i++) {
//         if(tops[i] !== target && bottoms[i] !== target) return -1;
//         if(tops[i] !== target) tRot++;
//         if(bottoms[i] !== target) bRot++;
//     }

//     return Math.min(tRot, bRot);
// };


//Another approach: With one pass
var minDominoRotations = function(tops, bottoms) {
    let map = new Map();
    let target = -1;
    let le = tops.length;

    let check = function(tops, bottoms, target)  {
        let tRot = 0;
        let bRot = 0;

        for(let i = 0; i < tops.length; i++) {
            if(tops[i] !== target && bottoms[i] !== target) return -1;
            if(tops[i] !== target) tRot++;
            if(bottoms[i] !== target) bRot++;
         }

         return Math.min(tRot, bRot);
    }

    let re = check(tops, bottoms, tops[0]);
    if(re !== -1) return re;
    return check(tops, bottoms, bottoms[0]);

}