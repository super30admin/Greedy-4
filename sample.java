//Problem 1 Min path form string
// Time Complexity : O(n + mlogk) k=avg frequency of a character in source string 
// Space Complexity : O(k) -> worst case O(m) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// keep track of every occurrence of a character and its index in the source string in a hashmap
// now check number of increasing index subsequence groups, return number of groups at the end
class Solution {
    //O(n+mlogk) k=avg length of a group O(m)
    public int shortestWay(String source, String target) {
        int count=1;
        int m=target.length(), n=source.length();
        int i=0;//source
        int j=0;//target
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int k=0;k<n;k++){
            char c=source.charAt(k);
            if(!map.containsKey(c))
                map.put(c, new ArrayList<>());
            map.get(c).add(k);
        }
        while(j<m){
            char tChar=target.charAt(j);
            if(!map.containsKey(tChar)) return -1;
            List<Integer> li=map.get(tChar);
            int k=Collections.binarySearch(li, i);
            if(k<0){
                k=-k-1;
            }
            if(k==li.size()){
                count++;
                i=li.get(0);
            }else{
                i=li.get(k);
                i++;
                j++;
                if(j==m) return count;
            }

            
        }//while
        return -1;
    }
}

//Problem 2 Equal Row for minimum domino rotations
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// check if there is a similar number in the target!, if yes search top rotation and bottom rotation number, return min from both
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res=check(tops, bottoms, tops[0]);
        if(res!=-1) return res;
            return check(tops, bottoms, bottoms[0]);

    }
    //O(n) O(1)
    private int check(int[] tops, int[] bottoms, int target){
        int tRot=0, bRot=0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=target && bottoms[i]!=target){
                return -1;
            }

            if(tops[i]!=target){
                tRot++;
            }
            if(bottoms[i]!=target){
                bRot++;
            }
        }
        return Math.min(tRot, bRot);
    }
}